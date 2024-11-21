package com.mtk.statepattern.order.state.impl;

import com.mtk.statepattern.order.Order;
import com.mtk.statepattern.order.enums.OrderStatus;
import com.mtk.statepattern.order.state.OrderState;

public class OrderCreatedState implements OrderState
{
	@Override
	public void accept(Order order)
	{
		order.setState(new OrderPreparingState());
		order.setStatus(OrderStatus.PREPARING);
	}

	@Override
	public void prepare(Order order)
	{
		throw new IllegalStateException("Cannot prepare an order that hasn't been accepted.");
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
