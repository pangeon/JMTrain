INSERT INTO Profiles (email, password, role) VALUES (
	'agnieszka.lasota1@vp.pl', 'laska37', 'attendee'
);
INSERT INTO Profiles (email, password, role) VALUES (
    'kamil.cecherz@gmail.com', 'Alfaromeo88a', 'admin'
);
INSERT INTO Profiles (email, password, role) VALUES (
    'bed46@wp.pl', 'Zaradny33', 'trainer'
);
INSERT INTO Profiles (email, password, role) VALUES (
    'wolnygosc@interia.pl', 'adamos88', 'trainer'
);
INSERT INTO Profiles (email, password, role) VALUES (
    'a.kowal16@tlen.pl', 'DaS3Ek#', 'attendee'
);
INSERT INTO Profiles (email, password, role) VALUES (
    'radekignasiak13@onet.pl', 'OleniuniaMoja', 'attendee'
);
INSERT INTO Profiles (email, password, role) VALUES (
    'm.wlazlak@wsparciespoleczne.pl', 'W44#00Abc', 'attendee'
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
INSERT INTO Courses (trainer, title, start_date, end_date, describtion, max_attende) VALUES (
	3,
    'Nowoczesne aplikacje w Java EE',
    '2019-05-20 14:30:00',
    '2019-07-20 16:00:00',
    'Tworzenie aplikacji z wykorzystaniem JDBC, Servletów, MYSQL, JSP',
    12
);
INSERT INTO Courses (trainer, title, start_date, end_date, describtion, max_attende) VALUES (
	3,
    'Podstawy HTML I CSS',
    '2019-05-20 18:30:00',
    '2019-05-25 18:30:00',
    'Nauka tworzenia stron WWW od podstaw, FTP',
    30
);
INSERT INTO Courses (trainer, title, start_date, end_date, describtion, max_attende) VALUES (
	4,
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