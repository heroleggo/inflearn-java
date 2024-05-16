package com.heroleggo.core.order;

import com.heroleggo.core.order.service.RateDiscountService;
import com.heroleggo.core.user.entity.Type;
import com.heroleggo.core.user.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateDiscountTest {
    RateDiscountService rateDiscountService = new RateDiscountService();

    @Test
    @DisplayName("VIP = 10% Discount")
    public void VIPDiscountTest() {
        User user = new User(1L, "testUser", Type.VIP);

        Long discount = rateDiscountService.discount(10000L, user.getType());

        Assertions.assertThat(discount).isEqualTo(1000L);
    }

    @Test
    @DisplayName("NORMAL = No Discount")
    public void NormalDiscountTest() {
        User user = new User(2L, "testUser2", Type.NORMAL);

        Long discount = rateDiscountService.discount(10000L, user.getType());

        Assertions.assertThat(discount).isEqualTo(0L);
    }
}
