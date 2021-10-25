package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Product;
import com.qa.ims.utils.DBUtils;

public class ProductDAOTest {
	private final ProductDAO DAO = new ProductDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate() {
		final Product created = new Product(3L, "Oversized Novelty Gorilla", 10.10);
		assertEquals(created, DAO.create(created));
	}
		
		
	@Test
	public void testReadAll() {
		List<Product> expected = new ArrayList<>();
		expected.add(new Product(1L, "Really big chair", 500.25));
		expected.add(new Product(2L, "Endless bag of wine", 1004.21));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadLatest() {
		assertEquals(new Product(2L, "Endless bag of wine", 1004.21), DAO.readLatest());
	}
	
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Product(ID, "Really big chair", 500.25), DAO.read(ID));
	}
	
	@Test
	public void testUpdate() {
		final Product updated = new Product(1L, "Oversized Novelty Gorilla", 20.50);
		assertEquals(updated, DAO.update(updated));
	}
	
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(2));
	}
}
