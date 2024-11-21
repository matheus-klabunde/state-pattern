package com.mtk.statepattern.order.state.impl;

import com.mtk.statepattern.order.Order;
import com.mtk.statepattern.order.enums.OrderStatus;
import com.mtk.statepattern.order.state.OrderState;

public class OrderPreparingState implements OrderState
{
	@Override
	public void accept(Order order)
	{
		throw new IllegalStateException("Order has already been accepted.");
	}

	@Override
	public void prepare(Order order)
	{
		order.setState(new OrderDeliveringState());
		order.setStatus(OrderStatus.DELIVERING);
	}

	@Override
	public void deliver(Order order)
	{
		throw new IllegalStateException("Cannot deliver an order that hasn't been prepared.");
	}

	@Override
	public void complete(Order order)
	{
		throw new IllegalStateException("Cannot complete an order that hasn't been delivered.");
	}
}
