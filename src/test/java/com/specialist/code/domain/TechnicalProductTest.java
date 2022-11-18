package com.specialist.code.domain;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TechnicalProductTest {

    @Test
    void givenEmptyTechnicalInformation_whenTechnicalInformationIsNotValid_thenIsFalse(){
        TechnicalProduct technicalProduct = new TechnicalProduct("ValidID", "Name", "Descr", 50.0d, "", "Instructions", Instant.now().toEpochMilli());

        assertFalse(technicalProduct.technicalInformationIsValid());
    }

    @Test
    void givenAbcTechnicalInformation_whenTechnicalInformationIsValid_thenIsTrue(){
        TechnicalProduct technicalProduct = new TechnicalProduct("ValidID", "ValidName", "Descr", 50.0d, "Some technical details", "Instructions", Instant.now().toEpochMilli());

        assertTrue(technicalProduct.technicalInformationIsValid());
    }

}
