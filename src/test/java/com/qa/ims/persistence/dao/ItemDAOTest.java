package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {
	private final ItemDAO DAO = new ItemDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate() {
		final Item created = new Item(3L, "Oversized Novelty Gorilla", 10.10);
		assertEquals(created, DAO.create(created));
	}
		
		
	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L, "Really big chair", 500.25));
		expected.add(new Item(2L, "Endless bag of wine", 1004.21));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadLatest() {
		assertEquals(new Item(2L, "Endless bag of wine", 1004.21), DAO.readLatest());
	}
	
	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Item(ID, "Really big chair", 500.25), DAO.read(ID));
	}
	
	@Test
	public void testUpdate() {
		final Item updated = new Item(1L, "Oversized Novelty Gorilla", 20.50);
		assertEquals(updated, DAO.update(updated));
	}
	
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(2));
	}
	

	@Test
	public void testCreateFail() {
		String longName = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		Item chungus = new Item(longName, 420.69);
		assertEquals(null, DAO.create(chungus));
	}
	
	@Test
	public void testReadFail() {
		long badId = 25L;
		assertEquals(null, DAO.read(badId));
	}
	
	@Test
	public void testUpdateFail() {
		Item failure = new Item(null, "lul", 20.20);
		assertEquals(null, DAO.update(failure));
	}
}
