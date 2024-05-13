package com.heroleggo.core.user.repository;

import com.heroleggo.core.user.entity.User;

public interface UserRepository {
    public void save(User user);

    public User findById(Long id);
}
