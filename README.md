# EAP6 MyFinancial SampleApp 

Modification du port par défaut :
- http port : 8085
- user : admin
- pwd : RedHatJboss1234$

For the system Java wrappers to find this JDK, symlink it with
- sudo ln -sfn /usr/local/opt/openjdk@8/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-8.jdk

openjdk@8 is keg-only, which means it was not symlinked into /usr/local,
because this is an alternate version of another formula.

If you need to have openjdk@8 first in your PATH, run:
- echo 'export PATH="/usr/local/opt/openjdk@8/bin:$PATH"' >> /Users/fmencier/.bash_profile

Start the JBoss EAP Server
-------------------------

        For MacOS:   EAP_HOME/bin/standalone.sh

EAP_HOME = /Users/fmencier/Projects/jboss-eap-6.4
 
Build and Deploy the Quickstart
-------------------------

_NOTE: The following build command assumes you have configured your Maven user settings. If you have not, you must include Maven setting arguments on the command line. See [Build and Deploy the Quickstarts](../README.md#build-and-deploy-the-quickstarts) for complete instructions and additional options._

1. Make sure you have started the JBoss EAP server as described above.
2. Open a command prompt and navigate to the root directory of this quickstart.
3. Type this command to build and deploy the archive:

        mvn clean install jboss-as:deploy

4. This will deploy `target/jboss-helloworld.war` to the running instance of the server.


Access the application 
---------------------

URL de l'application : <http://localhost:8080/jboss-helloworld>. 


Undeploy the Archive
--------------------

1. Make sure you have started the JBoss EAP server as described above.
2. Open a command prompt and navigate to the root directory of this quickstart.
3. When you are finished testing, type this command to undeploy the archive:

        mvn jboss-as:undeploy


Run the Quickstart in JBoss Developer Studio or Eclipse
-------------------------------------
You can also start the server and deploy the quickstarts from Eclipse using JBoss tools. For more information, see [Use JBoss Developer Studio or Eclipse to Run the Quickstarts](https://github.com/jboss-developer/jboss-developer-shared-resources/blob/master/guides/USE_JDBS.md#use-jboss-developer-studio-or-eclipse-to-run-the-quickstarts) 


Debug the Application
------------------------------------

If you want to debug the source code or look at the Javadocs of any library in the project, run either of the following commands to pull them into your local repository. The IDE should then detect them.

        mvn dependency:sources
        mvn dependency:resolve -Dclassifier=javadoc


Sonar localhost
------------------------------------
- Install dir : /Users/fmencier/Projects/sonarqube-10.4.1/bin/macosx-universal-64
- Start : ./sonar.sh console
- user : admin
- password : sonar

URL de l'application : <http://localhost:9000/projects>