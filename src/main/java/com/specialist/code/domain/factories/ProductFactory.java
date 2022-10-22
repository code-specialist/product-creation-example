package com.specialist.code.domain.factories;

import com.specialist.code.domain.CommonProduct;
import com.specialist.code.domain.ITechnicalProduct;
import com.specialist.code.domain.TechnicalProduct;

public class ProductFactory implements IProductFactory{
    @Override
    public CommonProduct create(String id, String name, String description, double price) {
        return new CommonProduct(id, name, description, price);
    }

    @Override
    public ITechnicalProduct create(String id, String name, String description, double price, String technicalInformation, String instructionManual) {
        return new TechnicalProduct(id, name, description, price, technicalInformation, instructionManual);
    }
}
