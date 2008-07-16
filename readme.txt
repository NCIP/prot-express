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