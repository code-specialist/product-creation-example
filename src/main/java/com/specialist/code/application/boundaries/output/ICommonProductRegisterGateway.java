package com.specialist.code.application.boundaries.output;

import com.specialist.code.application.model.request.CommonProductRequestModel;
import com.specialist.code.domain.CommonProduct;
import com.specialist.code.domain.IProduct;

public interface ICommonProductRegisterGateway extends IProductExistsGateway{
    void save(IProduct iProduct);
}
