package com.heroleggo.core.order.service;

import com.heroleggo.core.user.entity.Type;

public class RateDiscountService implements DiscountService {
    private Long DISCOUNT_RATE = 10L;

    @Override
    public Long discount(Long amount, Type type) {
        if (type == Type.VIP) {
            return amount / 100L * DISCOUNT_RATE;
        }
        return 0L;
   }
}
