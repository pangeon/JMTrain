INSERT INTO Profiles (email, password, role) VALUES (
	'agnieszka.lasota1@vp.pl', 'laska37', 'attendee'
);
INSERT INTO Profiles (email, password, role) VALUES (
    'kamil.cecherz@gmail.com', 'Alfaromeo88a', 'admin'
);
INSERT INTO Profiles (email, password, role) VALUES (
    'bed46@wp.pl', 'Zaradny33', 'trainer'
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
INSERT INTO Workplace (name, city, street, floor, room) VALUES (
	'Urbanica',
    'Łódź',
    'Wróblewskiego 18',
    8,
    302
);
INSERT INTO Subscribtions(idcour, idworkpl, idattend) VALUES (
	1, 1, 2
);  