/*Имеются сущности с полями:

Студент(имя, фамилия, возраст, пол, дата рождения, адрес, номер группы);
Университет(название, дата основания);
Факультет(название, дата основания);
Группа(название, дата основания, староста(внешний ключ на таблицу Student), факультет);
Адрес(город, улица, номер дома, номер квартиры);

Связь между Университетом и Факультетом ManyToMany

Создать 20 студентов так, чтобы некоторые имели:
- общие университеты.
- общие факультеты.
- одинаковый номер группы.
- общие номера домов на одной улице.
- одну улицу.
Вывести в консоль:
 - всех студентов учащихся в одном университете(по названию университета).
 - всех студентов учащихся в одном университете(по названию университета) и на одном факультете.
 - количество студентов учащихся в каждом университете, факультете, группе.
 - найти группу с максимальным/минимальным количеством студентов.
 - подсчитать количество студентов, которые живут по одному адресу(улица, дом).
 - вывести даты рождения студентов в формате '30 Oct 16'.
 - вывести среднее количество людей в группе по университету.
 - вывести всех старост групп.
 - вывести университет, с наибольшим количеством факультетов/групп/студентов.
 
 В написании запросов использовать:
- первичные и внешние ключи, 
- autoincrement, 
- default values, 
- not null/null.
- соответствующие типы данных.
- joins
- свои функции
- views
- stored procedures

*/


-- Студент(имя, фамилия, возраст, пол, дата рождения, адрес, номер группы);

CREATE DATABASE IF NOT EXISTS University;

USE university;

-- Адрес(город, улица, номер дома, номер квартиры);
CREATE TABLE Address(
address_id INT PRIMARY KEY AUTO_INCREMENT,
city VARCHAR(20),
street VARCHAR(20),
house_number INT,
appartment_number INT
);

-- Университет(название, дата основания);

CREATE TABLE Faculty(
faculty_id INT PRIMARY KEY AUTO_INCREMENT,
dob DATE,
name VARCHAR(20)
);

-- Факультет(название, дата основания);
CREATE TABLE University(
university_id INT PRIMARY KEY AUTO_INCREMENT,
dob DATE,
name VARCHAR(20)
);

CREATE TABLE Faculty_University(
FK_University_ID INT NULL,
FK_Faculty_ID INT NULL,
FOREIGN KEY (FK_University_ID) REFERENCES University(university_id),
FOREIGN KEY (FK_Faculty_ID) REFERENCES Faculty(faculty_id)
);

-- Группа(название, дата основания, староста(внешний ключ на таблицу Student), факультет);
CREATE TABLE Class(
class_id INT PRIMARY KEY AUTO_INCREMENT,
dob DATE,
name VARCHAR(20),
house_number INT,
appartment_number INT,
FK_Class_Student INT NULL,
FK_Class_Faculty INT NULL,
FOREIGN KEY (FK_Class_Faculty) REFERENCES Faculty(faculty_id)
);

CREATE TABLE Student(
student_id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(20),
last_name VARCHAR(20),
age INT,
gender ENUM('MALE', 'FEMALE'),
dob DATE,
FK_Student_Address INT NULL,
FK_Student_Class INT NULL,
FOREIGN KEY (FK_Student_Address) REFERENCES address(address_id),
FOREIGN KEY (FK_Student_Class) REFERENCES class(class_id)
);

ALTER TABLE Class ADD FOREIGN KEY (FK_Class_Student) REFERENCES Student(student_id);



