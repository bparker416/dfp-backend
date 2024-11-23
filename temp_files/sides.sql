CREATE TABLE Sides (
side_id INT PRIMARY KEY AUTO_INCREMENT,
side_name VARCHAR(100) NOT NULL,
side_description TEXT NOT NULL,
side_price INT NOT NULL,
additional_text TEXT,
side_active BOOLEAN NOT NULL DEFAULT true
);

INSERT INTO Sides (side_name, side_description, side_price)
VALUES ("Pesto Pasta Salad", "Cavatappi noodle tossed in pesto aioli with spring peas, red onion, artichoke and parmesan", 6);

INSERT INTO Sides (side_name, side_description, side_price)
VALUES ("That's a Spicy Meatball", "Four homemade American kobe beef meatballs simmered in roasted red pepper marinara; topped fresh basil, ricotta & parmesan cheese", 16);

INSERT INTO Sides (side_name, side_description, side_price, additional_text)
VALUES ("Mac n' Cheese**", "Cavatappi noodle baked in creamy fontina cheese sauce & herbed panko breadcrumb", 13, "add Crumbled Bacon or Chicken $3 **NOT AVAILABLE TO GO");