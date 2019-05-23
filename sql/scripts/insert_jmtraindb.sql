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
	1, 'Agnieszka', 'Lasota', '+48 609 383 855', 'Ksawer�w', '95-054', 'Wschodnia 26'
);

INSERT INTO Attendees (idprof, name, surname, phone, city, postcode, street) VALUES (
	2, 'Kamil', 'Cecherz', '+48 798 996 422', '��d�', '96-018', 'Powsta�c�w Wielkopolskich 24/17'
);

INSERT INTO Attendees (idprof, name, surname, phone, city, postcode, street) VALUES (
	3, '�ukasz', 'Bednarski', '+48 786 207 883', '��czyca', '99-100', 'Ozorkowska 9'
);

INSERT INTO Attendees (idprof, name, surname, phone, city, postcode, street) VALUES (
	4, 'Adam', 'Wolniewicz', '+48 693 044 971', '��d�', '90-001', 'Komandorska 3/2'
);

INSERT INTO Attendees (idprof, name, surname, phone, city, postcode, street) VALUES (
	5, 'Adam', 'Kowalewski', '+48 602 732 532', 'Tomasz�w Mazowiecki', '97-200', 'G�owackiego 19a/55'
);

INSERT INTO Attendees (idprof, name, surname, phone, city, postcode, street) VALUES (
	6, 'Rados�aw', 'Ignasiak', '+48 506 601 295', '��d�', '90-001', 'Leopolda Tyrmanda 104/22'
);

INSERT INTO Attendees (idprof, name, surname, phone, city, postcode, street) VALUES (
	7, 'Ma�gorzata', 'Wla�lak', '+48 796 141 420', 'Warszawa', '02-321', 'Aleje Jerozolimskie 107a/3'
);

INSERT INTO Courses (title, start_date, end_date, describtion, max_attende) VALUES (
    'Nowoczesne aplikacje w Java EE',
    '2019-05-20 14:30:00',
    '2019-07-20 16:00:00',
    'Tworzenie aplikacji z wykorzystaniem JDBC, Servlet�w, MYSQL, JSP',
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
    'Analiza danych tekstowych i j�zyka naturalnego (Python)',
    '2019-07-10 12:30:00',
    '2019-07-13 17:00:00',
    'Nauczenie szeregu narz�dzi do pracy z danymi tekstowymi, przedstawienie szeregu
	przyk�ad�w u�ycia pokrywaj�cych wi�kszo�� temat�w tej dziedziny.',
    10
);

INSERT INTO Workplace (name, city, street, floor, room) VALUES (
	'Urbanica',
    '��d�',
    'Wr�blewskiego 18',
    8,
    302
);

INSERT INTO Workplace (name, city, street, floor, room) VALUES (
	'Sages sp. z.o.o',
    'Warszawa',
    'Nowogr�dzka 62c',
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