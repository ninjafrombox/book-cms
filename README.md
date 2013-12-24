Jenkins module
============

1. Run Jenkins
 * java -jar jenkins.war

1. Install Jenkins as Windows service
 * Manage Jenkins -> Install as Windows Service

1. Configure Global Security -> LDAP
 * configure LDAP params
    * server - LDAP url
    * root DN - DC=samara,DC=changeme,DC=com
    * user search filter - sAMAccountName={0}
 * set Manager DN and Manager Password
 * configure 'Matrix-based security'

1. Configure a CI-Project to run project building on commit
 * configure git - Repository URL, branch
 * configure SCM polling

1. Configure a running unit tests on commit
 * add maven build step - 'Invoke top-level Maven targets', goal test

1. Configure a running integration tests with scheduler
 * add maven build step - 'Invoke top-level Maven targets', goal failsafe:integration-test
 * tick 'Build periodically', set schedule (e.g. H 10,18 * * 1-5)

1. Configure 2 or more slaves
 * on master: Manage Jenkins -> Manage Nodes -> New Node (use Java Web Start as slave agent)
 * on slave: Manage Jenkins -> Manage Nodes -> 'node_name' -> click Launch button

1. Configure deploy project on JBoss
 * deployment to JBoss is configured in 'jboss-deploy' profile (book-cms-parent/book-cms-web/pom.xml)
 * add maven build step - 'Invoke top-level Maven targets', goal clean package -Pjboss-deploy
 * specify jboss management username and password, pass to maven as 'jboss-as.username', 'jboss-as.password' properties

1. Configure parameterized build to run job on selected slave
 * install 'NodeLabel Parameter Plugin'
 * tick 'This build is parameterized', add 'Node' param

1. Configure Checkstyle and findbugs
 * install Checkstyle Plugin and FindBugs Plugin
 * add Checkstyle and FindBugs maven plugins
 * add 'Publish Checkstyle analysis results' post-build action, specify path to checkstyle-result.xml
 * add 'Publish FindBugs analysis results' post-build action, specify path to findbugsXml.xml

1. Configure reporters to send emails to team
 * Manage Jenkins -> Configure System, settings: SMTP server, SMTP Authentication, SMTP Port, Reply-To Address, Charset
 * add 'E-mail Notification' post-build action

1. Try Groovy Scripting Plugin
 * install 'Groovy plugin'
 * add groovy build step - 'Execute system Groovy script'