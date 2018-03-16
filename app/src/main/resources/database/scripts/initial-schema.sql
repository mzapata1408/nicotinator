CREATE TABLE recipe (
  id int(11) UNIQUE NOT NULL AUTO_INCREMENT,
  name varchar(255) UNIQUE NOT NULL,
  target_nicotine smallint(6) NOT NULL,
  target_pg smallint(6) NOT NULL,
  target_vg smallint(6) NOT NULL,
  base_nicotine smallint(6) NOT NULL,
  quantity smallint(6) DEFAULT NULL,
  PRIMARY KEY (id),
) ENGINE=InnoDB;

DROP TABLE IF EXISTS flavouring;
CREATE TABLE flavouring (
    id int(11) UNIQUE NOT NULL AUTO_INCREMENT,
    name varchar(255) UNIQUE NOT NULL,
    PRIMARY KEY (id),
    INDEX (id),
    INDEX (name)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS recipe_flavouring;
CREATE TABLE recipe_flavouring (    
    recipe_id int(11) NOT NULL,
    flavouring_id int(11) NOT NULL,
    percentage decimal(2, 2) NOT NULL,
    PRIMARY KEY(recipe_id, flavouring_id),
    INDEX (recipe_id, flavouring_id)
) ENGINE=INNODB;

ALTER TABLE recipe_flavouring
ADD CONSTRAINT fk_recipe_flavouring_recipe_id
FOREIGN KEY (recipe_id) REFERENCES recipe(id);

ALTER TABLE recipe_flavouring
ADD CONSTRAINT fk_recipe_flavouring_flavouring_id
FOREIGN KEY (flavouring_id) REFERENCES flavouring(id);