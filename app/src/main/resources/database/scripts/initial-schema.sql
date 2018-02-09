CREATE TABLE recipe (
	id serial UNIQUE,
	name varchar(255) NOT NULL PRIMARY KEY,
	target_nicotine smallint NOT NULL,
	target_pg smallint NOT NULL,
	target_vg smallint NOT NULL,
	base_nicotine smallint NOT NULL,
	quantity smallint
);