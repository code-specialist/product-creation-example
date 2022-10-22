package com.specialist.code.domain.factories;

import com.specialist.code.domain.ITechnicalProduct;
import com.specialist.code.domain.TechnicalProduct;

public interface ITechnicalProductFactory {
    ITechnicalProduct create(String id, String name, String description, double price, String technicalInformation, String instructionManual);
}
