# Eclipse Starter for Jakarta EE 10 in WildFly 27.0.0.Final

This project is a simple Jakarta EE 10 application that can be run on WildFly 27.0.0.Final.

## Deploying to WildFly using the WildFly Maven Plugin
```
./mvnw clean package wildfly:run
```
Then you need to open traget/server/wildfly-27.0.0.Final/standalone/configuration/standalone.xml and add the following lines:

```xml
<datasources>
                <datasource jndi-name="java:jboss/datasources/ExampleDS" pool-name="ExampleDS" enabled="true" use-java-context="true" statistics-enabled="${wildfly.datasources.statistics-enabled:${wildfly.statistics-enabled:false}}">
                    <connection-url>jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=${wildfly.h2.compatibility.mode:REGULAR}</connection-url>
                    <driver>h2</driver>
                    <security>
                        <user-name>sa</user-name>
                        <password>sa</password>
                    </security>
                </datasource>
                <datasource jndi-name="java:/MySqlDS" pool-name="MySqlDS">
                    <connection-url>jdbc:mysql://10.0.1.103:3306/arquitectura</connection-url>
                    <driver-class>com.mysql.cj.jdbc.Driver</driver-class>
                    <driver>mysql</driver>
                    <security>
                        <user-name>arqui</user-name>
                        <password>arqui</password>
                    </security>
                    <validation>
                        <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLValidConnectionChecker"/>
                        <validate-on-match>true</validate-on-match>
                        <exception-sorter class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLExceptionSorter"/>
                    </validation>
                </datasource>
                <drivers>
                    <driver name="h2" module="com.h2database.h2">
                        <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
                    </driver>
                    <driver name="mysql" module="com.mysqldatabase.mysql">
                        <driver-class>com.mysql.cj.jdbc.Driver</driver-class>
                        <xa-datasource-class>com.mysql.cj.jdbc.MysqlXADataSource</xa-datasource-class>
                    </driver>
                </drivers>
            </datasources>

```
Note: You need to add the module mysql-connector-java-8.0.23.jar in the folder modules/system/layers/base/com/mysqldatabase/mysql/main/module.xml
Include in the main folder the following lines:
mysql-connector-java-8.0.29.jar is the driver of the database mysql extracted from the following link: https://dev.mysql.com/downloads/connector/j/

Include in the module.xml the following lines:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<module name="com.mysqldatabase.mysql" xmlns="urn:jboss:module:1.9">

    <resources>
        <resource-root path="mysql-connector-java-8.0.29.jar"/>
    </resources>

    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
        <module name="java.compiler"/>
        <module name="java.desktop"/>
        <module name="java.instrument"/>
        <module name="java.logging"/>
        <module name="java.management"/>
        <module name="java.naming"/>
        <module name="java.scripting"/>
        <module name="java.sql"/>
        <module name="java.transaction.xa"/>
        <module name="javax.persistence.api"/>
    </dependencies>

</module>
```

```
Once you have done that, you can run the project with the following command:
```
```
./mvnw package wildfly:run
```
Then you can access the application at http://localhost:8080/jakartaee-hello-world/

## Deploying to WildFly 27.0.0.Final using the .war file

You need to configure the datasource in the standalone.xml file as explained above.

Download WildFly 27.0.0.Final from https://wildfly.org/downloads/

Then you can deploy the application using the following command:
```
sudo ./standalone.sh
```
Compile the project
```
./mvnw clean package
```
Enter to the admin console at http://localhost:9990/console/App.html#deployments

Click on the button "Add Content" and select the file target/jakartaee-hello-world.war

Click on the button "Deploy"

Then you can access the application at http://localhost:8080/jakartaee-hello-world/
```
## License

This project is licensed under the Apache License, Version 2.0. See [LICENSE](LICENSE) for more information.
