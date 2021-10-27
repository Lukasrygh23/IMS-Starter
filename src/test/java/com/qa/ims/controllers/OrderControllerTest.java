package com.qa.ims.controllers;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
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
		final String D_REASON = "Gag Gift";
		final Long C_ID = 1L;
		final Order created = new Order(C_ID, D_REASON);
		
		Mockito.when(utils.getLong()).thenReturn(C_ID);
		Mockito.when(utils.getString()).thenReturn(D_REASON);
		Mockito.when(dao.create(created)).thenReturn(created);
		
		assertEquals(created, controller.create());
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
	
	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, "Art exhibit"));
		
		Mockito.when(dao.readAll()).thenReturn(orders);
		
		assertEquals(orders, controller.readAll());
		
		Mockito.verify(dao, Mockito.times(1)).readAll();
		
	}

	@Test
	public void testUpdate() {
		
		assertEquals(null, controller.update());
	}
	
	
	@Test
	public void testDelete() {
		final long ID = 1L;
		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);
		
		assertEquals(1L, this.controller.delete());
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
		
	}
	
	@Test
	public void addItemTest() {
		final Long O_ID = 1L;
		final Long I_ID = 1L;


		final OrderItem created = new OrderItem(O_ID, I_ID);
		
		Mockito.when(utils.getLong()).thenReturn(1L, 1L);
		Mockito.when(dao.addItem(created)).thenReturn(created);
		
		assertEquals(created, controller.addItem());
		
		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(dao, Mockito.times(1)).addItem(created);
	}
	
	@Test
	public void removeItemTest() {
		final long ID = 1;
		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.removeItem(ID)).thenReturn(1);
		
		assertEquals(1L, this.controller.removeItem());
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).removeItem(ID);
		
	}
	
	@Test
	public void calculateCostTest() {
		final long orderID = 1;
		final double totalCost = 200.00;
		
		Mockito.when(utils.getLong()).thenReturn(orderID);
		Mockito.when(dao.cost(orderID)).thenReturn(totalCost);
		
		Double testCost = this.controller.cost();
		assertTrue(totalCost == testCost);
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).cost(orderID);
	}
	
	
}
