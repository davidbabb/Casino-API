CREATE TABLE game_user (
	user_id int DEFAULT nextval('seq_user_id'),
	username varchar(200) NOT NULL,
	password_hash varchar(200) NOT NULL,
	CONSTRAINT pk_game_user PRIMARY KEY (user_id)
);

CREATE SEQUENCE seq_user_id 
	INCREMENT BY 1
	START WITH 1001
	NO MAXVALUE;


CREATE TABLE user_hand (
	hand_id int DEFAULT nextval ('seq_hand_id'),
	user_id int NOT NULL,
	card_id int NOT NULL,
	CONSTRAINT pk_user_hand PRIMARY KEY (hand_id),
	CONSTRAINT fk_game_user FOREIGN KEY (user_id) REFERENCES game_user (user_id),
	CONSTRAINT fk_card FOREIGN KEY (card_id) REFERENCES card (card_id)
);

CREATE TABLE chip (
	chip_id serial NOT NULL,
	chip_value int NOT NULL,
	CONSTRAINT pk_chip PRIMARY KEY (chip_id)
);

CREATE TABLE user_chips (
	chip_id int NOT NULL,
	CONSTRAINT fk_chip FOREIGN KEY (chip_id) REFERENCES chip (chip_id)
);

CREATE TABLE outcomes (
	outcome_id int DEFAULT nextval('seq_outcome_id'),
	outcome_name varchar(100) NOT NULL,
	CONSTRAINT pk_outcomes PRIMARY KEY (outcome_id)
);

CREATE TABLE hand_outcomes (
	hand_id int NOT NULL,
	outcome_id int NOT NULL,
	CONSTRAINT pk_hand_outcomes PRIMARY KEY (hand_id, outcome_id),
	CONSTRAINT fk_hand FOREIGN KEY (hand_id) REFERENCES user_hand (hand_id),
	CONSTRAINT fk_outcome FOREIGN KEY (outcome_id) REFERENCES outcomes (outcome_id)
);

CREATE TABLE dealer (
	card_id int NOT NULL,
	CONSTRAINT pk_dealer PRIMARY KEY (card_id),
	CONSTRAINT fk_dealer FOREIGN KEY (card_id) REFERENCES card (card_id)
);

CREATE SEQUENCE seq_outcome_id 
	INCREMENT BY 1
	START WITH 500
	NO MAXVALUE;

CREATE SEQUENCE seq_hand_id 
	INCREMENT BY 1
	START WITH 101
	NO MAXVALUE;