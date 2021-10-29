package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class DomainTest {
	


	
	@Test
	public void testGetDomainRight() {
		Domain customer = null;
		customer = Domain.valueOf("CUSTOMER");
		assertEquals("CUSTOMER: Information about customers", customer.getDescription());
		
	}
	

}
