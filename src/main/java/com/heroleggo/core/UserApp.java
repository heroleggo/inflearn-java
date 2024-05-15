package com.heroleggo.core;

import com.heroleggo.core.order.entity.Order;
import com.heroleggo.core.order.service.OrderService;
import com.heroleggo.core.order.service.OrderServiceImpl;
import com.heroleggo.core.user.entity.Type;
import com.heroleggo.core.user.entity.User;
import com.heroleggo.core.user.service.UserService;
import com.heroleggo.core.user.service.UserServiceImpl;

public class UserApp {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        User a = new User(1L, "A", Type.VIP);

        userService.join(a);


        User findUser = userService.findUser(1L);

        System.out.println("new user = " + a.getName());
        System.out.println("found user = " + findUser.getName());

        Order order = orderService.createOrder(a.getId(), "order_1", 10000L);

        System.out.println("order = " + order);
    }
}
