package com.qa.ims.persistence.dao;

import org.junit.Before;
import org.junit.Test;

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
		
	}
	
	@Test
	public void testReadAll() {
		
	}
	
	@Test
	public void testReadLatest() {
		
	}
	
	@Test
	public void testRead() {
		
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
