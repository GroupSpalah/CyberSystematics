
USE for_normalization;

/*
 * - Tables should have one purpose
 * К таблице student:
 *  - Insert Anomaly There are facts we cannot record until we know information for the entire row.
 *    Чтобы добавить студента мы должны знать зав. кафедры
 *  - Update Anomaly - Если будем менять ФИО зав. кафедры, там где есть 'Soloviev A.P.', 
 *    будем обновлять все строки где встречается 'Soloviev A.P.'
 *  - Delete Anomaly - удаляем студента, удаляется и зав. кафедры  
 * */

/**
 * ### 1 Нормальная форма:
	   - Нет дублирующихся строк
	   - В каждой строке хранится атомарное значение
	   - В каждом столбце хранятся данные одного типа
	   - Отсутствуют массивы и списки в любом виде
	   - наличие первичного ключа
	### 2 Нормальная форма:
	   - 1 Нормальная форма
	   - таблица служит одной цели
	### 3 Нормальная форма:
	   - неключевые столбцы не должны зависеть от других неключевых столбцов, к примеру, столбец сумма заказа, она должна считаться, а не храниться
 */

ALTER TABLE student AUTO_INCREMENT = 1;

CREATE TABLE student(
name_of_student VARCHAR (50) NOT NULL, 
date_of_birthday DATE NOT NULL,
lectures VARCHAR(50) NULL,
department VARCHAR(50) NULL,
manager_of_department VARCHAR(50) NULL,
manager_salary INT,
count_of_months_study DATETIME,
foundation DATE,
student_salary INT,
city_university VARCHAR(20),
state_university VARCHAR(20),
country_university VARCHAR(20));


INSERT INTO student (name_of_student, date_of_birthday, lectures, department, manager_of_department, salary, data_in, sum_of_salary, city_university, state_university, country_university)
VALUES ('Gorobets F.A.', '1990-12-12', 'A101, D105',       'AT', 'Tishenko D.I.', 25, '2000-05-05', 350, 'kiev', 'kievskaya', 'Ukraine'),
	   ('Dyatlov D.F.',  '1985-12-08', 'A104, D109',       'RT', 'Soloviev A.P.', 25, '2001-07-05', 250, 'lvov', 'lvovskaya', 'Ukraine'),
	   ('Gusev D.F.',    '1985-12-08', 'A104, D109',       'RT', 'Soloviev A.P.', 25, '1999-04-05', 150, 'Berdyansk', 'Zaporozhe', 'Ukraine'),
	   ('Scheglov S.K.', '1988-12-05', 'A107, D103, F124', 'AT', 'Horoshev R.G.', 25, '1998-05-05', 425, 'Dnepr', 'Dnepropetrovskaya', 'Ukraine');
	   
# FIRST normalization form 	   
# Each column contains atomic values, and there are not repeating groups of columns.
# Нет дублирующих строк(Т. Ларина - 067, Т. Ларина - 067)
# Должны проверить три понятия строка(хранение данных), столбец(хранение структурной информации), ячейка(атомарность), что они используются по назначению
# Мы можем хранить XML, это возможно, но это нарушение
# Если у человека 10 разных номеров, тогда 10 строк, если 10 типов телефонов - 10 столбцов


CREATE TABLE student1(
student_id INT AUTO_INCREMENT,
name_of_student VARCHAR (50) NOT NULL, 
date_of_birthday DATE NOT NULL,
department VARCHAR(50) NULL,
manager_of_department VARCHAR(50) NULL,
salary INT,
data_in DATETIME,
sum_of_salary INT
PRIMARY KEY (student_id));

INSERT INTO student (name_of_student, date_of_birthday,  department, manager_of_department)
VALUES ('Gorobets F.A.', '1990-12-12', 'AT', 'Tishenko D.I.'),
	   ('Dyatlov D.F.',  '1985-12-08', 'RT', 'Soloviev A.P.'),
	   ('Gusev D.F.',    '1985-12-08', 'RT', 'Soloviev A.P.'),
	   ('Scheglov S.K.', '1988-12-05', 'ET', 'Horoshev R.G.');


CREATE TABLE Lecture(
lecture_id INT AUTO_INCREMENT,
name_of_lecture VARCHAR (50) NOT NULL,
student_id INT NULL,
PRIMARY KEY (lecture_id)
FOREIGN KEY (student_id) REFERENCES student(student_id));

INSERT INTO Lecture (name_of_lecture, student_id)
VALUES ('A101', 1),
	   ('D105', 1),
	   ('A104', 2),
	   ('D109', 2),
	   ('A104', 3),
	   ('D109', 3),
	   ('A107', 4),
	   ('D103', 4),
	   ('F124', 4);
	   
