package com.specialist.code.application.boundaries.output;

import com.specialist.code.application.model.request.TechnicalProductRequestModel;
import com.specialist.code.domain.ITechnicalProduct;

public interface ITechnicalProdutRegisterGateway extends IProductExistsGateway{
    void save(ITechnicalProduct requestModel);
}
