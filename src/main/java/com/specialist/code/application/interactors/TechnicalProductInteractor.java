package com.specialist.code.application.interactors;

import com.specialist.code.application.boundaries.input.ITechnicalProductInputBoundary;
import com.specialist.code.application.boundaries.output.ITechnicalProdutRegisterGateway;
import com.specialist.code.application.model.request.TechnicalProductRequestModel;
import com.specialist.code.application.model.response.TechnicalProductResponseModel;
import com.specialist.code.application.presenter.ITechnicalProductPresenter;
import com.specialist.code.domain.factories.ITechnicalProductFactory;

public class TechnicalProductInteractor implements ITechnicalProductInputBoundary {
    ITechnicalProductFactory factory;
    ITechnicalProductPresenter presenter;
    ITechnicalProdutRegisterGateway gateway;

    public TechnicalProductInteractor(ITechnicalProductFactory factory, ITechnicalProductPresenter presenter, ITechnicalProdutRegisterGateway gateway) {
        this.factory = factory;
        this.presenter = presenter;
        this.gateway = gateway;
    }

    @Override
    public TechnicalProductResponseModel create(TechnicalProductRequestModel requestModel) {
        return null;
    }
}
