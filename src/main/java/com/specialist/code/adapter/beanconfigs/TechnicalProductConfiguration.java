package com.specialist.code.adapter.beanconfigs;

import com.specialist.code.adapter.gateways.h2.TechnicalProductCreationH2Gateway;
import com.specialist.code.adapter.presenter.TechnicalProductPresenter;
import com.specialist.code.application.productcreation.boundaries.input.register.ITechnicalProductRegisterBoundary;
import com.specialist.code.application.productcreation.boundaries.output.register.ITechnicalProdutRegisterGateway;
import com.specialist.code.application.productcreation.interactors.TechnicalProductInteractor;
import com.specialist.code.application.productcreation.presenter.ITechnicalProductPresenter;
import com.specialist.code.domain.factories.ITechnicalProductFactory;
import com.specialist.code.domain.factories.TechnicalProductFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TechnicalProductConfiguration {
    public ITechnicalProductPresenter technicalProductPresenter() {
        return new TechnicalProductPresenter();
    }

    public ITechnicalProductFactory technicalProductFactory() {
        return new TechnicalProductFactory();
    }

    public ITechnicalProdutRegisterGateway technicalProdutRegisterGateway() {
        return new TechnicalProductCreationH2Gateway();
    }

    public ITechnicalProductRegisterBoundary technicalProductInputBoundary(ITechnicalProductPresenter technicalProductPresenter, ITechnicalProductFactory technicalProductFactory, ITechnicalProdutRegisterGateway technicalProdutRegisterGateway) {
        return new TechnicalProductInteractor(technicalProductFactory, technicalProductPresenter, technicalProdutRegisterGateway);
    }

}
