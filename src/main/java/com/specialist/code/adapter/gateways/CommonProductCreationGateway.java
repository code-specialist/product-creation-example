package com.specialist.code.adapter.gateways;

import com.specialist.code.application.boundaries.output.ICommonProductRegisterGateway;
import com.specialist.code.domain.IProduct;
import com.specialist.code.domain.factories.ICommonProductFactory;

public class CommonProductCreationGateway implements ICommonProductRegisterGateway {
    @Override
    public void save(IProduct iProduct) {

    }

    @Override
    public boolean existsById(String id) {
        return false;
    }
}
