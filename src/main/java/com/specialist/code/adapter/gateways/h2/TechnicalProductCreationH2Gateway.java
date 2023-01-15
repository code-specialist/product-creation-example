package com.specialist.code.adapter.gateways.h2;

import com.specialist.code.adapter.gateways.mapper.TechnicalProductJpaMapper;
import com.specialist.code.adapter.repositories.ITechnicalProductRepository;
import com.specialist.code.application.productcreation.boundaries.output.register.ITechnicalProdutRegisterGateway;
import com.specialist.code.domain.ITechnicalProduct;
import org.springframework.beans.factory.annotation.Autowired;

public class TechnicalProductCreationH2Gateway implements ITechnicalProdutRegisterGateway {
    @Autowired
    ITechnicalProductRepository _repository;

    public TechnicalProductCreationH2Gateway() {}

    @Override
    public void save(ITechnicalProduct iProduct) {
        TechnicalProductJpaMapper technicalProductJpaMapper = new TechnicalProductJpaMapper(iProduct.getId(), iProduct.getName(), iProduct.getDescription(), iProduct.getPrice(), iProduct.getCreatedAt(), iProduct.getTechnicalInformation(), iProduct.getInstructionManual());
        this._repository.save(technicalProductJpaMapper);
    }

    @Override
    public boolean existsById(String id) {
        return _repository.existsById(id);
    }
}
