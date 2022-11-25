package com.specialist.code.application.interactors;

import com.specialist.code.application.boundaries.input.ICommonProductInputBoundary;
import com.specialist.code.application.boundaries.output.ICommonProductRegisterGateway;
import com.specialist.code.application.exception.ProductCustomException;
import com.specialist.code.application.exception.InvalidNameException;
import com.specialist.code.application.exception.ProductAlreadyExistsException;
import com.specialist.code.application.model.request.CommonProductRequestModel;
import com.specialist.code.application.model.response.CommonProductResponseModel;
import com.specialist.code.application.presenter.ICommonProductPresenter;
import com.specialist.code.domain.IProduct;
import com.specialist.code.domain.factories.ICommonProductFactory;

public class CommonProductInteractor implements ICommonProductInputBoundary {
    ICommonProductPresenter presenter;
    ICommonProductFactory factory;
    ICommonProductRegisterGateway gateway;

    public CommonProductInteractor(ICommonProductPresenter presenter, ICommonProductFactory factory, ICommonProductRegisterGateway gateway) {
        this.presenter = presenter;
        this.factory = factory;
        this.gateway = gateway;
    }

    @Override
    public CommonProductResponseModel create(CommonProductRequestModel requestModel) throws ProductCustomException {
        if (gateway.existsById(requestModel.getId())) {
            return presenter.prepareFailView(new ProductAlreadyExistsException("Product with id " + requestModel.getId() + " already in database"));
        }
        IProduct commonProduct = factory.create(requestModel.getId(), requestModel.getName(), requestModel.getDescription(), requestModel.getPrice());

        if (!commonProduct.nameIsValid()) {
            return presenter.prepareFailView(new InvalidNameException("Name " + commonProduct.getName() + " is not valid"));
        }

        gateway.save(commonProduct);

        CommonProductResponseModel responseModel = new CommonProductResponseModel(commonProduct.getId(), commonProduct.getName(), commonProduct.getDescription(), commonProduct.getPrice(), String.valueOf(commonProduct.getCreatedAt()));

        return presenter.prepareSuccessView(responseModel);
    }
}
