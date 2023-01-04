package com.specialist.code.application.productcreation.presenter;

import com.specialist.code.application.productcreation.exception.ProductCustomException;
import com.specialist.code.application.productcreation.model.response.TechnicalProductResponseModel;

public interface ITechnicalProductPresenter {

    TechnicalProductResponseModel prepareFailView(ProductCustomException e) throws ProductCustomException;
    TechnicalProductResponseModel prepareSuccessView(TechnicalProductResponseModel responseModel);
}
