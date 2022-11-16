package com.specialist.code.application.interactors;

import com.specialist.code.application.boundaries.input.ICommonProductInputBoundary;
import com.specialist.code.application.boundaries.output.ICommonProductRegisterGateway;
import com.specialist.code.application.model.request.TechnicalProductRequestModel;
import com.specialist.code.application.model.response.TechnicalProductResponseModel;
import com.specialist.code.application.presenter.ICommonProductPresenter;
import com.specialist.code.domain.ITechnicalProduct;
import com.specialist.code.domain.factories.ICommonProductFactory;
import com.specialist.code.domain.factories.ITechnicalProductFactory;

public class CommonProductInteractor implements ICommonProductInputBoundary {
    ICommonProductPresenter presenter;
    ITechnicalProductFactory factory;
    ICommonProductRegisterGateway gateway;

    public CommonProductInteractor(ICommonProductPresenter presenter, ITechnicalProductFactory factory, ICommonProductRegisterGateway gateway) {
        this.presenter = presenter;
        this.factory = factory;
        this.gateway = gateway;
    }

    @Override
    public TechnicalProductResponseModel create(TechnicalProductRequestModel requestModel) {
        if(gateway.existsById(requestModel.getId())){
           presenter.prepareFailView("TechnicalProduct with id " + requestModel.getId() + " already in database");
        }
        ITechnicalProduct technicalProduct = factory.create(requestModel.getId(), requestModel.getName(), requestModel.getDescription(), requestModel.getPrice(), requestModel.getTechnicalInformation(), requestModel.getInstructionManual());

        if(!technicalProduct.nameIsValid()){
            presenter.prepareFailView("Name " + technicalProduct.getName() + " is not valid");
        }
        if(!technicalProduct.technicalInformationIsValid()){
            presenter.prepareFailView("Technical information " + technicalProduct.getTechnicalInformation() + " is not valid");
        }





        return null;
    }
}
