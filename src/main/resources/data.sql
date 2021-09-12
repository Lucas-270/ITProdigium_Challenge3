CREATE TABLE travel (
	id int PRIMARY KEY auto_increment,
	id_user int,
	weight int,
	restarts int
);

CREATE TABLE user (
	id int PRIMARY KEY auto_increment,
	name varchar(50),
	email varchar(50),
	telephone varchar(20),
	password varchar(100)
);

INSERT INTO user VALUES (1, 'Irineu', 'irineu@irineu.com.br', '11922223333', 'irineu1234');
INSERT INTO user VALUES (2, 'Creusa', 'creusa@irineu.com.br', '11933332222', 'creusa1234');

INSERT INTO travel (id, id_user, weight, restarts) VALUES (1, 1, 5, 0);
INSERT INTO travel (id, id_user, weight, restarts) VALUES (2, 1, 8, 5);
INSERT INTO travel (id, id_user, weight, restarts) VALUES (3, 2, 7, 2);