CREATE TABLE Dessert (
dessert_id INT PRIMARY KEY AUTO_INCREMENT,
dessert_name VARCHAR(100) NOT NULL,
dessert_description TEXT NOT NULL,
dessert_price INT NOT NULL,
additional_text TEXT,
dessert_active BOOLEAN NOT NULL DEFAULT true
);

INSERT INTO Dessert (dessert_name, dessert_description, dessert_price)
VALUES ("Cannoli", "Crispy fried pastry shell piped to order with rotating ricotta based filling. A Sicillian treat", 6);

INSERT INTO Dessert (dessert_name, dessert_description, dessert_price)
VALUES ("Panna Cotta", "Sweetened, thickened buttermilk and cream served chilled. Garnished with seasonal fruit coulis and meringue cookie crisp", 8);