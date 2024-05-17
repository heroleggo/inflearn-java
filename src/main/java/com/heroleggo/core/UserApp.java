package com.heroleggo.core;

import com.heroleggo.core.config.AppConfig;
import com.heroleggo.core.order.entity.Order;
import com.heroleggo.core.order.service.OrderService;
import com.heroleggo.core.order.service.OrderServiceImpl;
import com.heroleggo.core.user.entity.Type;
import com.heroleggo.core.user.entity.User;
import com.heroleggo.core.user.service.UserService;
import com.heroleggo.core.user.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

//        AppConfig appConfig = new AppConfig();
//        UserService userService = appConfig.userService();
//        OrderService orderService = appConfig.orderService();

        User a = new User(1L, "A", Type.VIP);

        userService.join(a);


        User findUser = userService.findUser(1L);

        System.out.println("new user = " + a.getName());
        System.out.println("found user = " + findUser.getName());

        Order order = orderService.createOrder(a.getId(), "order_1", 10000L);

        System.out.println("order = " + order);
    }
}
