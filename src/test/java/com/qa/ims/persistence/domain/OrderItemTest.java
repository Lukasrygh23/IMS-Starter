package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderItemTest {
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(OrderItem.class).verify();
	}
	
	@Test
	public void orderItemTest() {
		//"orderItem id: " + orderItemID + " order ID:" + orderID + " itemID:" + itemID
		OrderItem testItem = new OrderItem(1L, 1L, 1L);
		assertEquals(testItem.toString(), "orderItem id:1 order ID:1 itemID:1");
	}
}
