#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Does some job
 */
@Mojo(name = "some-goal", defaultPhase = LifecyclePhase.PROCESS_RESOURCES)
public class SomeMojo extends AbstractMojo {
    @Parameter(property = "someMojo.skip", defaultValue = "false")
    private boolean skipSomeMojo;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        if(skipSomeMojo) {
            getLog().info("Skipping some mojo");
            return;
        }
        getLog().info("All done");
    }
}
