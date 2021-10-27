package com.qa.ims;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.controller.Action;
import com.qa.ims.controller.CrudController;
import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.ItemController;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

public class IMS {

	public static final Logger LOGGER = LogManager.getLogger();

	//Need to remember to do the triple. 
	private final CustomerController customers;
	private final ItemController items;
	private final OrderController orders;
	
	
	private final Utils utils;

	public IMS() {
		this.utils = new Utils();
		final CustomerDAO custDAO = new CustomerDAO();
		this.customers = new CustomerController(custDAO, utils);
		final ItemDAO itemDAO = new ItemDAO();
		this.items = new ItemController(itemDAO, utils);
		final OrderDAO orderDAO = new OrderDAO();
		this.orders = new OrderController(orderDAO, utils);
	} 

	public void imsSystem() {
		LOGGER.info("Welcome to the Inventory Management System!");
		DBUtils.connect();

		Domain domain = null;
		do {
			LOGGER.info("Which entity would you like to use?");
			Domain.printDomains();

			domain = Domain.getDomain(utils);

			domMainAction(domain);

		} while (domain != Domain.STOP);
	}

	private void domMainAction(Domain domain) {
		boolean changeDomain = false;
		do {

			CrudController<?> active = null;
			switch (domain) {
			case CUSTOMER:
				active = this.customers;
				break;
			case ITEM:
				//REMEMBER TO CHUCK IN ACTIVES
				active = this.items;
				break;
			case ORDER:
				//REMEMBER TO CHUCK IN ACTIVES
				active = this.orders;
				break;
			case STOP:
				return;
			default:
				break;
			}

			LOGGER.info(() ->"What would you like to do with " + domain.name().toLowerCase() + ":");
			
			//Setting up a way to only have items call the extras.
			if (active != this.orders) {
				Action.printMainActions();
			} 
			else {
				Action.printActions();
			}
			
			Action action = Action.getAction(utils);
		
			if (action == Action.RETURN) {
				changeDomain = true;
			} else if (active == this.orders){
				doOrderAction(this.orders, action);
			}
			
			else {
				doAction(active, action);
			}
		} while (!changeDomain);
	}

	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		default:
			break;
		}
	}
	
	public void doOrderAction(OrderController orderController, Action action) {
		switch (action) {
		case CREATE:
			orderController.create();
			break;
		case READ:
			orderController.readAll();
			break;
		case UPDATE:
			//orderController.update();
			break;
		case DELETE:
			orderController.delete();
			break;
		case ADDITEM:
			orderController.addItem();
			break;
		case REMOVEITEM:
			orderController.removeItem();
			break;
		case COST:
			orderController.cost();
			break;
		default: 
			break;
		}
	}

}
