INSERT INTO Profiles (email, password, role, ip, active)
VALUES ('agnieszka.lasota2@vp.pl', '12c44a927ee9fc12f97ee80c55353780', 'attendee', INET_ATON('10.1.220.76'), 1);

INSERT INTO Profiles (email, password, role, ip, active)
VALUES ('kamil.cecherz@gmail.com', 'ef21dbe084b394c9a8cd1a65fd7e54ee', 'admin', INET_ATON('15.10.221.16'), 1);

INSERT INTO Profiles (email, password, role, ip, active)
VALUES ('bed46@wp.pl', '36d9349a9c3b70184b209f3acf69ed03', 'attendee', INET_ATON('10.1.220.77'), 1);

INSERT INTO Profiles (email, password, role, ip, active)
VALUES ('wolnygosc@interia.pl', '3bfa575c4e2bd3e3470defa718dca2ed', 'trainer', INET_ATON('10.19.220.76'), 1);

INSERT INTO Profiles (email, password, role, ip, active)
VALUES ('a.kowal16@tlen.pl', '7ffe7df02ac3ce14e7ad6c6048df1352', 'attendee', INET_ATON('100.10.220.76'), 1);

INSERT INTO Profiles (email, password, role, ip, active)
VALUES ('radekignasiak13@onet.pl', '6e1cb029e0e57561a190af445d8287f7', 'attendee', INET_ATON('108.19.30.76'), 1);

INSERT INTO Profiles (email, password, role, ip, active)
VALUES ('m.wlazlak@wsparciespoleczne.pl', '967133b87c245338e5652eae9e33e838', 'attendee', INET_ATON('34.22.22.1'), 1);

INSERT INTO Attendees (idprof, name, surname, phone, city, postcode, street)
VALUES (1, 'Agnieszka', 'Lasota', '+48 609 383 855', 'Ksawerów', '95-054', 'Wschodnia 26');

INSERT INTO Attendees (idprof, name, surname, phone, city, postcode, street)
VALUES (2, 'Kamil', 'Cecherz', '+48 798 996 422', 'Łódź', '96-018', 'Powstańców Wielkopolskich 24/17');

INSERT INTO Attendees (idprof, name, surname, phone, city, postcode, street)
VALUES (3, 'Łukasz', 'Bednarski', '+48 786 207 883', 'Łęczyca', '99-100', 'Ozorkowska 9');

INSERT INTO Attendees (idprof, name, surname, phone, city, postcode, street)
VALUES (4, 'Adam', 'Wolniewicz', '+48 693 044 971', 'Łódź', '90-001', 'Komandorska 3/2');

INSERT INTO Attendees (idprof, name, surname, phone, city, postcode, street)
VALUES (5, 'Adam', 'Kowalewski', '+48 602 732 532', 'Tomaszów Mazowiecki', '97-200', 'Głowackiego 19a/55');

INSERT INTO Attendees (idprof, name, surname, phone, city, postcode, street)
VALUES (6, 'Radosław', 'Ignasiak', '+48 506 601 295', 'Łódź', '90-001', 'Leopolda Tyrmanda 104/22');

INSERT INTO Attendees (idprof, name, surname, phone, city, postcode, street)
VALUES (7, 'Małgorzata', 'Wlaźlak', '+48 796 141 420', 'Warszawa', '02-321', 'Aleje Jerozolimskie 107a/3');

INSERT INTO Courses (title, start_date, end_date, description, max_attende)
VALUES ('Nowoczesne aplikacje w Java EE',
        '2019-05-20 14:30:00',
        '2019-07-20 16:00:00',
        'Tworzenie aplikacji z wykorzystaniem JDBC, Servletów, MYSQL, JSP',
        12);

INSERT INTO Courses (title, start_date, end_date, description, max_attende)
VALUES ('Podstawy HTML I CSS',
        '2019-05-20 18:30:00',
        '2019-05-25 18:30:00',
        'Nauka tworzenia stron WWW od podstaw, FTP',
        30);

INSERT INTO Courses (title, start_date, end_date, description, max_attende)
VALUES ('Analiza danych tekstowych i języka naturalnego (Python)',
        '2019-07-10 12:30:00',
        '2019-07-13 17:00:00',
        'Nauczenie szeregu narzędzi do pracy z danymi tekstowymi, przedstawienie szeregu
        przykładów użycia pokrywających większość tematów tej dziedziny.',
        10);

INSERT INTO Workplaces (name, city, street, floor, room) VALUES ('Urbanica', 'Łódź', 'Wróblewskiego 18',8, 302);
INSERT INTO Workplaces (name, city, street, floor, room) VALUES ('Sages sp. z.o.o', 'Warszawa', 'Nowogródzka 62c',null, null);

INSERT INTO Subscriptions(idcour, idworkpl, idattend) VALUES (1, 1, 2);
INSERT INTO Subscriptions(idcour, idworkpl, idattend) VALUES (2, 2, 1);
INSERT INTO Subscriptions(idcour, idworkpl, idattend) VALUES (2, 2, 5);
INSERT INTO Subscriptions(idcour, idworkpl, idattend) VALUES (2, 2, 6);