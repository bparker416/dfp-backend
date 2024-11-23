CREATE TABLE Meat (
meat_id INT PRIMARY KEY AUTO_INCREMENT,
meat_name VARCHAR(100) NOT NULL,
meat_price INT NOT NULL,
meat_description TEXT,
meat_active BOOLEAN NOT NULL DEFAULT true
);

INSERT INTO Meat (meat_name, meat_price)
VALUES ("Pepperoni", 3);

INSERT INTO Meat (meat_name, meat_price)
VALUES ("Italian Sausage", 3);

INSERT INTO Meat (meat_name, meat_price)
VALUES ("Bacon", 3);

INSERT INTO Meat (meat_name, meat_price)
VALUES ("Chicken", 3);

INSERT INTO Meat (meat_name, meat_price)
VALUES ("Vegan Pepperoni", 3);

INSERT INTO Meat (meat_name, meat_price)
VALUES ("Crumbled Meatball", 4);

INSERT INTO Meat (meat_name, meat_price)
VALUES ("Prosciutto", 4);

INSERT INTO Meat (meat_name, meat_price, meat_description)
VALUES ("Soppresatta", 4, "(spicy salami)");

INSERT INTO Meat (meat_name, meat_price)
VALUES ("Capicola", 4);