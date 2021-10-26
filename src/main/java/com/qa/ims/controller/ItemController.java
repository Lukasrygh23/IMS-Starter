package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Product;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Product> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private ItemDAO itemDAO;
	private Utils utils;
	
	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}
	
	/**
	 * Reads all products to the logger.
	 */
	@Override
	public List<Product> readAll() {
		List<Product> products = itemDAO.readAll();
		for (Product product : products) {
			LOGGER.info(product);
		}
		return products;
	
		
	}
	@Override
	public Product create() {
		LOGGER.info("Please enter a Product Name");
		String productName = utils.getString();
		LOGGER.info("Please enter a value");
		Double productValue = utils.getDouble();
		Product product = itemDAO.create(new Product(productName, productValue));
		return product;
	}
	
	
	@Override
	public Product update() {
		LOGGER.info("Please enter the id of the product you would like to update");
		Long productId = utils.getLong();
		LOGGER.info("Please enter a product name");
		String productName = utils.getString();
		LOGGER.info("Please enter a value");
		Double productValue = utils.getDouble();
		Product product = itemDAO.update(new Product(productId, productName, productValue));
		LOGGER.info("Customer updated.");
		return product;
	}
	@Override
	public int delete() {
		LOGGER.info("Please enter the ID of the product you would like to delete");
		Long id = utils.getLong();
		return itemDAO.delete(id);
	}

}
