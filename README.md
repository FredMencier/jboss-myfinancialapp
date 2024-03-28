# Migration Automatique de MyFinancialApp en EAP 6.4 vers Quarkus 3.8.2

## EAP6 MyFinancialApp

Application JEE EAP 6.4
- Module EAR
  - Packaging de l'app
- Module DA
  - Module d'accès à la base de données
- Module EJB
  - EJB 3.0 Business (Stateless et Stateful)
- Module Dto
  - Module POJO
- Module WAR
  - Servlet

Local JBoss EAP Server
-------------------------

Modification du port par défaut :
- http port : 8085

Console d'admin :
- http://localhost:9990/
- user : admin
- pwd : JbossEAP6$

For the system Java wrappers to find this JDK, symlink it with
- sudo ln -sfn /usr/local/opt/openjdk@8/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk-8.jdk

openjdk@8 is keg-only, which means it was not symlinked into /usr/local,
because this is an alternate version of another formula.

If you need to have openjdk@8 first in your PATH, run:
- echo 'export PATH="/usr/local/opt/openjdk@8/bin:$PATH"' >> /Users/fmencier/.bash_profile

Mettre le jdk8 en premier dans le path
- export PATH="/usr/local/opt/openjdk@8/bin:$PATH"

Start the JBoss EAP Server
-------------------------

        For MacOS:   EAP_HOME/bin/standalone.sh

EAP_HOME = /Users/fmencier/Projects/jboss-eap-6.4
 
Build and Deploy the Archive
---------------------------

Build du projet sans les tests :

`mvn clean install -DskipTests`

Deploy du projet

`mvn jboss-as:deploy`

Déploie le fichier  `jboss-myfinancialapp/MyFinancial/target/MyFinancial-1.0.0-SNAPSHOT.ear` sur l'instance du server jboss.


Access the application 
---------------------

URL de la servlet : <http://localhost:8085/MyFinancialWeb/FinancialServlet>
URL de l'API Rest : <http://localhost:8085/MyFinancialWeb/rest/getAvailableCurrencies>


Undeploy the Archive
--------------------

Undeploy l'allipcation

`mvn jboss-as:undeploy`

Debug the Application
------------------------------------

TODO

Sonar localhost
------------------------------------
- Install dir : /Users/fmencier/Projects/sonarqube-10.4.1/bin/macosx-universal-64
- Start : ./sonar.sh console
- user : admin
- password : sonar

URL de Sonar : <http://localhost:9000/projects>


## Quarkus MyFinancialApp

Application Quarkus 3.8.2
- Conservation des Modules sauf le Module EAR


Local JBoss EAP Server
-------------------------

Modification du port par défaut :
- http port : 8081

Start the JBoss EAP Server
-------------------------

`mvn clean install quarkus:dev`

Access the application

URL de la servlet : <http://localhost:8081/FinancialServlet>
URL de l'API Rest : <http://localhost:8081/rest/currency/currencies>


-> Servlet mettre un fond d'écran Devoxx
-> voir si possible d'ajouter un bean dans le consructeur de FinancialAPI
-> voir si possible d'appeler FindAndReplace depuis le code en paramétrant MyFinancialWeb
