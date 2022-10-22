package com.specialist.code;

import com.specialist.code.domain.TechnicalProduct;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TechnicalProductTest {

    @Test
    void givenEmptyTechnicalInformation_whenTechnicalInformationIsNotValid_thenIsFalse(){
        TechnicalProduct technicalProduct = new TechnicalProduct("ValidID", "Name", "Descr", 50.0d, "", "Instructions");

        assertFalse(technicalProduct.technicalInformationIsValid());
    }

    @Test
    void givenAbcTechnicalInformation_whenTechnicalInformationIsValid_thenIsTrue(){
        TechnicalProduct technicalProduct = new TechnicalProduct("ValidID", "ValidName", "Descr", 50.0d, "Some technical details", "Instructions");

        assertTrue(technicalProduct.technicalInformationIsValid());
    }

}
