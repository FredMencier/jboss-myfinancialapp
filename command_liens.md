EAP6
----

Compilation et packaging du EAR file pour EAP6
`mvn clean package`

EAP6 Server
http://localhost:9990/console/App.html#home
EAP6 App
http://localhost:8085/MyFinancialWeb/FinancialServlet

Start des recettes de migration vers Quarkus (./simulate_migra_to_quarkus.sh)
`mvn clean package -Drewrite.recipeArtifactCoordinates="org.example:test-lib-rewrite:1.0.0-SNAPSHOT,org.openrewrite.recipe:rewrite-testing-frameworks:2.3.0,org.openrewrite.recipe:rewrite-migrate-java:2.7.0" -Drewrite.activeRecipes="org.fin.migrateToQuarkus.pom,org.fin.migrateToQuarkus.EJB,org.fin.migrateToQuarkus.properties,org.fin.migrateToQuarkus.javaxToJakarta,org.fin.migrateToQuarkus.pom.clean,org.fin.migrateToQuarkus.java.clean" org.openrewrite.maven:rewrite-maven-plugin:5.19.0:dryRun`


Quarkus
----

Compilation et start de Quarkus
`mvn clean package quarkus:dev`

Quarkus dev-u[rewrite.patch](target%2Frewrite%2Frewrite.patch)i
http://localhost:8081/q/dev-ui/extensions
Quarkus App
http://localhost:8081/FinancialServlet

`mvn clean package -Drewrite.recipeArtifactCoordinates="org.example:test-lib-rewrite:1.0.0-SNAPSHOT" -Drewrite.activeRecipes="org.exemple.rest.BlockingToReactiveRest" org.openrewrite.maven:rewrite-maven-plugin:5.19.0:dryRun`