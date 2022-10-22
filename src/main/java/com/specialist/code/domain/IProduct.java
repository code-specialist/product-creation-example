package com.specialist.code.domain;

public interface IProduct {
    String getId();
    String getName();
    String getDescription();
    double getPrice();
    boolean nameIsValid();
}
