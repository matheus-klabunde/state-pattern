package com.mtk.statepattern.order.state;

import com.mtk.statepattern.order.Order;

public interface OrderState
{
	void accept(Order order);
	void prepare(Order order);
	void deliver(Order order);
	void complete(Order order);
}
