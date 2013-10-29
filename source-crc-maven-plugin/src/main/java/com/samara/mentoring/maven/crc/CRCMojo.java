package com.samara.mentoring.maven.crc;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.tools.ant.DirectoryScanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;

/**
 * Performs a checksum calculation for project source files
 */
@Mojo(name = "calc-checksum", defaultPhase = LifecyclePhase.PROCESS_SOURCES)
public class CRCMojo extends AbstractMojo {
    @Parameter(readonly = true, defaultValue = "${project.compileSourceRoots}")
    private List<String> compileSourceRoots;

    @Parameter
    private Set<String> includes = new HashSet<String>();

    @Parameter
    private Set<String> excludes = new HashSet<String>();

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        DirectoryScanner scanner = new DirectoryScanner();
        scanner.setIncludes(includes.isEmpty() ? new String[] {"**/*"} : includes.toArray(new String[0]));
        scanner.setExcludes(excludes.toArray(new String[0]));
        Checksum checksum = new CRC32();
        byte[] tempBuf = new byte[128];
        for(String sourceRoot : compileSourceRoots) {
            if(!(new File(sourceRoot)).exists()) continue;
            processSourceRoot(scanner, checksum, tempBuf, sourceRoot);
        }
        getLog().info("CRC32 checksum is " + checksum.getValue());
    }

    private void processSourceRoot(DirectoryScanner scanner, Checksum checksum, byte[] tempBuf, String sourceRoot) throws MojoFailureException {
        FileInputStream is = null;
        CheckedInputStream cis = null;
        scanner.setBasedir(sourceRoot);
        scanner.scan();
        for (String file : scanner.getIncludedFiles()) {
            getLog().info("    process calculations on file: " + file);
            try {
                is = new FileInputStream(sourceRoot + File.separator + file);
                cis = new CheckedInputStream(is, checksum);
                while (cis.read(tempBuf) >= 0) {}
            } catch (Exception e) {
                throw new MojoFailureException("IO exception", e);
            } finally {
                if (cis != null) {
                    try {
                        cis.close();
                    } catch (IOException ioe) {}
                }
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException ioe) {}
                }
            }
        }
    }
}
