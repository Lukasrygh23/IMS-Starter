
DROP TABLE `orders_items`;
DROP TABLE `products`;
DROP TABLE `orders`;
DROP TABLE `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `orders` (
	`order_id` INT(11) NOT NULL AUTO_INCREMENT,
    `id` INT(11) NOT NULL,
    `delivery_reason` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`order_id`),
    FOREIGN KEY (`id`) REFERENCES `customers`(`id`)
);

CREATE TABLE IF NOT EXISTS `products`(
	`product_id` INT(11) NOT NULL AUTO_INCREMENT,
    `product_name` VARCHAR(40) DEFAULT NULL,
    `product_value` DECIMAL(10,2) DEFAULT NULL,
    PRIMARY KEY (`product_id`)
);

CREATE TABLE IF NOT EXISTS `orders_items` (
	
    `order_item_id` INT(11) NOT NULL AUTO_INCREMENT,
    `order_id` INT(11) NOT NULL,
    `product_id` INT(11) NOT NULL,
    PRIMARY KEY(`order_item_id`),
    FOREIGN KEY(`order_id`) REFERENCES `orders`(`order_id`),
    FOREIGN KEY(`product_id`) REFERENCES `products`(`product_id`)

);
