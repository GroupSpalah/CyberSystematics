SELECT * FROM carsshop.employee;

/*
В таблице есть столбец с именем, некоторые буквы в верхнем и нижнем регистрах.
Изменить имена так, чтобы первая буква была в верхнем регистре, а остальные в нижнем.

mIKE -> m + IKE
*/

SELECT CONCAT('My', 'S', 'QL') Result;

SELECT LOWER('QUADRATICALLY');

SELECT UPPER('Hej');

SELECT SUBSTRING('foobarbar' FROM 4);

SELECT SUBSTRING('Quadratically',5,6);

SELECT UPPER(SUBSTRING(name, 1, 1)) FROM employee;

SELECT LOWER(SUBSTRING(name, 2)) FROM employee;

SELECT CONCAT(UPPER(SUBSTRING(name, 1, 1)), LOWER(SUBSTRING(name, 2))) Result FROM employee;

 UPDATE employee SET name = CONCAT(UPPER(SUBSTRING(name, 1, 1)), LOWER(SUBSTRING(name, 2)));
 
 SET SQL_SAFE_UPDATES = 0;
 
 SELECT name FROM employee 
 GROUP BY name 
 HAVING COUNT(*) > 1;
 
 SELECT * FROM employee WHERE name IN(
										 SELECT name FROM employee 
										 GROUP BY name 
										 HAVING COUNT(*) > 1
 );
 
  SELECT * FROM employee WHERE name IN('Mike', 'Daren');

