package com.specialist.code.adapter.beanconfigs;

import com.specialist.code.adapter.gateways.h2.CommonProductCreationH2Gateway;
import com.specialist.code.adapter.presenter.CommonProductPresenter;
import com.specialist.code.application.productcreation.boundaries.input.register.ICommonProductRegisterBoundary;
import com.specialist.code.application.productcreation.boundaries.output.register.ICommonProductRegisterGateway;
import com.specialist.code.application.productcreation.interactors.CommonProductInteractor;
import com.specialist.code.application.productcreation.presenter.ICommonProductPresenter;
import com.specialist.code.domain.factories.CommonProductFactory;
import com.specialist.code.domain.factories.ICommonProductFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonProductConfiguration {
    public ICommonProductPresenter commonProductPresenter() {
        return new CommonProductPresenter();
    }

    public ICommonProductFactory commonProductFactory() {
        return new CommonProductFactory();
    }

    public ICommonProductRegisterGateway commonProductRegisterGateway() {
        return new CommonProductCreationH2Gateway();
    }

    public ICommonProductRegisterBoundary commonProductInputBoundary(ICommonProductPresenter commonProductPresenter, ICommonProductFactory commonProductFactory, ICommonProductRegisterGateway commonProductRegisterGateway) {
        return new CommonProductInteractor(commonProductPresenter, commonProductFactory, commonProductRegisterGateway);
    }
}
