package com.heroleggo.core.order;

import com.heroleggo.core.config.AppConfig;
import com.heroleggo.core.order.entity.Order;
import com.heroleggo.core.order.service.OrderService;
import com.heroleggo.core.order.service.OrderServiceImpl;
import com.heroleggo.core.user.entity.Type;
import com.heroleggo.core.user.entity.User;
import com.heroleggo.core.user.service.UserService;
import com.heroleggo.core.user.service.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    private UserService userService;
    private OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        userService = appConfig.userService();
        orderService = appConfig.orderService();
    }

    @Test
    public void createOrderTest() {
        // create VIP User
        User user = new User(1L, "test", Type.VIP);

        // save user
        userService.join(user);

        // create order
        Order order = orderService.createOrder(user.getId(), "test", 10000L);

        // check discount
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000L);
    }
}
