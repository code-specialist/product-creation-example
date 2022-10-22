package com.specialist.code.domain;

public class CommonProduct implements IProduct{
    private String id;
    private String name;
    private String description;
    private double price;

    private static final int MINIMUM_CHARACTER_LIMIT = 5;

    public CommonProduct(String id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean nameIsValid() {
        return name != null && name.length() >= MINIMUM_CHARACTER_LIMIT;
    }
}
