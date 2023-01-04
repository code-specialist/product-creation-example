package com.specialist.code.application.productcreation.presenter;

import com.specialist.code.application.productcreation.exception.ProductCustomException;
import com.specialist.code.application.productcreation.model.response.CommonProductResponseModel;

public interface ICommonProductPresenter {
    CommonProductResponseModel prepareFailView(ProductCustomException e) throws ProductCustomException;
    CommonProductResponseModel prepareSuccessView(CommonProductResponseModel responseModel);
}
