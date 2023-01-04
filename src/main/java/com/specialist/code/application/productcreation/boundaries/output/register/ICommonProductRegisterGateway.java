package com.specialist.code.application.productcreation.boundaries.output.register;

import com.specialist.code.domain.IProduct;

public interface ICommonProductRegisterGateway extends IProductExistsGateway{
    void save(IProduct iProduct);
}
