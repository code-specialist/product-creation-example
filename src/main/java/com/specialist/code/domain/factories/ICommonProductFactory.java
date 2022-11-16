package com.specialist.code.domain.factories;

import com.specialist.code.domain.IProduct;
import com.specialist.code.domain.ITechnicalProduct;

public interface ICommonProductFactory {
    IProduct create(String id, String name, String description, double price);
}
