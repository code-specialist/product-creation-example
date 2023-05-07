package com.specialist.code.domain;

import com.specialist.code.domain.CommonProduct;
import com.specialist.code.domain.IProduct;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommonProductTest {

    @Test
    public void test_givenAbcName_whenNameIsNotValid_thenIsFalse(){
        IProduct product = new CommonProduct("Abc", "Name", "description", 0.5d, Instant.now().toEpochMilli());
        assertFalse(product.nameIsValid());
    }

    @Test
    public void test_givenUUiName_whenNameIsNotValid_thenIsFalse(){
        IProduct product = new CommonProduct("Abc", "ValidName", "description", 0.5d, Instant.now().toEpochMilli());

        assertTrue(product.nameIsValid());
    }

}
