package com.mtk.statepattern.order.state.impl;

import com.mtk.statepattern.order.Order;
import com.mtk.statepattern.order.enums.OrderStatus;
import com.mtk.statepattern.order.state.OrderState;

public class OrderDeliveringState implements OrderState
{
	@Override
	public void accept(Order order)
	{
		throw new IllegalStateException("Cannot accept an order that's being delivered.");
	}

	@Override
	public void prepare(Order order)
	{
		throw new IllegalStateException("Cannot prepare an order that's already being delivered.");
	}

	@Override
	public void deliver(Order order)
	{
		order.setState(new OrderCompletedState());
		order.setStatus(OrderStatus.DELIVERED);
	}

	@Override
	public void complete(Order order)
	{
		throw new IllegalStateException("Cannot complete an order that hasn't been delivered.");
	}
}