USE lab9_database;

CREATE TABLE Role
(
    Id INT AUTO_INCREMENT,
    Name NVARCHAR(50) UNIQUE,
    CONSTRAINT Id_PK PRIMARY KEY (Id)
);

CREATE TABLE Person
(
    Id INT AUTO_INCREMENT,
    Login NVARCHAR(50) UNIQUE,
    Password NVARCHAR(50),
    Role INT,
    CONSTRAINT Id_PK PRIMARY KEY (Id),
    CONSTRAINT Role_FK FOREIGN KEY(Role) REFERENCES Role(Id)
);

INSERT INTO Role (Name)
VALUES ('admin'),
       ('user');

INSERT INTO Person (Login,Password,Role)
VALUES ('VDemyanov', 'password', 1);

SELECT * FROM Role;
SELECT * FROM Person;