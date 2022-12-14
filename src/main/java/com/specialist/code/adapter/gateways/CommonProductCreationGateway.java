package com.specialist.code.adapter.gateways;

import com.specialist.code.adapter.gateways.mapper.CommonProductJpaMapper;
import com.specialist.code.adapter.repositories.ICommonProductRepository;
import com.specialist.code.application.boundaries.output.ICommonProductRegisterGateway;
import com.specialist.code.domain.IProduct;

public class CommonProductCreationGateway implements ICommonProductRegisterGateway {
    ICommonProductRepository _repository;

    public CommonProductCreationGateway(ICommonProductRepository _repository) {
        this._repository = _repository;
    }

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
