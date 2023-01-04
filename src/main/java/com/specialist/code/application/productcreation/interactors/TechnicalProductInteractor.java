package com.specialist.code.application.productcreation.interactors;

import com.specialist.code.application.productcreation.boundaries.input.register.ITechnicalProductInputBoundary;
import com.specialist.code.application.productcreation.boundaries.output.register.ITechnicalProdutRegisterGateway;
import com.specialist.code.application.productcreation.exception.InvalidNameException;
import com.specialist.code.application.productcreation.exception.InvalidTechnicalInformationException;
import com.specialist.code.application.productcreation.exception.ProductAlreadyExistsException;
import com.specialist.code.application.productcreation.exception.ProductCustomException;
import com.specialist.code.application.productcreation.model.request.TechnicalProductRequestModel;
import com.specialist.code.application.productcreation.model.response.TechnicalProductResponseModel;
import com.specialist.code.application.productcreation.presenter.ITechnicalProductPresenter;
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
    public TechnicalProductResponseModel create(TechnicalProductRequestModel requestModel) throws ProductCustomException {
        if (gateway.existsById(requestModel.getId())) {
            return presenter.prepareFailView(new ProductAlreadyExistsException("TechnicalProduct with id " + requestModel.getId() + " already in database"));
        }
        ITechnicalProduct technicalProduct = factory.create(requestModel.getId(), requestModel.getName(), requestModel.getDescription(), requestModel.getPrice(), requestModel.getTechnicalInformation(), requestModel.getInstructionManual());

        if (!technicalProduct.nameIsValid()) {
            return presenter.prepareFailView(new InvalidNameException("Name " + technicalProduct.getName() + " is not valid"));
        }
        if (!technicalProduct.technicalInformationIsValid()) {
            return presenter.prepareFailView(new InvalidTechnicalInformationException("Technical information " + technicalProduct.getTechnicalInformation() + " is not valid"));
        }

        gateway.save(technicalProduct);

        TechnicalProductResponseModel responseModel = new TechnicalProductResponseModel(technicalProduct.getId(), technicalProduct.getName(), technicalProduct.getDescription(), technicalProduct.getPrice(), requestModel.getTechnicalInformation(), requestModel.getInstructionManual(), String.valueOf(technicalProduct.getCreatedAt()));

        return presenter.prepareSuccessView(responseModel);
    }
}
