package com.specialist.code.domain.factories;

import com.specialist.code.domain.CommonProduct;

import java.time.Instant;

public class CommonProductFactory implements ICommonProductFactory {
    @Override
    public CommonProduct create(String id, String name, String description, double price) {
        return new CommonProduct(id, name, description, price,  Instant.now().toEpochMilli());
    }

}
