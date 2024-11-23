CREATE TABLE Sauce (
sauce_id INT PRIMARY KEY AUTO_INCREMENT,
sauce_name VARCHAR(100),
sauce_active BOOLEAN NOT NULL DEFAULT true
);

INSERT INTO Sauce (sauce_name)
VALUES ("House Red");

INSERT INTO Sauce (sauce_name)
VALUES ("Ricotta Cream");

INSERT INTO Sauce (sauce_name)
VALUES ("Garlic Olive Oil");

INSERT INTO Sauce (sauce_name)
VALUES ("Ranch");

INSERT INTO Sauce (sauce_name)
VALUES ("Hot Honey");