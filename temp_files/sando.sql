CREATE TABLE Sando (
sando_id INT PRIMARY KEY AUTO_INCREMENT,
sando_name VARCHAR(100) NOT NULL,
sando_description TEXT NOT NULL,
sando_price INT NOT NULL,
additional_text TEXT,
sando_active BOOLEAN NOT NULL DEFAULT true
);

INSERT INTO Sando (sando_name, sando_description, sando_price, additional_text)
VALUES ("Caprese", "Pesto aioli, fresh mozzarella, & cherry tomato toasted & topped with arugula, fresh basil, and balsamic reduction", 12, "add Chicken $3 or Prosciutto $4");

INSERT INTO Sando (sando_name, sando_description, sando_price)
VALUES ("Chicken Bacon Ranch", "Honey mustard chicken, bacon, and provolone cheese toasted & finished with romaine lettuce, cherry tomato, ranch dressing and pickled red onion", 13);

INSERT INTO Sando (sando_name, sando_description, sando_price)
VALUES ("Grinder", "Capicola, soppresatta, pepperoni, provolone cheese, arugula, red onion, and cherry tomato with pesto aioli & hoagie sauce", 14);

INSERT INTO Sando (sando_name, sando_description, sando_price)
VALUES ("Meatball Sub", "House made beef meatballs in roasted red pepper marinara with shredded mozzarella & provolone cheese toasted in the oven and finished with fresh basil", 14);