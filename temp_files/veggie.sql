CREATE TABLE Veggie (
veggie_id INT PRIMARY KEY AUTO_INCREMENT,
veggie_name VARCHAR(100) NOT NULL,
veggie_description TEXT,
veggie_active BOOLEAN NOT NULL DEFAULT true
);

INSERT INTO Veggie (veggie_name)
VALUES ("Arugula");

INSERT INTO Veggie (veggie_name)
VALUES ("Artichoke");

INSERT INTO Veggie (veggie_name)
VALUES ("Baby Spinach");

INSERT INTO Veggie (veggie_name)
VALUES ("Basil");

INSERT INTO Veggie (veggie_name)
VALUES ("Capers");

INSERT INTO Veggie (veggie_name, veggie_description)
VALUES ("Garlic", "(chopped or roasted)");

INSERT INTO Veggie (veggie_name)
VALUES ("Tomato");

INSERT INTO Veggie (veggie_name)
VALUES ("Mushroom");

INSERT INTO Veggie (veggie_name)
VALUES ("Sweet Pepper");

INSERT INTO Veggie (veggie_name)
VALUES ("Roasted Red Pepper");

INSERT INTO Veggie (veggie_name)
VALUES ("Jalapeno");

INSERT INTO Veggie (veggie_name)
VALUES ("Pineapple");

INSERT INTO Veggie (veggie_name)
VALUES ("Black Olive");

INSERT INTO Veggie (veggie_name)
VALUES ("Red Onion");

INSERT INTO Veggie (veggie_name)
VALUES ("Candied Walnut");