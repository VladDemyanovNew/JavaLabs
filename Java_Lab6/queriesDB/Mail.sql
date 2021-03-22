CREATE DATABASE MAIL;

CREATE TABLE Person
(
    Id INT PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Birthday DATE
);

CREATE TABLE Letter
(
    Id INT AUTO_INCREMENT,
    Sender INT,
    Recipient INT,
    Topic VARCHAR(50),
    Text VARCHAR(300),
    ShippingDate DATE,
    CONSTRAINT Id_PK PRIMARY KEY (Id),
    CONSTRAINT Sender_FK FOREIGN KEY(Sender) REFERENCES Person(Id),
    CONSTRAINT Recipient_FK FOREIGN KEY(Recipient) REFERENCES Person(Id)
);

INSERT INTO Person (Id, Name, Birthday)
VALUES (3, 'Kolya', '2005-02-19');

INSERT INTO Letter (Sender, Recipient, Topic, Text, ShippingDate)
VALUES (2, 1, 'topic1', 'someText', '2002-02-18'),
       (1, 2, 'topic2', 'someText', '2004-02-18'),
       (3, 1, 'topic3', 'someText', '2001-02-18'),
       (3, 1, 'topic2', 'someText', '2005-02-18'),
       (2, 1, 'topic2', 'someText', '2006-02-18'),
       (2, 2, 'topic1', 'someText', '2003-02-18');

UPDATE Letter SET Recipient = 2 WHERE Id = 3;

#Найти пользователя у которого меньше всего писем
SELECT *, (SELECT COUNT(*) FROM Letter WHERE Sender = Person.Id OR Recipient = Person.Id) AS COUNT
                FROM Person
                ORDER BY COUNT
                LIMIT 1

#Вывести информацию о пользователях, а также количестве
#полученных и отправленных ими письмах
SELECT *,
       (SELECT COUNT(*) FROM Letter WHERE Sender = Person.Id) AS Sent,
       (SELECT COUNT(*) FROM Letter WHERE Recipient = Person.Id) AS Received
FROM Person;

SELECT * FROM Person;
SELECT * FROM Letter;

#Вывести информацию о пользователях, которые получили хотя бы
#одно сообщение с заданной темой
SELECT DISTINCT Person.Id, Person.Birthday, Person.Name
FROM Letter
JOIN Person ON Letter.Recipient = Person.Id
WHERE Letter.Topic = 'topic3';

#Вывести информацию о пользователях, которые не получали
#сообщения с заданной темой.
SELECT * FROM Person
WHERE Person.Id NOT IN (
SELECT DISTINCT Person.Id FROM Letter
JOIN Person ON Person.Id = Letter.Recipient
WHERE Topic = 'topic3');



