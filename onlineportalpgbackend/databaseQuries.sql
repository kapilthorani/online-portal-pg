DROP ALL OBJECTS;

CREATE TABLE category (
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(100),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY (id),
);

INSERT INTO category (name,description,image_url,is_active) VALUES('1BHK','This is description for 1BHK category','CAT_1.png',true);
INSERT INTO category (name,description,image_url,is_active) VALUES('2BHK','This is description for 2BHK category','CAT_2.png',true);
INSERT INTO category (name,description,image_url,is_active) VALUES('3BHK','This is description for 3BHK category','CAT_3.png',true);

CREATE TABLE user_details (
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	age VARCHAR(2),
	gender VARCHAR(10),
	enabled BOOLEAN,
	password VARCHAR(50),
	email VARCHAR(100),
	address VARCHAR(100),
	contact_number VARCHAR(15),
	CONSTRAINT pk_user_id PRIMARY KEY (id),
);

INSERT INTO user_details (first_name,last_name,role,age,gender,enabled,password,email,address,contact_number)
VALUES('Kapil','Thorani','ADMIN','24','male',true,'admin','kt@gmail.com','pune','9999999999');

INSERT INTO user_details (first_name,last_name,role,age,gender,enabled,password,email,address,contact_number)
VALUES('Abhinav','Gupta','OWNER','24','male',true,'123','ag@gmail.com','jaipur','8888888888');

INSERT INTO user_details (first_name,last_name,role,age,gender,enabled,password,email,address,contact_number)
VALUES('Virat','Kohli','OWNER','24','male',true,'12345','vk@gmail.com','delhi','7777777777');


CREATE TABLE pg (
	id IDENTITY,
	bookcode VARCHAR(20),
	name VARCHAR(50),
	rent INT DEFAULT 0,
	gender VARCHAR(10),
	location VARCHAR(50),
	pgtype VARCHAR(50),
	bed_available INT DEFAULT 0,
	description VARCHAR(255),
	is_active BOOLEAN,
	category_id INT,
	owner_id INT,
	views INT DEFAULT 0,
	
	CONSTRAINT pk_pg_id PRIMARY KEY (id),
	CONSTRAINT fk_pg_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_pg_owner_id FOREIGN KEY (owner_id) REFERENCES user_details (id),
);

INSERT INTO pg (bookcode, name,rent, gender, location , pgtype , bed_available, description, is_active, category_id, owner_id, views) 
	VALUES('PG1001','Boys-PGs',10000,'male','pune','1BHK',2,'Well-Furnished with Total 4 bed, ac, fridge, geyser and washing-machine',true,1,1,5);

INSERT INTO pg (bookcode, name,rent, gender, location , pgtype , bed_available, description, is_active, category_id, owner_id, views) 
	VALUES('PG1002','Girls-PGs',12000,'female','pune','2BHK',3,'Well-Furnished with Total 6 bed, ac, fridge, geyser and washing-machine',true,2,1,12);

INSERT INTO pg (bookcode, name,rent, gender, location , pgtype , bed_available, description, is_active, category_id, owner_id, views) 
	VALUES('PG1003','Boys And Girls Hostal',12000,'female','pune','3BHK',3,'Well-Furnished with Total 8 bed, ac, fridge, geyser, washing-machine and parking ',true,3,1,50);



