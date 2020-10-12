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

    ```SQL
    CREATE USER 'jmtrain_user'@'localhost' IDENTIFIED BY 'jmtrain_pass';
    ```
2) Configure credentials for created user.

    ```SQL
   GRANT ALL PRIVILEGES ON * . * TO 'jmtrain_user'@'localhost';
    ```
3) Quit with console and log in again (password: jmtrain_pass):
    ```cmd
   mysql -u jmtrain_user -p
    ```
3) Create database and use it.

    ```SQL
   CREATE DATABASE JMTrainDB;
   USE JMTrainDB;
    ```    
3) Create tables from SQL files.

    ```SQL
    CREATE TABLE Profiles(
        id BIGINT unsigned NOT NULL AUTO_INCREMENT,
        email VARCHAR(45) NOT NULL UNIQUE,
        password VARCHAR(60) NOT NULL,
        ip INT(4) unsigned NOT NULL,
        token VARCHAR(45) UNIQUE,
        regstamp TIMESTAMP NOT NULL DEFAULT now(),
        confstamp TIMESTAMP DEFAULT NULL,
        role ENUM('admin', 'trainer', 'attendee') NOT NULL,
        active INT(11) DEFAULT NULL,
    PRIMARY KEY (id)
    );
    
    CREATE TABLE Attendees(
        id BIGINT unsigned NOT NULL AUTO_INCREMENT,
        idprof BIGINT unsigned NOT NULL UNIQUE,
        name VARCHAR(60) NOT NULL,
        surname VARCHAR(60) NOT NULL,
        phone VARCHAR(20) NOT NULL UNIQUE,
        city VARCHAR(30) NOT NULL,
        postcode VARCHAR(10),
        street VARCHAR(60) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (idprof) REFERENCES Profiles(id) ON DELETE CASCADE
    );
    
    CREATE TABLE Courses(
        id BIGINT unsigned NOT NULL AUTO_INCREMENT,
        title VARCHAR(60) NOT NULL,
        start_date TIMESTAMP NOT NULL,
        end_date TIMESTAMP NOT NULL,
        describtion TEXT,
        max_attende SMALLINT,
    PRIMARY KEY(id)
    );
    
    CREATE TABLE Workplace(
        id BIGINT unsigned NOT NULL AUTO_INCREMENT,
        name VARCHAR(60),
        city VARCHAR(30) NOT NULL,
        street VARCHAR(60) NOT NULL,
        floor SMALLINT(2),
        room SMALLINT(3),
    PRIMARY KEY (id)
    );
    
    CREATE TABLE Subscribtions (
        id BIGINT unsigned NOT NULL AUTO_INCREMENT,
        idcour BIGINT unsigned NOT NULL,
        idworkpl BIGINT unsigned NOT NULL,
        idattend BIGINT unsigned NOT NULL,
        regstamp TIMESTAMP NOT NULL DEFAULT now(),
     PRIMARY KEY (id),
     FOREIGN KEY (idcour) REFERENCES Courses(id) ON DELETE CASCADE,
     FOREIGN KEY (idworkpl) REFERENCES Workplace(id) ON DELETE CASCADE,
     FOREIGN KEY (idattend)  REFERENCES Attendees(id) ON DELETE CASCADE
    );
    ```
