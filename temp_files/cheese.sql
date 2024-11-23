CREATE TABLE Cheese (
cheese_id INT PRIMARY KEY AUTO_INCREMENT,
cheese_name VARCHAR(100) NOT NULL,
cheese_price INT,
cheese_active BOOLEAN NOT NULL DEFAULT true
);

INSERT INTO Cheese (cheese_name)
VALUES ("House Blend");

INSERT INTO Cheese (cheese_name)
VALUES ("Parmesan");

INSERT INTO Cheese (cheese_name)
VALUES ("Ricotta");

INSERT INTO Cheese (cheese_name, cheese_price)
VALUES ("Fresh Mozzarella", 1);

INSERT INTO Cheese (cheese_name)
VALUES ("Fontina");

INSERT INTO Cheese (cheese_name, cheese_price)
VALUES ("Goat Cheese", 2);

INSERT INTO Cheese (cheese_name, cheese_price)
VALUES ("Vegan Cheez", 1);