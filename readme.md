# JMTrain - Java course manager

## Description

## Changelog

## Requirements

### Software

* Java
    * [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk15-downloads.html) (better option on **Windows**)
    * [OpenJDK](https://openjdk.java.net/install/) (better option on **Linux**)
* Database engine:
    * [MySQL Server](https://dev.mysql.com/downloads/windows/installer/8.0.html).
    * MariaDB part of [XAMPP](https://www.apachefriends.org/pl/download.html).
* [Tomcat 7](https://tomcat.apache.org/download-70.cgi) - HTTP server for Java
* [Maven](http://maven.apache.org/download.cgi) integrated with your IDE.

### Maven dependencies

* mysql-connector-java 8.0.16
* javax.servlet-api 4.0.1
* commons-logging 1.2
* spring-beans 4.1.4.RELEASE
* spring-core 4.3.21.RELEASE
* spring-jdbc 4.1.4.RELEASE
* spring-tx 4.1.4.RELEASE
* taglibs-standard-impl 1.2.1
* taglibs-standard-spec 1.2.1

## Deployment guide
#### General information
1) Download and unpack **JDK** from 
[Oracle](https://www.oracle.com/java/technologies/javase-jdk15-downloads.html)
(Windows x64 Compressed Archive)
2) Add Java to the PATH on **Windows 10** - [HELP](https://www.architectryan.com/2018/03/17/add-to-the-path-on-windows-10)
3) Clone repository using **GIT** or download zip archive.
4) Open project in your favourite IDE or compile class from command line.

#### Open project using IntelliJ IDEA
1) Download [IntelliJ IDEA Community](https://www.jetbrains.com/idea/)
2) Clone project from Github - [HELP](https://www.jetbrains.com/help/idea/manage-projects-hosted-on-github.html)

#### Configuration application server using IntelliJ IDEA
1) Download and unpack **Tomcat** from 
[Apache Foundation](https://tomcat.apache.org/download-70.cgi).
2) Setting up Tomcat 7 - [Details](https://federicoponte.wordpress.com/2013/08/02/setting-up-tomcat-7-with-intellij-idea/)
    * Uncompress the folder anywhere you want
    * **Click on Run -> Edit Configurations…**
    -> Search on the left for Tomcat Server and select Local
    * **Click on Run -> Edit Configurations…** Click on the + sign
    * On server card in input **VM Options** and write: *-Djava.net.preferIPv4Stack=true*
    * Select Tomcat Server Local -> Go to Deployment tab
    * Click on the + sign, select artifact you want to add to the server.
    ![Screen 1](readme-img/1.png) ![Screen 2](readme-img/1.png) 
3) Try running application, you should see web page. In next step you must config database.

#### Add database and config connection
1) Create specific user for via MySQL console.
2) Create database and next configure credentials for it.
3) Create tables from SQL files.
4) Insert sample data from SQL file.    

## Author

* Kamil Cecherz as [pangeon](https://cecherz.pl)

## License


