package com.heroleggo.core.order.service;

import com.heroleggo.core.order.entity.Order;
import com.heroleggo.core.user.entity.User;

public interface OrderService {
    public Order createOrder(Long userId, String goodName, Long price);
    public void saveOrder(Order order);
    public Order findOrder(int hashcode);
}
