package com.specialist.code.domain.factories;

import com.specialist.code.domain.CommonProduct;
import com.specialist.code.domain.IProduct;
import com.specialist.code.domain.ITechnicalProduct;

public interface IProductFactory {
    IProduct create(String id, String name, String description, double price);
    ITechnicalProduct create(String id, String name, String description, double price, String technicalInformation, String instructionManual);
}
