package com.specialist.code.application.productcreation.boundaries.output.register;

import com.specialist.code.domain.ITechnicalProduct;

public interface ITechnicalProdutRegisterGateway extends IProductExistsGateway{
    void save(ITechnicalProduct iTechnicalProduct);
}
