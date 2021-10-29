package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Item.class).verify();
	}

	@Test
	public void testToString() {
		Item testItem = new Item(1L, "test1", 10.00);
		assertEquals(testItem.toString(), "id:1 Item Name:test1 Item Value:10.0");
	}
	
}
