CREATE TABLE Salad (
salad_id INT PRIMARY KEY AUTO_INCREMENT,
salad_name VARCHAR(100) NOT NULL,
salad_description TEXT NOT NULL,
small_price INT NOT NULL,
large_price INT,
additional_text TEXT,
salad_active BOOLEAN NOT NULL DEFAULT true
);

INSERT INTO Salad (salad_name, salad_description, small_price)
VALUES ("House Salad", "Romaine and arugula, black olive, sweet pepper, pickled red onion, shredded cheese, and crouton with choice of dressing", 10);

INSERT INTO Salad (salad_name, salad_description, small_price, large_price, additional_text)
VALUES ("Caeser", "Romaine tossed in housemade Caesar* dressing with grated parmesan & crouton", 11, 16, "*Dressing contains anchovy");

INSERT INTO Salad (salad_name, salad_description, small_price)
VALUES ("Rocketman", "Arugula greens, cherry tomato, red onion, fresh cubed mozzarella & parmesan with vinaigrette and balsamic reduction", 12);

INSERT INTO Salad (salad_name, salad_description, small_price, large_price)
VALUES ("BLT", "Romaine tossed in ranch dressing with crumbled bacon, cherry tomato, parmesan & crouton", 11, 14);