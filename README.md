Maven module
============

1. Create Maven repository in bintray for publishing releases - http://dl.bintray.com/ninjafrombox/repo
2. Run Nexus instance in OpenShift - http://nexus-ninjafrombox.rhcloud.com/nexus/ . Add 2 hosted repositories: snapshots and 3rd party. Add public group.
3. Set up root pom for using bintray repo and nexus public group - deploy-parent/pom.xml
4. Create multi-module project, add javadocs and unit tests - book-cms-parent
5. Generate maven site with reports - http://ninjafrombox.github.io/book-cms
6. Configure prod profile - book-cms-parent/pom.xml
7. Use environment variables (or Java system properties) - book-cms-parent/pom.xml (see 'site.location' property)
8. Write maven plugin - source-crc-maven-plugin
9. Write archetype for maven plugin - maven-plugin-archetype