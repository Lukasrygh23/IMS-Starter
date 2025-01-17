package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {

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
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("Select * FROM orders");) {
			List<Order> orders = new ArrayList<>();
			while(resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		
		return new ArrayList<>();
	}

	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			//System.out.println("Results set!");
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order create(Order order) {

		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(id, delivery_reason) VALUES (?, ?)");) {
			statement.setLong(1, order.getCustomerID());
			statement.setString(2, order.getDeliveryReason());
			statement.executeUpdate();

			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}

		return null;
	}

	@Override
	public Order read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();  
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM orders WHERE order_id = ?");) {
			statement.setLong(1,  id);
			try(ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	//Still don't think I need this one...
	
	@Override
	public Order update(Order t) {
		
		return null;
	}

	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();    
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE order_id = ?");) {
			statement.setLong(1,  id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
				
		return 0;
	}
	
	public OrderItem modelFromResultSetOrderItem(ResultSet resultSet) throws SQLException {
		Long orderItemID = resultSet.getLong("order_item_id");
		Long orderID = resultSet.getLong("order_id");
		Long itemID = resultSet.getLong("product_id");

		return new OrderItem(orderItemID, orderID, itemID);
		
	}
	
	public OrderItem readLatestOrderItem() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM orders_items ORDER BY order_item_id DESC LIMIT 1");) {
			resultSet.next();
			//System.out.println("Results set!");
			return modelFromResultSetOrderItem(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		
		return null;
	}
	
	public OrderItem addItem(OrderItem orderItem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders_items(order_id, product_id) VALUES (?, ?)");) {
			statement.setLong(1, orderItem.getOrderID());
			statement.setLong(2, orderItem.getItemID());
			statement.executeUpdate();
			
			return readLatestOrderItem();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		
		return null;
	}
	
	
	public int removeItem(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM ORDERS_ITEMS where order_item_id = ?");
				) {
			statement.setLong(1, id);
			return statement.executeUpdate();
			
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		
		return 0;
	}
	
	public double cost(long orderID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT products.product_value FROM ORDERS_ITEMS JOIN PRODUCTS ON orders_items.product_id = products.product_id WHERE orders_items.order_id = ?");) {
			statement.setLong(1, orderID);
			//God this feels DISGUSTING.
			ResultSet resultSet = statement.executeQuery();
			Double totalPrice = 0.0;
			while (resultSet.next()) {
				totalPrice += resultSet.getDouble("product_value");
			}
			return totalPrice;
			
		}catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		
		return 0;
	}

}
