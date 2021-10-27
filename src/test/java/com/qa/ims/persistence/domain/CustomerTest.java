package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}
	
	@Test
	public void testToString() {
		Customer testCustomer = new Customer(1L, "clare", "rooth");
		//return "id:" + id + " first name:" + firstName + " surname:" + surname;
		
		assertEquals(testCustomer.toString(), "id:1 first name:clare surname:rooth");
	}

}
