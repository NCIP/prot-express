Here is a summary of the mvn tasks that are useful when working with ProtExpress:

mvn clean   -- deletes the target directory
mvn hibernate3:hbm2ddl  -- Generates the hibernate drop / create schema sql script (but does not execute it!!), requires running compile first.
mvn sql:execute  -- Executes the hibernate drop / create schema script and any bootstrap sql scripts
mvn -Pnuke-db sql:execute -- Drop & Create DB and DB User
mvn site  -- builds the project website and runs all of the different test and report items configured
mvn package  -- builds the war file
mvn war:exploded  -- builds the exploded war file, but does not package it in to a war  (as the deploy targets
        below deploy tell tomcat to point at the exploded war at runtime, this is useful to copy the jsp's to
        the running app without redeploying the application)
mvn tomcat:deploy  -- deploys the context.xml file to tomcat (which tells tomcat to use the exploded war directory
        as the docBase directory)
mvn tomcat:undeploy  -- undeploys the application from tomcat
mvn tomcat:redeploy   -- redploys the application to tomcat (does not seem to be as reliable as tomcat:undeploy tomcat:deploy)
mvn verify -- checks that all required metrics are met

In addition to these commands, you can use -P<comma-separated list of profile names(ids)> to specify which profiles to use.

For example, this command would use the local and noLdap profiles to do a clean build and deploy and generate the project site

mvn -Plocal,noLdap clean site hibernate3:hbm2ddl sql:execute tomcat:deploy

==========
SVN Diff:
==========
svn diff -x -bw --no-diff-deleted -x --ignore-eol-style > diff.diff

============================
Tomcat v5.5.20
(http://archive.apache.org/dist/tomcat/tomcat-5/v5.5.20/bin/apache-tomcat-5.5.20.zip)
=============================
To install tomcat do the following:
mvn -PinstallTomcat -Dmaven.test.skip=true clean package
mvn -PinstallTomcat clean  -- Blows away your Tomcat Home directory
mvn -PinstallTomcat validate -- Performs the base installation of tomcat w/ customization
mvn -PinstallTomcat package -- copies over filtered resources and additional tomcat scripts

** You can override the install location by altering the tomcat.home.parent property value using:
 - -Dtomcat.home.parent=<yourpath>
 - using your own profiles.xml
 
Patch 5.5.20's common/lib/naming-factory.jar from -- http://archive.apache.org/dist/tomcat/tomcat-5/v5.5.17/bin/apache-tomcat-5.5.17.zip
Download http://mirrors.ibiblio.org/pub/mirrors/maven2/postgresql/postgresql/8.1-407.jdbc3/postgresql-8.1-407.jdbc3.jar to CATALINA_HOME\common\lib
Download http://repository.jboss.org/maven2/javax/activation/activation/1.0.2/activation-1.0.2.jar to CATALINA_HOME\common\lib
Download http://repo1.maven.org/maven2/javax/mail/mail/1.4/mail-1.4.jar to CATALINA_HOME\common\lib
Download http://repository.jboss.org/maven2/javax/xml/bind/jaxb-api/2.1/jaxb-api-2.1.jar to CATALINA_HOME\common\endorsed
