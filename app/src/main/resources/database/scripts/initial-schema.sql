CREATE TABLE recipe (
	id serial UNIQUE,
	name varchar(255) NOT NULL PRIMARY KEY,
	target_nicotine smallint NOT NULL,
	target_pg smallint NOT NULL,
	target_vg smallint NOT NULL,
	base_nicotine smallint NOT NULL,
	quantity smallint
);

CREATE TABLE recipe_flavourings (
    recipe_id serial UNIQUE NOT NULL,
    flavouring_id int NOT NULL PRIMARY KEY,
    percentage decimal(2, 2) NULL,
    FOREIGN KEY (recipe_id)
    REFERENCES recipe (id)
);