package com.mtk.statepattern.order;

import com.mtk.statepattern.order.enums.OrderStatus;
import com.mtk.statepattern.order.state.OrderState;
import com.mtk.statepattern.order.state.impl.OrderCreatedState;


public class Order
{
	private OrderState state;

	private OrderStatus status;

	public Order()
	{
		this.state = new OrderCreatedState();
		this.status = OrderStatus.CREATED;
	}

	public void accept()
	{
		state.accept(this);
		this.status = OrderStatus.PREPARING;
	}

	public void prepare()
	{
		state.prepare(this);
		this.status = OrderStatus.DELIVERING;
	}

	public void deliver()
	{
		state.deliver(this);
		this.status = OrderStatus.DELIVERED;
	}

	public void complete()
	{
		state.complete(this);
		this.status = OrderStatus.COMPLETED;
	}

	public OrderState getState()
	{
		return state;
	}

	public void setState(OrderState state)
	{
		this.state = state;
	}

	public OrderStatus getStatus()
	{
		return status;
	}

	public void setStatus(OrderStatus status)
	{
		this.status = status;
	}
}