# 2 Нормальная форма
# Таблица находится в первой нормальной форме и все колонки зависят от первичного ключа.   
# Аномалии удаления и обновления все еще осталась, так как при удалении строки у студента
# Однажды мы определили назначение таблицы тогда посмотрим в каждый столбец и спросим себя: 
# "Этот столбец служит, чтобы описать, что первичный ключ идентифицирует?"

# Если мы ответили "Да" тогда столбец зависит от первичного ключа и относится к таблице.
# Если мы ответили "Нет" тогда столбец следует вынести в отдельную таблицу.
# Когда все колонки служат первичному ключу, тогда они служат одной цели, описывая, к примеру, работника.
# Поэтому таблица находится во 2 нормальной форме, она описывает одну сущность, описывая, к примеру, работника.
# department, manager_of_department столбец не полностью зависят от первичного ключа, так как описывают другую сущность.
# Вынесем данные о факультете в отдельную таблицу

CREATE TABLE Department (
department_id INT AUTO_INCREMENT,
name_of_department VARCHAR (50) NOT NULL,
manager_of_departmanet VARCHAR (50) NOT NULL,
PRIMARY KEY (department_id));

INSERT INTO Department (name_of_department, manager_of_department)
VALUES ('RT', 'Soloviev A.P.')
	   ('ET', 'Horoshev R.G.'),
	   ('AT', 'Tishenko D.I.');
	   
	   #Тогда таблица Student будет выглядеть так
	   
CREATE TABLE student2(
student_id INT AUTO_INCREMENT,
name_of_student VARCHAR (50) NOT NULL, 
date_of_birthday DATE NOT NULL,
salary INT,
data_in DATETIME,
sum_of_salary INT
PRIMARY KEY (student_id));

#В таблице Department видна аномалия удаления, необходимо вынести ФИО зав.кафедры в отдельную таблицу и создать внешний ключ к таблице Manager

CREATE TABLE Manager(
manager_id INT AUTO_INCREMENT,
first_name VARCHAR (50) NOT NULL, 
last_name VARCHAR (50) NOT NULL,
sur_name VARCHAR (50) NOT NULL,
PRIMARY KEY (manager_id));

CREATE TABLE University(
university_id INT AUTO_INCREMENT,
name VARCHAR (50) NOT NULL,
foundation DATE,
student_salary INT,
city_university VARCHAR(20),
state_university VARCHAR(20),
country_university VARCHAR(20)
PRIMARY KEY (university_id));


CREATE TABLE Department (
department_id INT AUTO_INCREMENT,
name_of_department VARCHAR (50) NOT NULL,
manager_of_departmanet VARCHAR (50) NOT NULL,
manager_id INT NULL,
PRIMARY KEY (lecture_id),
FOREIGN KEY (manager_id) REFERENCES manager(manager_id);

# Файл Третья нормальная форма
База данных будет находиться в третьей нормальной форме, 
если она приведена ко второй нормальной форме и каждый не ключевой столбец независим друг от друга
Отсутствие вычисляемых столбцов + транзитивных зависимостей
3НФ нарушается,  если изменив значение в одном столбце, потребуется изменение и в другом столбце
http://alexvolkov.ru/database-normalization-third-normal-form.html

CREATE TABLE University(
university_id INT AUTO_INCREMENT,
name VARCHAR (50) NOT NULL,
foundation DATE,
student_salary INT,
city_university VARCHAR(20),
state_university VARCHAR(20),
country_university VARCHAR(20)
PRIMARY KEY (university_id));

В таблице University есть транзитивная зависимость, state зависит от city, необходимо вынести в отдельную таблицу, так как есть также аномалия удаления

Возьмём, как образец, одиночную таблицу, которая хранит некую информацию о бизнес клиентах: имя, фамилию, телефон, адрес, город, штат, почтовый индекс и все в этом духе.  
Такая таблица не будет находится в 3НФ, поскольку тут много полей будет взаимозависимо — улица будет зависеть от города, город от штата, почтовый индекс тоже под вопросом. 
Все эти поля будут подчинены друг другу, а не человеку, к которому относится эта запись.

Чтобы нормализовать такую базу, нужно создать по таблице для штатов, городов (с внешним ключом, ведущим в таблицу штатов) и для почтовых кодов. 
Все они будут ссылаться назад на клиентскую таблицу.

Определить, в каких полях каких таблиц имеется взаимозависимость. 
Как только что говорилось, поля, которые зависят больше друг от друга (как город от штата), чем от ряда в целом.
	   
SELECT * FROM student;
	   
#DROP TABLE student;
truncate TABLE student;


