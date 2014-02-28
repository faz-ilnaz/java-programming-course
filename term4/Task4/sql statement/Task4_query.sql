CREATE TABLE user
(
	id serial NOT NULL,
	firstname VARCHAR(25),
	lastname VARCHAR(50),
	city VARCHAR(50),
	phone_number VARCHAR(25),
	email VARCHAR(50),
	password VARCHAR(50),
	CONSTRAINT user_pkey PRIMARY KEY(id)
);

CREATE TABLE company
(
	id serial NOT NULL,
	name VARCHAR(50),
	city VARCHAR(50),
	about text,
	email VARCHAR(50),
	password VARCHAR(50),
	CONSTRAINT company_pkey PRIMARY KEY(id)
);

CREATE TABLE category
(
	id serial NOT NULL,
	name VARCHAR(60),
	CONSTRAINT cat_pkey PRIMARY KEY(id)
);

CREATE TABLE cv
(
	id serial NOT NULL,
	title VARCHAR(60),
	education integer,
	experience_from date,
	gender integer,
	cv_text text,
	user_id integer NOT NULL,
	category_id integer NOT NULL,
	CONSTRAINT cv_pkey PRIMARY KEY(id),
	CONSTRAINT user_id_fkey FOREIGN KEY(user_id) REFERENCES user(id),
	CONSTRAINT category_id_fkey FOREIGN KEY(id, category_id) REFERENCES cv_category(cv_id, category_id)
);

CREATE TABLE vacancy
(
	id serial NOT NULL,
	title VARCHAR(60),
	city VARCHAR(50),
	salary integer,
	vac_text text,
	qualification integer,
	category_id integer NOT NULL,
	company_id integer NOT NULL,
	CONSTRAINT vac_pkey PRIMARY KEY(id),
	CONSTRAINT com_id_fkey FOREIGN KEY(company_id) REFERENCES company(id),
	CONSTRAINT cat_id_fkey2 FOREIGN KEY(category_id) REFERENCES category(id)
);

CREATE TABLE invite
(
	id serial NOT NULL,
	type integer,
	vac_id integer NOT NULL,
	cv_id integer NOT NULL,
	CONSTRAINT invite_pkey PRIMARY KEY(id),
	CONSTRAINT vac_id_fkey FOREIGN KEY(vac_id) REFERENCES vacancy(id),
	CONSTRAINT cv_id_fkey FOREIGN KEY(cv_id) REFERENCES cv(id)
);

CREATE TABLE cv_category
(
	cv_id integer NOT NULL,
	category_id integer NOT NULL,
	CONSTRAINT cv_cat_pkey PRIMARY KEY(cv_id, category_id),
	CONSTRAINT cv_category_fkey_1 FOREIGN KEY(cv_id) REFERENCES cv(id),
	CONSTRAINT cv_category_fkey_2 FOREIGN KEY(category_id) REFERENCES category(id)
);