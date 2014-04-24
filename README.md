Publisher
=========

A simple news item management java-web application with container-managed connection pooling database scheme. 

The Publisher Java-web application allows the user to create, list, delete and update news item from MySQL database. 

To run this application you need: 
-	Eclipse or other IDE
-	Apache tomcat web container 
-	MySQL database 

The application connects to the database through a container-managed database connection pooling (i.e. connection objects are obtained through an instance of DataSource class)

Procedure:

After installing Apache tomcat web container and MySQL database server, download Mysql-java-connector jar file and place it under ${TOMCAT_HOME}/lib.  

Then open the command line client and create a database called ‘publisher’ by granting all privileges to publisher user account.
mysql> create database publisher;
mysql> grant all privileges on publisher.* to publisher@localhost identified by 'publisher';

Install eclipse and import the project to workspace. 
Locate the ant build file called build.xml in the project and run createdb and insertdb targets. 

Copy the keystore file from keystore folder inside the project and paste it to ${TOMCAT_HOME}/config

Open the server.xml file from and paste connector element block bellow.
   <Connector port="8443" protocol="HTTP/1.1" SSLEnabled="true"
               maxThreads="150" scheme="https" secure="true"
               clientAuth="false" sslProtocol="TLS" keystorePass="changeit"
			   keystoreFile="conf/keystore" />

Update the file paths in the ‘log4j.proerties’ and ‘Publisher.xml’ files to match the file path to your workspace directory. 


Export the project to a WAR file from Eclipse and move the ‘Publisher.war’ file to ${TOMCAT_HOME}/weapps 

Open a browser and visit a https://localhost:8443/Publisher/login and use username: admin, password: admin credentials to get access to the application. 
