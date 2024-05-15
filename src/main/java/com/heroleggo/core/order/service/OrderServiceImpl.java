package com.heroleggo.core.order.service;

import com.heroleggo.core.order.entity.Order;
import com.heroleggo.core.order.repository.MemoryOrderRepository;
import com.heroleggo.core.order.repository.OrderRepository;
import com.heroleggo.core.user.entity.User;
import com.heroleggo.core.user.service.UserService;
import com.heroleggo.core.user.service.UserServiceImpl;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository = new MemoryOrderRepository();
    private final DiscountService discountService = new TemporaryDiscountService();
    private final UserService userService = new UserServiceImpl();

    @Override
    public Order createOrder(Long userId, String goodName, Long price) {
        // 영한님 예제는 userRepository를 가져오고, 해당 레포지토리의 findById 메소드 사용
        User user = userService.findUser(userId);

        if (user == null) {
            return null;
        }

        Long discountPrice = discountService.discount(price, user.getType());

        return new Order(goodName, price, discountPrice, userId);

    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order findOrder(int hashcode) {
        return orderRepository.findByHashcode(hashcode);
    }
}
