package com.heroleggo.core.config;

import com.heroleggo.core.order.service.DiscountService;
import com.heroleggo.core.order.service.OrderService;
import com.heroleggo.core.order.service.OrderServiceImpl;
import com.heroleggo.core.order.service.RateDiscountService;
import com.heroleggo.core.user.repository.MemoryUserRepository;
import com.heroleggo.core.user.repository.UserRepository;
import com.heroleggo.core.user.service.UserService;
import com.heroleggo.core.user.service.UserServiceImpl;

public class AppConfig {
    public UserService userService() {
        return new UserServiceImpl(userRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(userService(), discountService());
    }

    public UserRepository userRepository() {
        return new MemoryUserRepository();
    }

    public DiscountService discountService() {
        return new RateDiscountService();
    }
}
