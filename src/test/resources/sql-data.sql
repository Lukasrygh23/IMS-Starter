INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
set @person_id = LAST_INSERT_ID();
INSERT INTO `products` (`product_name`, `product_value`) VALUES ('Really big chair', '500.25');
set @product_id = LAST_INSERT_ID();
INSERT INTO `orders` (`id`, `delivery_reason`) VALUES (1, 'Art exhibit');
set @order_id = LAST_INSERT_ID();
INSERT INTO `orders_items` (`order_id`, `product_id`) VALUES 1, 1);