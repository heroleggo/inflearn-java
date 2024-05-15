package com.heroleggo.core.order.entity;

public class Order {
    private String name;
    private Long price;
    private Long discountPrice;
    private Long userId;

    public Order() {}

    public Order(String name, Long price, Long discountPrice, Long userId) {
        this.name = name;
        this.price = price;
        this.discountPrice = discountPrice;
        this.userId = userId;
    }

    public Long calculateFinalPrice() {
        return price - discountPrice;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public Long getDiscountPrice() {
        return discountPrice;
    }

    public Long getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setDiscountPrice(Long discountPrice) {
        this.discountPrice = discountPrice;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order {" +
            "User ID = " + userId +
            ", Goods name = '" + name + "'" +
            ", Price = " + price +
            ", Discount = " + discountPrice +
            "}";
    }
}
