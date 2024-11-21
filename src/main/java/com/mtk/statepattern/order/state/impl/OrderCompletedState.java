package com.mtk.statepattern.order.state.impl;

import com.mtk.statepattern.order.Order;
import com.mtk.statepattern.order.enums.OrderStatus;
import com.mtk.statepattern.order.state.OrderState;

public class OrderCompletedState implements OrderState
{
	@Override
	public void accept(Order order)
	{
		throw new IllegalStateException("Order is already completed.");
	}

	@Override
	public void prepare(Order order)
	{
		throw new IllegalStateException("Order is already completed.");
	}

	@Override
	public void deliver(Order order)
	{
		throw new IllegalStateException("Order is already completed.");
	}

	@Override
	public void complete(Order order)
	{
		order.setState(new OrderCompletedState());
		order.setStatus(OrderStatus.COMPLETED);
	}
}