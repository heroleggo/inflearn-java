package com.heroleggo.core.order.service;

import com.heroleggo.core.user.entity.Type;

public interface DiscountService {
    public Long discount(Long amount, Type type);
}
