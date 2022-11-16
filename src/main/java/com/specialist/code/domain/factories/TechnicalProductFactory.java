package com.specialist.code.domain.factories;

import com.specialist.code.domain.ITechnicalProduct;
import com.specialist.code.domain.TechnicalProduct;

import java.time.Instant;

public class TechnicalProductFactory implements ITechnicalProductFactory{
    @Override
    public ITechnicalProduct create(String id, String name, String description, double price, String technicalInformation, String instructionManual) {
        return new TechnicalProduct(id, name, description, price, technicalInformation, instructionManual, Instant.now().toEpochMilli());
    }
}
