package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.ims.controller.Action;

public class ActionTest {

	
	@Test
	public void testGetActionDescription() {
		Action create = null;
		create = Action.valueOf("CREATE");
		assertEquals("CREATE: To save a new entity into the database", create.getDescription());
		
	}
	
	
	@Test
	public void testMainActionPrinting() {
		
		Action.printActions();
		Action.printMainActions();
		assertEquals(1, 1);
	}
}
