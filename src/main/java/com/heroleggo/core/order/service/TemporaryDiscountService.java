package com.heroleggo.core.order.service;

import com.heroleggo.core.user.entity.Type;

public class TemporaryDiscountService implements DiscountService {

    private final Long VIP_DISCOUNT_PRICE = 1000L;
    private final Long NORMAL_DISCOUNT_PRICE = 0L;

    @Override
    public Long discount(Long amount, Type type) {
        if (type.equals(Type.VIP)) {
            return VIP_DISCOUNT_PRICE;
        }
        // 이 아래 블록은 return 0으로 대체 가능
        if (type.equals(Type.NORMAL)) {
            return NORMAL_DISCOUNT_PRICE;
        }
        return 0L;
    }
}
