package com.heroleggo.core.user.service;

import com.heroleggo.core.user.entity.User;
import com.heroleggo.core.user.repository.MemoryUserRepository;
import com.heroleggo.core.user.repository.UserRepository;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository = new MemoryUserRepository();

    @Override
    public void join(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUser(Long id) {
        return userRepository.findById(id);
    }
}
