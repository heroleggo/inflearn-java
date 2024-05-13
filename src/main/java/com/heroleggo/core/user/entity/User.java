package com.heroleggo.core.user.entity;

public class User {
    private Long id;
    private String name;
    private Type type;

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
