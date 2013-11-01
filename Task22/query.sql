DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS book;

CREATE TABLE IF NOT EXISTS author
(
	id serial NOT NULL,
	name VARCHAR(25),
	CONSTRAINT author_pkey PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS book
(
	id serial NOT NULL, 
	author_id integer,
	name VARCHAR(25),
	price integer,
	CONSTRAINT book_pkey PRIMARY KEY(id)
);

INSERT INTO author(id, name) VALUES(1, 'London');
INSERT INTO author(id, name) VALUES(2, 'de Balzac');
INSERT INTO author(id, name) VALUES(3, 'Feuchtwanger');
INSERT INTO author(id, name) VALUES(4, 'Zola');
INSERT INTO author(id, name) VALUES(5, 'Capote');
INSERT INTO author(id, name) VALUES(6, 'Dickens');
INSERT INTO author(id, name) VALUES(7, 'Defoe');
INSERT INTO author(id, name) VALUES(8, 'Fitzgerald');
INSERT INTO author(id, name) VALUES(9, 'Shakespeare');
INSERT INTO author(id, name) VALUES(10, 'Hemingway'); 
INSERT INTO author(id, name) VALUES(11, 'Collins');

INSERT INTO book(author_id, name, price) VALUES(1, 'Call of the Wild', 500);
INSERT INTO book(author_id, name, price) VALUES(1, 'Martin Eden', 600);
INSERT INTO book(author_id, name, price) VALUES(2, 'Old Goriot', 500);
INSERT INTO book(author_id, name, price) VALUES(2, 'Cousin Bette', 400);
INSERT INTO book(author_id, name, price) VALUES(3, 'Jew Suess', 540);
INSERT INTO book(author_id, name, price) VALUES(4, 'Nana', 450);
INSERT INTO book(author_id, name, price) VALUES(4, 'The Belly of Paris', 519);
INSERT INTO book(author_id, name, price) VALUES(5, 'In Cold blood', 699);
INSERT INTO book(author_id, name, price) VALUES(5, 'Breakfast at Tiffany', 256);
INSERT INTO book(author_id, name, price) VALUES(6, 'Oliver Twist', 1049);
INSERT INTO book(author_id, name, price) VALUES(6, 'David Copperfield', 1999);
INSERT INTO book(author_id, name, price) VALUES(6, 'Little Dorrit', 1099);
INSERT INTO book(author_id, name, price) VALUES(7, 'Robinson Crusoe', 2099);
INSERT INTO book(author_id, name, price) VALUES(7, 'Captain Singleton', 999);
INSERT INTO book(author_id, name, price) VALUES(8, 'The Great Gatsby', 1590);
INSERT INTO book(author_id, name, price) VALUES(8, 'This Side of Paradise', 849);
INSERT INTO book(author_id, name, price) VALUES(8, 'The Beautiful and Damned', 743);
INSERT INTO book(author_id, name, price) VALUES(9, 'Hamlet', 649);
INSERT INTO book(author_id, name, price) VALUES(9, 'Romeo and Juliet', 1239);
INSERT INTO book(author_id, name, price) VALUES(9, 'Othello', 879);
INSERT INTO book(author_id, name, price) VALUES(10, 'The Old Man and the Sea', 1299);
INSERT INTO book(author_id, name, price) VALUES(11, 'Catching Fire', 199);


SELECT * FROM author WHERE name LIKE 'S%' OR name LIKE 'N%';

SELECT * FROM book WHERE price > 1000;

SELECT author.name, book.name FROM author, book WHERE author.id = author_id;

SELECT * FROM book WHERE price = (
	SELECT MIN(price) FROM book
);
 
SELECT AVG(price) FROM book;

SELECT COUNT(*) FROM author;

SElECT author.name, MAX(price) FROM author, book WHERE author.id = author_id GROUP BY author.name;

SELECT name, COUNT(name) FROM book GROUP BY name;

SELECT name, COUNT(name) FROM author GROUP BY name HAVING COUNT(name) > 1;

SELECT author.name FROM author, book WHERE author.id = author_id GROUP BY author.name HAVING AVG(price) > 1000;

SELECT author.name FROM author, book WHERE author.id = author_id GROUP BY author.name HAVING COUNT(author.name) > 1;

SELECT author.name FROM author, book WHERE author.id = author_id AND price = (
	SELECT MAX(price) FROM book
);