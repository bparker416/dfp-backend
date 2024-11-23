CREATE TABLE Pizza (
pizza_id INT PRIMARY KEY AUTO_INCREMENT,
pizza_name VARCHAR(100) NOT NULL UNIQUE,
pizza_description TEXT NOT NULL,
small_price INT NOT NULL,
large_price INT NOT NULL,
additional_text TEXT,
pizza_active BOOLEAN NOT NULL DEFAULT true
);

INSERT INTO pizza (pizza_name, pizza_description, small_price, large_price)
VALUES ("Marg", "Red sauce, fresh mozzarella, garlic, olive oil & fresh basil", 16, 26);

INSERT INTO pizza (pizza_name, pizza_description, small_price, large_price)
VALUES ("Pep Pep", "Red sauce, pepperoni, fennel sausage, black olive & red onion", 16, 26);

INSERT INTO pizza (pizza_name, pizza_description, small_price, large_price)
VALUES ("The Bomb", "Red sauce, pepperoni, fennel sausage, black olive & red onion", 16, 26);

INSERT INTO pizza (pizza_name, pizza_description, small_price, large_price)
VALUES ("Henny Plz", "Red sauce, soppresatta, capicola, ricotta cheese, hot honey & fresh basil", 18, 32);

INSERT INTO pizza (pizza_name, pizza_description, small_price, large_price)
VALUES ("The Curtis", "Red sauce, mushroom, olive, artichoke, red onion, roasted garlic & sweet pepper", 16, 26);

INSERT INTO pizza (pizza_name, pizza_description, small_price, large_price)
VALUES ("Betty Draper", "Garlic olive oil, soppresatta, goat cheese & granny smith apple topped with arugula, candied walnut & hot honey", 30, 34);

INSERT INTO pizza (pizza_name, pizza_description, small_price, large_price)
VALUES ("Nonna Piccata", "Ricotta cream sauce, chicken, artichoke, roasted red peppers, chopped garlic & capers finished with fresh rosemary", 20, 34);

INSERT INTO pizza (pizza_name, pizza_description, small_price, large_price)
VALUES ("King Volcano", "Red sauce, pepperoni, crumbled bacon, fresh pineapple, fresh jalapeno, hot honey", 20, 34);

INSERT INTO pizza (pizza_name, pizza_description, small_price, large_price)
VALUES ("Ladybird", "Ranch dressing base, fontina cheese, chicken, crumbled bacon, chopped garlic, spinach & cherry tomato", 18, 32);

INSERT INTO pizza (pizza_name, pizza_description, small_price, large_price)
VALUES ("Broken Meatball", "Red sauce, crumbled beef meatball, roasted pepper, ricotta cheese & fresh basil", 20, 34);

INSERT INTO pizza (pizza_name, pizza_description, small_price, large_price)
VALUES ("A-Rae-Gula", "Red sauce, proscuitto, mushroom, fresh mozzarella topped with arugula, cherry tomato, parmesan & balsamic reduction", 20, 34);

INSERT INTO pizza (pizza_name, pizza_description, small_price, large_price, additional_text)
VALUES ("Gooey Duck", "Ricotta cream sauce, roasted garlic, mushroom, baby spinach, fontina & parmesan cheese", 18, 32, "*does not have actual Geoduck");

INSERT INTO pizza (pizza_name, pizza_description, small_price, large_price)
VALUES ("Sasquash", "Garlic olive oil, roasted delicata squash, onion jam, bacon, mozzarella & goat cheese topped with balsamic reduction and fresh rosemary", 22, 36);

INSERT INTO pizza (pizza_name, pizza_description, small_price, large_price)
VALUES ("Porker Pie", "Red sauce, capicola, sausage, and bacon with cherry tomato, chopped garlic, and balsamic reduction", 20, 34);

