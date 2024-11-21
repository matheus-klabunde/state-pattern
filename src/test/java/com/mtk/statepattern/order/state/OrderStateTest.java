package com.mtk.statepattern.order.state;

import static org.junit.jupiter.api.Assertions.*;

import com.mtk.statepattern.order.Order;
import com.mtk.statepattern.order.enums.OrderStatus;
import org.junit.jupiter.api.Test;

class OrderStateTest {

	@Test
	void testStateTransitions() {
		Order order = new Order();

		// Created -> Preparing
		order.accept();
		assertEquals(OrderStatus.PREPARING, order.getStatus());

		// Preparing -> Delivering
		order.prepare();
		assertEquals(OrderStatus.DELIVERING, order.getStatus());

		// Delivering -> Delivered
		order.deliver();
		assertEquals(OrderStatus.DELIVERED, order.getStatus());

		// Delivered -> Completed
		order.complete();
		assertEquals(OrderStatus.COMPLETED, order.getStatus());
	}

	@Test
	void testInvalidTransitions() {
		Order order = new Order();

		// Attempting to deliver an unprepared order
		assertThrows(IllegalStateException.class, order::deliver);
	}
}