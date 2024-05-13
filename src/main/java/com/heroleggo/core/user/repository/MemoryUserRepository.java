package com.heroleggo.core.user.repository;

import com.heroleggo.core.user.entity.User;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryUserRepository implements UserRepository {
    private static ConcurrentHashMap<Long, User> store = new ConcurrentHashMap<>();

    @Override
    public void save(User user) {
        store.put(user.getId(), user);
    }

    @Override
    public User findById(Long id) {
        return store.get(id);
    }
}
