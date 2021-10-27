package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Order.class).verify();
	}
	
	@Test
	public void testToString() {
		Order testOrder = new Order(1L, 1L, "farts");
		//return "orderID:" + orderID + " customerID:" + customerID + " deliveryReason:" + deliveryReason;
		assertEquals(testOrder.toString(), "orderID:1 customerID:1 deliveryReason:farts");
	}
	
	@Test
	public void getOrderID() {
		Long longID = 1L;
		Order testOrder = new Order(1L, 1L, "farts");
		assertEquals(testOrder.getOrderId(), longID);
	}
}
