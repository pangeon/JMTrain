CREATE DATABASE JMTrainDB;
USE JMTrainDB;
# +-----------+------------------------------------+------+-----+-------------------+-------------------+
# | Field     | Type                               | Null | Key | Default           | Extra             |
# +-----------+------------------------------------+------+-----+-------------------+-------------------+
# | id        | bigint(20) unsigned                | NO   | PRI | NULL              | auto_increment    |
# | email     | varchar(45)                        | NO   | UNI | NULL              |                   |
# | password  | varchar(60)                        | NO   |     | NULL              |                   |
# | ip        | int(4) unsigned                    | NO   |     | NULL              |                   |
# | token     | varchar(45)                        | YES  | UNI | NULL              |                   |
# | regstamp  | timestamp                          | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
# | confstamp | timestamp                          | YES  |     | NULL              |                   |
# | role      | enum('admin','trainer','attendee') | NO   |     | NULL              |                   |
# +-----------+------------------------------------+------+-----+-------------------+-------------------+
CREATE TABLE Profiles(
    id 		 	  BIGINT unsigned  	NOT NULL AUTO_INCREMENT,
    email 	 	VARCHAR(45) 	 	 	NOT NULL UNIQUE,
    password 	VARCHAR(60) 	 	 	NOT NULL,
    ip        INT(4) unsigned   NOT NULL,
    token     VARCHAR(45)       UNIQUE,
    regstamp  TIMESTAMP         NOT NULL DEFAULT now(),
    confstamp TIMESTAMP         DEFAULT NULL,
    role 	 	  ENUM('admin', 'trainer', 'attendee')
      NOT NULL,
			PRIMARY KEY (id)
);
#+----------+---------------------+------+-----+---------+----------------+
#| Field    | Type                | Null | Key | Default | Extra          |
#+----------+---------------------+------+-----+---------+----------------+
#| id       | bigint(20) unsigned | NO   | PRI | NULL    | auto_increment |
#| idprof   | bigint(20) unsigned | NO   | MUL | NULL    |                |
#| name     | varchar(60)         | NO   |     | NULL    |                |
#| surname  | varchar(60)         | NO   |     | NULL    |                |
#| phone    | varchar(20)         | NO   | UNI | NULL    |                |
#| city     | varchar(30)         | NO   |     | NULL    |                |
#| postcode | varchar(10)         | YES  |     | NULL    |                |
#| street   | varchar(60)         | NO   |     | NULL    |                |
#+----------+---------------------+------+-----+---------+----------------+ 
CREATE TABLE Attendees(
    id 		 	BIGINT unsigned  	 	NOT NULL AUTO_INCREMENT,
    idprof 	 	BIGINT unsigned  	 	NOT NULL,
    name 	 	VARCHAR(60) 	 	 	NOT NULL,
    surname  		VARCHAR(60) 	 	 	NOT NULL,
    phone 	 	VARCHAR(20) 	 	 	NOT NULL UNIQUE,
    city 	 	VARCHAR(30) 	 	 	NOT NULL,
    postcode 		VARCHAR(10),
    street 	 	VARCHAR(60) 	 	 	NOT NULL,
			PRIMARY KEY(id),
			FOREIGN KEY (idprof) 		REFERENCES Profiles(id)
);
#+-------------+---------------------+------+-----+---------+----------------+
#| Field       | Type                | Null | Key | Default | Extra          |
#+-------------+---------------------+------+-----+---------+----------------+
#| id          | bigint(20) unsigned | NO   | PRI | NULL    | auto_increment |
#| title       | varchar(60)         | NO   |     | NULL    |                |
#| start_date  | timestamp           | NO   |     | NULL    |                |
#| end_date    | timestamp           | NO   |     | NULL    |                |
#| describtion | text                | YES  |     | NULL    |                |
#| max_attende | smallint(6)         | YES  |     | NULL    |                |
#+-------------+---------------------+------+-----+---------+----------------+
CREATE TABLE Courses(
    id 		   	BIGINT unsigned  	 	NOT NULL AUTO_INCREMENT,
    title 	   	VARCHAR(60) 	 	 	NOT NULL,
    start_date 	TIMESTAMP	 	 	 	NOT NULL,
    end_date   	TIMESTAMP		 	 	NOT NULL,
    describtion TEXT,
    max_attende SMALLINT,
			PRIMARY KEY(id),
                	FOREIGN KEY (trainer) 		REFERENCES Profiles(id)
);
#+--------+---------------------+------+-----+---------+----------------+
#| Field  | Type                | Null | Key | Default | Extra          |
#+--------+---------------------+------+-----+---------+----------------+
#| id     | bigint(20) unsigned | NO   | PRI | NULL    | auto_increment |
#| name   | varchar(60)         | YES  |     | NULL    |                |
#| city   | varchar(30)         | NO   |     | NULL    |                |
#| street | varchar(60)         | NO   |     | NULL    |                |
#| floor  | smallint(2)         | YES  |     | NULL    |                |
#| room   | smallint(3)         | YES  |     | NULL    |                |
#+--------+---------------------+------+-----+---------+----------------+
CREATE TABLE Workplace(
    id 		BIGINT unsigned  	 		NOT NULL AUTO_INCREMENT,
    name 		VARCHAR(60),
    city 	 	VARCHAR(30) 	 	 	NOT NULL,
    street		VARCHAR(60) 	 	 	NOT NULL,
    floor		SMALLINT(2),
    room		SMALLINT(3),
			PRIMARY KEY (id)
);
#+----------+---------------------+------+-----+-------------------+-------------------+
#| Field    | Type                | Null | Key | Default           | Extra             |
#+----------+---------------------+------+-----+-------------------+-------------------+
#| id       | bigint(20) unsigned | NO   | PRI | NULL              | auto_increment    |
#| idcour   | bigint(20) unsigned | NO   | MUL | NULL              |                   |
#| idworkpl | bigint(20) unsigned | NO   | MUL | NULL              |                   |
#| idattend | bigint(20) unsigned | NO   | MUL | NULL              |                   |
#| regstamp | timestamp           | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
#+----------+---------------------+------+-----+-------------------+-------------------+
CREATE TABLE Subscribtions (
    id 			BIGINT unsigned  	 	NOT NULL AUTO_INCREMENT,
    idcour		BIGINT unsigned  	 	NOT NULL,
    idworkpl		BIGINT unsigned  	 	NOT NULL,
    idattend		BIGINT unsigned  	 	NOT NULL,
    regstamp   		TIMESTAMP   			NOT NULL DEFAULT now(),
			PRIMARY KEY (id),
                	FOREIGN KEY (idcour)   		REFERENCES Courses(id),
                	FOREIGN KEY (idworkpl) 		REFERENCES Workplace(id),
                	FOREIGN KEY (idattend) 		REFERENCES Attendees(id)
);