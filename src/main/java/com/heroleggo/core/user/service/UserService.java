package com.heroleggo.core.user.service;

import com.heroleggo.core.user.entity.User;

public interface UserService {
    public void join(User user);

    public User findUser(Long id);
}
