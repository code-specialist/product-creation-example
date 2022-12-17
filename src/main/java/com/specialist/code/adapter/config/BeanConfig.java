package com.specialist.code.adapter.config;

import com.specialist.code.adapter.gateways.CommonProductCreationH2Gateway;
import com.specialist.code.adapter.gateways.TechnicalProductCreationH2Gateway;
import com.specialist.code.adapter.presenter.CommonProductPresenter;
import com.specialist.code.adapter.presenter.TechnicalProductPresenter;
import com.specialist.code.application.boundaries.input.register.ICommonProductInputBoundary;
import com.specialist.code.application.boundaries.input.register.ITechnicalProductInputBoundary;
import com.specialist.code.application.boundaries.output.ICommonProductRegisterGateway;
import com.specialist.code.application.boundaries.output.ITechnicalProdutRegisterGateway;
import com.specialist.code.application.interactors.CommonProductInteractor;
import com.specialist.code.application.interactors.TechnicalProductInteractor;
import com.specialist.code.application.presenter.ICommonProductPresenter;
import com.specialist.code.application.presenter.ITechnicalProductPresenter;
import com.specialist.code.domain.factories.CommonProductFactory;
import com.specialist.code.domain.factories.ICommonProductFactory;
import com.specialist.code.domain.factories.ITechnicalProductFactory;
import com.specialist.code.domain.factories.TechnicalProductFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    public ICommonProductPresenter commonProductPresenter(){
        return new CommonProductPresenter();
    }
    public ICommonProductFactory commonProductFactory(){
        return new CommonProductFactory();
    }
    public ICommonProductRegisterGateway commonProductRegisterGateway(){
        return new CommonProductCreationH2Gateway();
    }
    public ICommonProductInputBoundary commonProductInputBoundary(ICommonProductPresenter commonProductPresenter, ICommonProductFactory commonProductFactory, ICommonProductRegisterGateway commonProductRegisterGateway){

        return new CommonProductInteractor(commonProductPresenter, commonProductFactory, commonProductRegisterGateway);
    }

    public ITechnicalProductPresenter technicalProductPresenter(){
        return new TechnicalProductPresenter();
    }
    public ITechnicalProductFactory technicalProductFactory(){
        return new TechnicalProductFactory();
    }
    public ITechnicalProdutRegisterGateway technicalProdutRegisterGateway(){
        return new TechnicalProductCreationH2Gateway();
    }

    public ITechnicalProductInputBoundary technicalProductInputBoundary(ITechnicalProductPresenter technicalProductPresenter, ITechnicalProductFactory technicalProductFactory, ITechnicalProdutRegisterGateway technicalProdutRegisterGateway){
        return new TechnicalProductInteractor(technicalProductFactory, technicalProductPresenter, technicalProdutRegisterGateway);
    }

}
