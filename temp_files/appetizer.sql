CREATE TABLE Appetizer (
app_id INT PRIMARY KEY AUTO_INCREMENT,
app_name VARCHAR(100) NOT NULL,
app_description TEXT NOT NULL,
app_price INT NOT NULL,
additional_text TEXT,
pizza_active BOOLEAN NOT NULL DEFAULT true
);

INSERT INTO appetizer (app_name, app_description, app_price)
VALUES ("Foccacia", "Freshly baked with olive oil, rosemary & sea salt", 5);

INSERT INTO appetizer (app_name, app_description, app_price)
VALUES ("Marinated Olives", "Warmed castelvetrano olives marinated in garlic olive oil & citrus", 6);

INSERT INTO appetizer (app_name, app_description, app_price, additional_text)
VALUES ("Cheese Bread", "Brushed with garlic butter, oregano, and house blended cheese. Served with red sauce", 12, "(Make it “bougie” +$3 with fontina cheese & roasted garlic)");

INSERT INTO appetizer (app_name, app_description, app_price)
VALUES ("Antipasti Plate", "An abundant spread of cured meats, cheese, marinated vegetables, fruit & nuts meant for
sharing", 18);