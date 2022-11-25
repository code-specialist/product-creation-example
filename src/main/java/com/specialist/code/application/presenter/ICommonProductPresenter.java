package com.specialist.code.application.presenter;

import com.specialist.code.application.exception.ProductCustomException;
import com.specialist.code.application.model.response.CommonProductResponseModel;

public interface ICommonProductPresenter {
    CommonProductResponseModel prepareFailView(ProductCustomException e) throws ProductCustomException;
    CommonProductResponseModel prepareSuccessView(CommonProductResponseModel responseModel);
}
