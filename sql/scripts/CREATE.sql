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
    description TEXT,
    max_attende SMALLINT,
    PRIMARY KEY(id)
);
CREATE TABLE Workplaces
(
    id BIGINT unsigned NOT NULL AUTO_INCREMENT,
    name VARCHAR(60),
    city VARCHAR(30) NOT NULL,
    street VARCHAR(60) NOT NULL,
    floor SMALLINT(2),
    room SMALLINT(3),
    PRIMARY KEY (id)
);
CREATE TABLE Subscriptions (
    id BIGINT unsigned NOT NULL AUTO_INCREMENT,
    idcour BIGINT unsigned NOT NULL,
    idworkpl BIGINT unsigned NOT NULL,
    idattend BIGINT unsigned NOT NULL,
    regstamp TIMESTAMP NOT NULL DEFAULT now(),
    PRIMARY KEY (id),
    FOREIGN KEY (idcour) REFERENCES Courses(id) ON DELETE CASCADE,
    FOREIGN KEY (idworkpl) REFERENCES Workplaces (id) ON DELETE CASCADE,
    FOREIGN KEY (idattend)  REFERENCES Attendees(id) ON DELETE CASCADE
);