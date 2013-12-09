JBoss module
============

1. Customization:
 * make changes in bin/standalone.conf.bat file:
    * set memory allocation params after line "JVM memory allocation pool parameters - modify as appropriate"
    * uncomment line after "Sample JPDA settings for remote socket debugging", change port for remote debug
 * change default ports in standalone/configuration/standalone.xml file:
    * change value of "port" attribute for "socket-binding" elements (e.g. http and management-native)
1. Configure digit security (LDAP based) in standalone/configuration/standalone.xml file:
 * set up "security-realm" for management:
    * insert &lt;ldap connection="ldap" base-dn="OU=UsersSamara,DC=samara,DC=changeme,DC=com">&lt;username-filter attribute="sAMAccountName"/>&lt;/ldap> inside "authentication" element
    * define "ldap" connection inside "outbound-connections" element: &lt;ldap name="ldap" url="ldap://changeme" search-dn="CN=changeme,OU=UsersSamara,DC=samara,DC=changeme,DC=com" search-credential="changeme"/>
    * set read-only rights for standalone/tmp/auth folder - to disable "$local"	user
 * set up "security-domain":
    * use "LdapExtended" login-module, configure "java.naming.factory.initial", "java.naming.provider.url", "java.naming.security.authentication", "bindDN", "bindCredential", "baseCtxDN", "baseFilter", "rolesCtxDN", "roleFilter", "defaultRole", "throwValidateError" properties - see org.jboss.security.auth.spi.LdapExtLoginModule (picketbox-4.0.7.Final sources)
    * use configured security domain name in application (jboss-web.xml)
1. Configuring SQLite JDBC DataSources
 * create "org.xerial.sqlite-jdbc" module
    * create folder modules/org/xerial/sqlite-jdbc/main, copy sqlite-jdbc-3.7.15-M1.jar to it
    * create module.xml (see com.h2database.h2 as example)
 * add jdbc-driver
    * /subsystem=datasources/jdbc-driver=sqlite:add(driver-module-name="org.xerial.sqlite-jdbc")
 * check list of installed drivers
    * /subsystem=datasources:installed-drivers-list
 * add datasource
    * /subsystem=datasources/data-source=ExampleDS:add(connection-url="jdbc:sqlite:${jboss.server.base.dir}/exampleDS.db",jndi-name="java:jboss/datasources/ExampleDS",driver-name="sqlite")
 * test datasource
    * /subsystem=datasources/data-source=ExampleDS:test-connection-in-pool
1. Deploy to JBoss manually. There are several ways:
 * file system deployment - copy war to standalone/deployments folder
 * deployment using CLI - deploy "c:\mentoring\book-cms-parent\book-cms-web\target\book-cms.war"
 * deployment using web console - "Runtime" tab, "Manage Deployments" menu, "Add content" button
1. Configure maven to deploy to JBoss (with security)
 * add jboss-as maven plugin (org.jboss.as.plugins:jboss-as-maven-plugin:7.5.Final) to build/plugins section
 * set "jboss-as.hostname", "jboss-as.port", "jboss-as.id" properties, configure "jboss-as" server in settings.xml
 * add "jboss-deploy" profile for war deployment at package phase
