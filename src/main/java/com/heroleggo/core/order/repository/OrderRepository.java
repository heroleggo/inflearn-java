package com.heroleggo.core.order.repository;

import com.heroleggo.core.order.entity.Order;

public interface OrderRepository {
    public void save(Order order);

    public Order findByHashcode(int hashcode);
}
