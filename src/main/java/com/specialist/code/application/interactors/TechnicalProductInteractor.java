package com.specialist.code.application.interactors;

import com.specialist.code.application.boundaries.input.ITechnicalProductInputBoundary;
import com.specialist.code.application.boundaries.output.ITechnicalProdutRegisterGateway;
import com.specialist.code.application.model.request.CommonProductRequestModel;
import com.specialist.code.application.model.request.TechnicalProductRequestModel;
import com.specialist.code.application.model.response.CommonProductResponseModel;
import com.specialist.code.application.model.response.TechnicalProductResponseModel;
import com.specialist.code.application.presenter.ITechnicalProductPresenter;
import com.specialist.code.domain.ITechnicalProduct;
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
        if (gateway.existsById(requestModel.getId())) {
            presenter.prepareFailView("TechnicalProduct with id " + requestModel.getId() + " already in database");
        }
        ITechnicalProduct technicalProduct = factory.create(requestModel.getId(), requestModel.getName(), requestModel.getDescription(), requestModel.getPrice(), requestModel.getTechnicalInformation(), requestModel.getInstructionManual());

        if (!technicalProduct.nameIsValid()) {
            presenter.prepareFailView("Name " + technicalProduct.getName() + " is not valid");
        }
        if (!technicalProduct.technicalInformationIsValid()) {
            presenter.prepareFailView("Technical information " + technicalProduct.getTechnicalInformation() + " is not valid");
        }

        gateway.save(technicalProduct);

        TechnicalProductResponseModel responseModel = new TechnicalProductResponseModel(technicalProduct.getId(), technicalProduct.getName(), technicalProduct.getDescription(), technicalProduct.getPrice(), requestModel.getTechnicalInformation(), requestModel.getInstructionManual(), technicalProduct.getCreatedAt());

        return presenter.prepareSuccessView(responseModel);
    }
}
