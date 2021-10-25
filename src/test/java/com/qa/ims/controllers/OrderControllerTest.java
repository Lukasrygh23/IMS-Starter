package com.qa.ims.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	
	
	@Mock
	private Utils utils;
	
	@Mock
	private OrderDAO dao;
	
	@InjectMocks
	private OrderController controller;
	
	
	@Test
	public void testCreate() {
		
	}
	
	@Test
	public void testReadAll() {
		
	}
	/**
	 * Do I need this???
	@Test
	public void testUpdate() {
		
	}
	*/
	
	@Test
	public void testDelete() {
		
	}
	
	
}
