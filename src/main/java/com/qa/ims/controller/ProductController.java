package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ProductDAO;
import com.qa.ims.persistence.domain.Product;
import com.qa.ims.utils.Utils;

public class ProductController implements CrudController<Product> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private ProductDAO productDAO;
	private Utils utils;
	
	public ProductController(ProductDAO productDAO, Utils utils) {
		super();
		this.productDAO = productDAO;
		this.utils = utils;
	}
	
	/**
	 * Reads all products to the logger.
	 */
	@Override
	public List<Product> readAll() {
		List<Product> products = productDAO.readAll();
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
		Product product = productDAO.create(new Product(productName, productValue));
		return product;
	}
	@Override
	public Product update() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

}
