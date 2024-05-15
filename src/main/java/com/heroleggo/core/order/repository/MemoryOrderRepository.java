package com.heroleggo.core.order.repository;

import com.heroleggo.core.order.entity.Order;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryOrderRepository implements OrderRepository {

    private final ConcurrentHashMap<Integer, Order> store = new ConcurrentHashMap<>();

    @Override
    public void save(Order order) {
        store.put(order.hashCode(), order);
    }

    @Override
    public Order findByHashcode(int hashCode) {
        return store.get(hashCode);
    }
}
