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

import com.qa.ims.persistence.domain.Product;
import com.qa.ims.utils.DBUtils;

public class ProductDAO implements Dao<Product> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public Product modelFromResultSet(ResultSet resultSet) throws SQLException {
		
		Long productId = resultSet.getLong("product_id");
		String productName = resultSet.getString("product_name");
		Double productValue = resultSet.getDouble("product_value");
		
		return new Product(productId, productName, productValue);
	}

	@Override
	public List<Product> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("Select * FROM products");) {
			List<Product> products = new ArrayList<>();
			while (resultSet.next()) {
				products.add(modelFromResultSet(resultSet));
			}
			return products;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	public Product readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM products ORDER BY product_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Product create(Product product) {
		try (Connection connection = DBUtils.getInstance().getConnection();
					PreparedStatement statement = connection.prepareStatement("INSERT INTO products(product_name, product_value) VALUES (?, ?)");){
					statement.setString(1,  product.getProductName());
					statement.setDouble(2, product.getProductValue());
					} catch (Exception e) {
						LOGGER.debug(e);
						LOGGER.error(e.getMessage());
					}

		return null;
	}
	
	@Override
	public Product read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM products WHERE product_id = ?");) {
			statement.setLong(1,  id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}

		return null;
	}


	@Override
	public Product update(Product product) {
		try (Connection connection = DBUtils.getInstance().getConnection(); 
				PreparedStatement statement = connection.prepareStatement("UPDATE products SET product_name = ?, product_value = ? WHERE product_id = ?");) {
			statement.setString(1, product.getProductName());
			statement.setDouble(2,  product.getProductValue());
			statement.setLong(3,  product.getProductId());
			statement.executeUpdate();
			return read(product.getProductId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
