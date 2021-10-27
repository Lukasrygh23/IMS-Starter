package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDAO;
	private Utils utils;
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}
	
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order: orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter a Customer ID");
		Long id = utils.getLong();
		LOGGER.info("Please enter a reason for delivery");
		String deliveryReason = utils.getString();
		Order order = orderDAO.create(new Order(id, deliveryReason));
		return order;
	}

	//Lol. Lmao.
	@Override
	public Order update() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int delete() {
		LOGGER.info("Please enter the ID of the order you would like to delete.");
		Long id = utils.getLong();
		//Make sure this nukes all items in the order first! Right now it's not fully working.
		return orderDAO.delete(id);
	}
	
	public OrderItem addItem() {
		LOGGER.info("Please enter an Order ID");
		Long orderID = utils.getLong();
		LOGGER.info("Please enter a Product ID");
		Long productID = utils.getLong();
		return orderDAO.addItem(new OrderItem(orderID, productID));
	}
	
	public int removeItem() {
		
		return 0;
	}
	
	public Double cost() {
		
		return null;
	}
}
