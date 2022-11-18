package com.specialist.code.application.interactors;

import com.specialist.code.application.boundaries.input.ITechnicalProductInputBoundary;
import com.specialist.code.application.boundaries.output.ITechnicalProdutRegisterGateway;
import com.specialist.code.application.exception.CustomProductException;
import com.specialist.code.application.exception.InvalidNameException;
import com.specialist.code.application.exception.InvalidTechnicalInformationException;
import com.specialist.code.application.model.request.TechnicalProductRequestModel;
import com.specialist.code.application.model.response.TechnicalProductResponseModel;
import com.specialist.code.application.presenter.ITechnicalProductPresenter;
import com.specialist.code.domain.ITechnicalProduct;
import com.specialist.code.domain.factories.ITechnicalProductFactory;

import java.nio.file.FileAlreadyExistsException;

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
    public TechnicalProductResponseModel create(TechnicalProductRequestModel requestModel) throws CustomProductException {
        if (gateway.existsById(requestModel.getId())) {
            return presenter.prepareFailView(new FileAlreadyExistsException("TechnicalProduct with id " + requestModel.getId() + " already in database"));
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
