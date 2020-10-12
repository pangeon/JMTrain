CREATE TABLE Profiles(
    id BIGINT unsigned NOT NULL AUTO_INCREMENT,
    email VARCHAR(45) NOT NULL UNIQUE,
    password VARCHAR(60) NOT NULL,
    ip INT(4) unsigned NOT NULL,
    token VARCHAR(45) UNIQUE,
    regstamp TIMESTAMP NOT NULL DEFAULT now(),
    confstamp TIMESTAMP DEFAULT NULL,
    role ENUM('admin', 'trainer', 'attendee') NOT NULL,
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

CREATE TABLE Subscription (
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

INSERT INTO Subscribtions(idcour, idworkpl, idattend) VALUES (
	2, 2, 7
); 