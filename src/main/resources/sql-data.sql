INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
set @person_id = LAST_INSERT_ID();
INSERT INTO `ims`.`products` (`product_name`, `product_value`) VALUES ('Really big chair', '500.25');
set @product_id = LAST_PRODUCT_ID();
INSERT INTO `ims`.`orders` (`id`) SELECT `id` FROM `ims`.`customers` where `first_name` like 'jordan';
set @order_id = LAST_ORDER_ID();
INSERT INTO `ims`.`orders_items` (`order_id`, `product_id`) VALUES (@order_id, @product_id);
