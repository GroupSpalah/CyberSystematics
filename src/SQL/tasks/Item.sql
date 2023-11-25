/*
Cоздать таблицы: 

Item(название, дата производства, производитель, хрупкость, цена), 
Producer товара(название фирмы(Enum), страна производства(отдельная таблица)).
Country(название) 

Выбрать товары:
1) Одного производителя(любое название), хрупкие(boolean)
2) Товары, произведенные в разных странах Канада и ”краина и одинаковые производители
3) Хрупкие из разных стран.
4) Выбрать товары, страны которых начинаютс¤ с определенной(ых) букв.
5) Вывести товары, отсортированные по стране(сортировать по убыванию и возрастанию)
и вывести только 5 первых. 
6) Вывести товары с максимальной, минимальной, средней ценой
В задаче использовать Primary and Foreign keys, создать свою базу данных, 
использовать корректные типы данных.

Название товара должно быть уникальным(не допускать в таблице одинаковых товаров)
*/

CREATE TABLE Item			
(                                      
	item_id INT PRIMARY KEY AUTO_INCREMENT,				  
	name VARCHAR(50) NOT NULL,
    date_production DATE,
    is_crash TINYINT,
    price DECIMAL,
    FK_Item_Producer INT NULL,
    FOREIGN KEY (FK_Item_Producer) REFERENCES Producer(producer_id)
);

INSERT INTO Item (name, date_production, is_crash, price, FK_Item_Producer) VALUES
('Laptop X1', '2023-01-15', 0, 1200.00, 1),     -- Assuming '1' is the producer_id for Lenovo
('Smartphone Galaxy S20', '2023-02-01', 0, 800.00, 2),  -- Assuming '2' is the producer_id for Samsung
('iPhone 13', '2023-03-10', 0, 1500.00, 3),   -- Assuming '3' is the producer_id for Apple
('VAIO Laptop', '2023-02-20', 1, 900.00, 1),  -- Assuming '4' is the producer_id for Sony
('HP Envy Laptop', '2023-04-05', 0, 1100.00, 2),         -- Assuming '5' is the producer_id for HP
('Dell Inspiron Desktop', '2023-03-28', 0, 1200.00, 3),  -- Assuming '6' is the producer_id for Dell
('Surface Pro Tablet', '2023-05-12', 0, 1300.00, 1);    -- Assuming '7' is the producer_id for Microsoft


CREATE TABLE Producer		
(                                      
	producer_id INT PRIMARY KEY AUTO_INCREMENT,				  
	name ENUM('Lenovo', 'Samsung', 'Apple') NOT NULL,
    FK_Producer_Country INT NULL,
    FOREIGN KEY (FK_Producer_Country) REFERENCES Country(country_id)
);

INSERT INTO Producer (name, FK_Producer_Country) VALUES
('Lenovo', 1),     -- Assuming '1' corresponds to the country_id for a specific country
('Samsung', 2),    -- Assuming '2' corresponds to the country_id for another country
('Apple', 3);      -- Assuming '3' corresponds to the country_id for yet another country  


CREATE TABLE Country	
(                                      
	country_id INT PRIMARY KEY AUTO_INCREMENT,				  
	name varchar(30) NOT NULL
);

INSERT INTO Country (name) VALUES
('United States'),
('Canada'),
('United Kingdom'),
('Germany'),
('France');

/*1) ќдного производителя(любое название), нехрупкие(boolean) */

select * from item i
inner join producer pr
on i.FK_Item_Producer = pr.producer_id
where pr.name = 'Apple' and i.is_crash = 0;

/*2) “овары, произведенные в разных странах Канада и ”краина и одинаковые производители*/
select * from item i
inner join producer pr
on i.FK_Item_Producer = pr.producer_id
inner join country c
on pr.FK_Producer_Country = c.country_id
where c.name IN ('France', 'Canada');

/*3) ’рупкие из разных стран.*/
select * from item i
inner join producer pr
on i.FK_Item_Producer = pr.producer_id
inner join country c
on pr.FK_Producer_Country = c.country_id
where i.is_crash = 0;

/*4) ¬ыбрать товары, страны которых начинаютс¤ с определенной(ых) букв. */
select * from item i
inner join producer pr
on i.FK_Item_Producer = pr.producer_id
inner join country c
on pr.FK_Producer_Country = c.country_id
where c.name LIKE '%a%';

/*5) ¬ывести товары, отсортированные по стране(сортировать по убыванию и возрастанию) */
select * from item i
inner join producer pr
on i.FK_Item_Producer = pr.producer_id
inner join country c
on pr.FK_Producer_Country = c.country_id
order by c.name ASC LIMIT 5;

select * from item i
inner join producer pr
on i.FK_Item_Producer = pr.producer_id
inner join country c
on pr.FK_Producer_Country = c.country_id
order by c.name DESC LIMIT 5;

/*¬ывести товары с максимальной, минимальной, средней ценой*/

select max(price), min(price), avg(price) from item;