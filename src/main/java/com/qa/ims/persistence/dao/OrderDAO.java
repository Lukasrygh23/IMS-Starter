package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;

public class OrderDAO implements Dao<Order>{
	
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderID = resultSet.getLong("order_id");
		Long customerID = resultSet.getLong("id");
		String deliveryReason = resultSet.getString("delivery_reason");
		
		return new Order(orderID, customerID, deliveryReason);
	}
	
	@Override
	public List<Order> readAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Order create(Order t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Order read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order update(Order t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
}
