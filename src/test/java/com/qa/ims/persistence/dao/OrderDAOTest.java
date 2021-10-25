package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
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
		final Order created = new Order(2L, 1L, "Mockery of a Mockery");
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		
	}
	
	@Test
	public void testReadLatest() {
		assertEquals(new Order(1L, 1L, "Art exhibit"), DAO.readLatest());
	}
	
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Order(1L, 1L, "Art exhibit"), DAO.read(ID));
		
	}
	
/**	
 *	I don't need this one! Delivery_Reason is currently not to be changed. Maybe I don't need it..
 * @Test
	public void testUpdate() {
		
	}*/
	
	@Test
	public void testDelete() {
		
	}
}
