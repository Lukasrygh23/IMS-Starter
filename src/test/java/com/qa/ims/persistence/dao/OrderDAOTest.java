package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	
	private final OrderDAO DAO = new OrderDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate() {
		final Order created = new Order(3L, 1L, "Mockery of a Mockery");
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, 1L, "Art exhibit"));
		expected.add(new Order(2L, 1L, "Fixing a mistake"));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadLatest() {
		assertEquals(new Order(2L, 1L, "Fixing a mistake"), DAO.readLatest());
	}
	
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Order(1L, 1L, "Art exhibit"), DAO.read(ID));
		
	}
	
	@Test
	public void testCreateFail() {
		String longName = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		Order chungus = new Order(1L, 1L, longName);
		assertEquals(null, DAO.create(chungus));
	}
	
	@Test
	public void testReadFail() {
		long badId = 25L;
		assertEquals(null, DAO.read(badId));
	}
	
	
 	//I don't need this one! Delivery_Reason is currently not to be changed. Maybe I don't need it..
  @Test
	public void testUpdate() {
	  Order order = new Order(1L, 1L, "bluh");
		assertEquals(null, DAO.update(order));
	}
	
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(2));
		
	}
	
	@Test
	public void readLatestOITest() {
		assertEquals(new OrderItem(1L, 1L, 1L), DAO.readLatestOrderItem());
	}
	
	@Test
	public void addItemTest() {
		final OrderItem created = new OrderItem(2L, 1L, 1L);
		assertEquals(created, DAO.addItem(created));
	}
	
	@Test
	public void removeItemTest() {
		assertEquals(1, DAO.removeItem(1));
		
	}
	
	@Test
	public void calculateCostTest() {
		Double testCost = 500.25;
		Double totalCost = DAO.cost(1);
		assertEquals(testCost, totalCost);
		
	}
}
