CREATE SCHEMA college;

USE college;

CREATE TABLE student(
	id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(20) DEFAULT null,
    last_name VARCHAR(20) DEFAULT null,
    email VARCHAR(50) DEFAULT null,
    gpa FLOAT DEFAULT 0,
    PRIMARY KEY(id)
);

INSERT INTO student VALUES
(1,"Tupac","Shakur","tupac@gmail.com",3.4);

CREATE TABLE members(
	user_name VARCHAR(30) NOT NULL,
    password VARCHAR(68),
    enabled TINYINT DEFAULT 1,
    PRIMARY KEY(user_name)
);

INSERT INTO members VALUES
("hary","{bcrypt}$2a$10$cAw2G2okWiCesRuwd3aZNegM3Tibe7akRge/uh71BT72W1XFcyH8C",1),
("sparo","{bcrypt}$2a$10$cAw2G2okWiCesRuwd3aZNegM3Tibe7akRge/uh71BT72W1XFcyH8C",1),
("mohamed","{bcrypt}$2a$10$cAw2G2okWiCesRuwd3aZNegM3Tibe7akRge/uh71BT72W1XFcyH8C",1);

CREATE TABLE permissions(
	user_name VARCHAR(30),
    role VARCHAR(30) NOT NULL,
    FOREIGN KEY(user_name) REFERENCES members(user_name)
);

INSERT INTO permissions VALUES
("hary","ROLE_USER"),
("sparo","ROLE_ITI-OFFICER"),
("mohamed","ROLE_ADMIN");