4) Insert sample data from SQL file.

    ```SQL
    INSERT INTO Profiles (email, password, role, ip) VALUES (
       'agnieszka.lasota2@vp.pl', 'laska37', 'attendee', INET_ATON('10.1.220.76')
    );
    
    INSERT INTO Profiles (email, password, role, ip) VALUES (
       'kamil.cecherz@gmail.com', 'Alfaromeo88a', 'admin', INET_ATON('15.10.221.16')
    );
    
    INSERT INTO Profiles (email, password, role, ip) VALUES (
       'bed46@wp.pl', 'Zaradny33', 'trainer', INET_ATON('10.1.220.77')
    );
    
    INSERT INTO Profiles (email, password, role, ip) VALUES (
       'wolnygosc@interia.pl', 'adamos88', 'trainer', INET_ATON('10.19.220.76')
    );
    
    INSERT INTO Profiles (email, password, role, ip) VALUES (
       'a.kowal16@tlen.pl', 'DaS3Ek#', 'attendee', INET_ATON('100.10.220.76')
    );
    
    INSERT INTO Profiles (email, password, role, ip) VALUES (
       'radekignasiak13@onet.pl', 'OleniuniaMoja', 'attendee', INET_ATON('108.19.30.76')
    );
    
    INSERT INTO Profiles (email, password, role, ip) VALUES (
       'm.wlazlak@wsparciespoleczne.pl', 'W44#00Abc', 'attendee', INET_ATON('34.22.22.1')
    );
    
    INSERT INTO Attendees (idprof, name, surname, phone, city, postcode, street) VALUES (
       1, 'Agnieszka', 'Lasota', '+48 609 383 855', 'Ksawerów', '95-054', 'Wschodnia 26'
    );
    
    INSERT INTO Attendees (idprof, name, surname, phone, city, postcode, street) VALUES (
       2, 'Kamil', 'Cecherz', '+48 798 996 422', 'Łódź', '96-018', 'Powstańców Wielkopolskich 24/17'
    );
    
    INSERT INTO Attendees (idprof, name, surname, phone, city, postcode, street) VALUES (
       3, 'Łukasz', 'Bednarski', '+48 786 207 883', 'Łęczyca', '99-100', 'Ozorkowska 9'
    );
    
    INSERT INTO Attendees (idprof, name, surname, phone, city, postcode, street) VALUES (
       4, 'Adam', 'Wolniewicz', '+48 693 044 971', 'Łódź', '90-001', 'Komandorska 3/2'
    );
    
    INSERT INTO Attendees (idprof, name, surname, phone, city, postcode, street) VALUES (
       5, 'Adam', 'Kowalewski', '+48 602 732 532', 'Tomaszów Mazowiecki', '97-200', 'Głowackiego 19a/55'
    );
    
    INSERT INTO Attendees (idprof, name, surname, phone, city, postcode, street) VALUES (
       6, 'Radosław', 'Ignasiak', '+48 506 601 295', 'Łódź', '90-001', 'Leopolda Tyrmanda 104/22'
    );
    
    INSERT INTO Attendees (idprof, name, surname, phone, city, postcode, street) VALUES (
       7, 'Małgorzata', 'Wlaźlak', '+48 796 141 420', 'Warszawa', '02-321', 'Aleje Jerozolimskie 107a/3'
    );
    
    INSERT INTO Courses (title, start_date, end_date, describtion, max_attende) VALUES (
        'Nowoczesne aplikacje w Java EE',
        '2019-05-20 14:30:00',
        '2019-07-20 16:00:00',
        'Tworzenie aplikacji z wykorzystaniem JDBC, Servletów, MYSQL, JSP',
        12
    );
    
    INSERT INTO Courses (title, start_date, end_date, describtion, max_attende) VALUES (
        'Podstawy HTML I CSS',
        '2019-05-20 18:30:00',
        '2019-05-25 18:30:00',
        'Nauka tworzenia stron WWW od podstaw, FTP',
        30
    );
    
    INSERT INTO Courses (title, start_date, end_date, describtion, max_attende) VALUES (
        'Analiza danych tekstowych i języka naturalnego (Python)',
        '2019-07-10 12:30:00',
        '2019-07-13 17:00:00',
        'Nauczenie szeregu narzędzi do pracy z danymi tekstowymi, przedstawienie szeregu
        przykładów użycia pokrywających większość tematów tej dziedziny.',
        10
    );
    
    INSERT INTO Workplace (name, city, street, floor, room) VALUES (
       'Urbanica',
       'Łódź',
       'Wróblewskiego 18',
       8,
       302
    );
    
    INSERT INTO Workplace (name, city, street, floor, room) VALUES (
       'Sages sp. z.o.o',
       'Warszawa',
       'Nowogródzka 62c',
       null,
       null
    );
    
    INSERT INTO Subscribtions(idcour, idworkpl, idattend) VALUES (
       1, 1, 2
    );
    
    INSERT INTO Subscribtions(idcour, idworkpl, idattend) VALUES (
       2, 2, 1
    );  
    
    INSERT INTO Subscribtions(idcour, idworkpl, idattend) VALUES (
       2, 2, 5
    ); 
    
    INSERT INTO Subscribtions(idcour, idworkpl, idattend) VALUES (
       2, 2, 6
    );
    ```    
5) Update sample data profiles [MD5 Hash Generator](https://www.md5hashgenerator.com/)

    ```SQL
    UPDATE PROFILES SET password="12c44a927ee9fc12f97ee80c55353780" WHERE id=1;
    UPDATE PROFILES SET password="ef21dbe084b394c9a8cd1a65fd7e54ee" WHERE id=2;
    UPDATE PROFILES SET password="36d9349a9c3b70184b209f3acf69ed03" WHERE id=3;
    UPDATE PROFILES SET password="3bfa575c4e2bd3e3470defa718dca2ed" WHERE id=4;
    UPDATE PROFILES SET password="7ffe7df02ac3ce14e7ad6c6048df1352" WHERE id=5;
    UPDATE PROFILES SET password="6e1cb029e0e57561a190af445d8287f7" WHERE id=6;
    UPDATE PROFILES SET password="967133b87c245338e5652eae9e33e838" WHERE id=7;
    ```
6) Active manually profiles

    ```SQL
    UPDATE Profiles SET active=1;
   ```
   
## Author

* Kamil Cecherz as [pangeon](https://cecherz.pl)

## License


