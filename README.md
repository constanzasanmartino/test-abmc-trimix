# ABMC TRIMIX TEST 
---------------------

###Tecnologías utilizadas
* Git
* jdk-8
* MySql
* Maven
* Spring
* Hibernate
* Tomcat embebido de maven

### Build + Deploy + Run application (sobre la raiz del proyecto)
* mvn clean install 
* mvn tomcat7:run 
* mvn -Dmaven.tomcat.port=8888 tomcat7:run (para cambiar el puerto por defecto)
