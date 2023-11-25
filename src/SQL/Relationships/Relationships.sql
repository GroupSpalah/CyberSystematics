/*OneToOne unidirectional*/

CREATE TABLE Man				
(                                      
	man_id INT PRIMARY KEY AUTO_INCREMENT,				  
	first_name VARCHAR(50) NOT NULL,
    FK_Man_Address INT NULL,
    FOREIGN KEY (FK_Man_Address) REFERENCES Class(class_id)
);

ALTER TABLE man AUTO_INCREMENT = 5;/*Первинний ключ буде починатися с 5*/

INSERT INTO man(first_name, FK_Man_Address)
VALUES
('John', 1),
('Tom',  2),
('Ken',  3);

CREATE TABLE Address				
(                                      
	address_id INT PRIMARY KEY AUTO_INCREMENT,				  
	city ENUM('Kiev', 'Lviv', 'Odessa')
);

INSERT INTO Address(city)
VALUES
('Lviv'),
('Kiev'),
('Odessa');

SELECT *, m.first_name 'First name' 
FROM man m
INNER JOIN address a
ON m.FK_Man_Address = a.address_id;

/*OneToOne Bidirectional*/
CREATE TABLE Student			
(                                      
	student_id INT PRIMARY KEY AUTO_INCREMENT,				  
	first_name VARCHAR(50) NOT NULL,
    FK_Student_Class INT NULL,
    FOREIGN KEY (FK_Student_Class) REFERENCES Class(class_id)
);

INSERT INTO Student(first_name, FK_Student_Class)
VALUES
('John', 1),
('Tom',  2),
('Ken',  3);

CREATE TABLE Class			
(                                      
	class_id INT PRIMARY KEY AUTO_INCREMENT,				  
	city ENUM('IT1', 'IT2', 'IT3'),
    FK_Class_Student INT NULL
);

ALTER TABLE Class ADD FOREIGN KEY (FK_Class_Student) REFERENCES Student(student_id);

INSERT INTO Class(city)
VALUES
('IT1'),
('IT2'),
('IT3');

UPDATE Class SET FK_Class_Student = 1 WHERE class_id = 1;
UPDATE Class SET FK_Class_Student = 2 WHERE class_id = 2;
UPDATE Class SET FK_Class_Student = 3 WHERE class_id = 1;

/*OneToMany unidirectional*/

CREATE TABLE Company				
(                                      
	company_id INT PRIMARY KEY AUTO_INCREMENT,				  
	name VARCHAR(50) NOT NULL
);


INSERT INTO Company(name)
VALUES
('Epam'),
('SoftServe'),
('Google');

CREATE TABLE Worker				
(                                      
	worker_id INT PRIMARY KEY AUTO_INCREMENT,				  
	name VARCHAR(50) NOT NULL,
    FK_Worker_Company INT NULL,
    FOREIGN KEY (FK_Worker_Company) REFERENCES Company(company_id)
);

INSERT INTO Worker(name, FK_Worker_Company)
VALUES
('John', 1),
('Tom',  2),
('Ken',  3),
('Anna', 1),
('Jack', 2),
('Elza', 3);

select * from company c
inner join worker w 
ON w.FK_Worker_Company = c.company_id
where c.name LIKE '%o%';

/*OneToMany bidirectional*/

CREATE TABLE House				
(                                      
	house_id INT PRIMARY KEY AUTO_INCREMENT,				  
	number VARCHAR(50) NOT NULL
);

INSERT INTO House(number)
VALUES
(1),
(2),
(3);

CREATE TABLE Appartment				
(                                      
	appartment_id INT PRIMARY KEY AUTO_INCREMENT,				  
	number INT
);

INSERT INTO Appartment(number)
VALUES
(1),
(2),
(3),
(4);

CREATE TABLE House_Appartment			
(                                      
    FK_House_ID INT NULL,
    FK_Appartment_ID INT NULL UNIQUE,
    FOREIGN KEY (FK_House_ID) REFERENCES House(house_id),
    FOREIGN KEY (FK_Appartment_ID) REFERENCES appartment(appartment_id)
);

INSERT INTO House_Appartment(FK_House_ID, FK_Appartment_ID)
VALUES
(1, 1),
(1, 2),
(1, 3);

/*ManyToMany*/

CREATE TABLE House				
(                                      
	house_id INT PRIMARY KEY AUTO_INCREMENT,				  
	number VARCHAR(50) NOT NULL
);

INSERT INTO House(number)
VALUES
(1),
(2),
(3);

CREATE TABLE Appartment				
(                                      
	appartment_id INT PRIMARY KEY AUTO_INCREMENT,				  
	number INT
);

INSERT INTO Appartment(number)
VALUES
(1),
(2),
(3),
(4);

CREATE TABLE House_Appartment			
(                                      
    FK_House_ID INT NULL,
    FK_Appartment_ID INT NULL,
    FOREIGN KEY (FK_House_ID) REFERENCES House(house_id),
    FOREIGN KEY (FK_Appartment_ID) REFERENCES appartment(appartment_id),
    UNIQUE KEY(FK_House_ID, FK_Appartment_ID));

INSERT INTO House_Appartment(FK_House_ID, FK_Appartment_ID)
VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 2),
(2, 3);

select * from house h
inner join house_appartment ha 
ON h.house_id = ha.FK_House_ID
inner join appartment a
ON ha.FK_Appartment_ID = a.appartment_id;

select a.number from house h
inner join house_appartment ha 
ON h.house_id = ha.FK_House_ID
inner join appartment a
ON ha.FK_Appartment_ID = a.appartment_id;
