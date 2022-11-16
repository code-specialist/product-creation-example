package com.specialist.code.domain;

public interface IProduct {
    String getId();
    String getName();
    String getDescription();

    long getCreatedAt();
    double getPrice();
    boolean nameIsValid();
}
