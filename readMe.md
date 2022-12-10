# About Swagger:
'add below dependencys in pom.xml file'

<!-- Swager dependency -->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.7.0</version>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.7.0</version>
then you will get below exception while run the application.
"Failed to start bean 'documentationPluginsBootstrapper'"

To resolve above exception you need not change the spring version, add below statement in .yaml file
spring:
    mvc:
      pathmatch:
        matching-strategy: ANT_PATH_MATCHER
then launch the swagger : http://localhost:8080/swagger-ui.html

