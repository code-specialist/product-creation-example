package com.specialist.code.adapter.gateways.h2;

import com.specialist.code.adapter.gateways.mapper.CommonProductJpaMapper;
import com.specialist.code.adapter.repositories.ICommonProductRepository;
import com.specialist.code.application.productcreation.boundaries.output.register.ICommonProductRegisterGateway;
import com.specialist.code.domain.IProduct;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonProductCreationH2Gateway implements ICommonProductRegisterGateway {
    @Autowired
    ICommonProductRepository _repository;

    public CommonProductCreationH2Gateway() {}

    @Override
    public void save(IProduct iProduct) {
        CommonProductJpaMapper commonProductJpaMapper = new CommonProductJpaMapper(iProduct.getId(), iProduct.getName(), iProduct.getDescription(), iProduct.getPrice(), iProduct.getCreatedAt());
        this._repository.save(commonProductJpaMapper);
    }

    @Override
    public boolean existsById(String id) {
        return _repository.existsById(id);
    }
}
