package com.specialist.code.domain;

public class CommonProduct implements IProduct {
    private String id;
    private String name;
    private String description;
    private double price;

    private long createdAt;

    private static final int MINIMUM_CHARACTER_LIMIT = 5;

    public CommonProduct(String id, String name, String description, double price, long createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public long getCreatedAt() {
        return this.createdAt;
    }
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public boolean nameIsValid() {
        return name != null && name.length() >= MINIMUM_CHARACTER_LIMIT;
    }
}
