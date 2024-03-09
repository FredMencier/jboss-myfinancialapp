# EAP6 MyFinancialApp

Application JEE EAP 6.4
- Module EAR
  - Packaging de l'app
- Module EJB
  - EJB 3.0 Business (Stateless et Stateful)
- Module WAR
  - Servlet

Local JBoss EAP Server
-------------------------

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

Mettre le jdk8 en premier dans le path
- PATH="/usr/local/opt/openjdk@8/bin:$PATH"

Start the JBoss EAP Server
-------------------------

        For MacOS:   EAP_HOME/bin/standalone.sh

EAP_HOME = /Users/fmencier/Projects/jboss-eap-6.4
 
Build and Deploy
---------------

Build du projet sans les tests :

        mvn clean install -DskipTests

Deploy du projet

        mvn jboss-as:deploy

Déploie le fichier  `jboss-myfinancialapp/MyFinancial/target/MyFinancial-1.0.0-SNAPSHOT.ear` sur l'instance du server jboss.


Access the application 
---------------------

URL de l'application : <http://localhost:8085/MyFinancialWeb/FinancialServlet>. 


Undeploy the Archive
--------------------

Undeploy l'allipcation

        mvn jboss-as:undeploy

Debug the Application
------------------------------------



Sonar localhost
------------------------------------
- Install dir : /Users/fmencier/Projects/sonarqube-10.4.1/bin/macosx-universal-64
- Start : ./sonar.sh console
- user : admin
- password : sonar

URL de l'application : <http://localhost:9000/projects>