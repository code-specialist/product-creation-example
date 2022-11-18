package com.specialist.code.application.presenter;

import com.specialist.code.application.exception.CustomProductException;
import com.specialist.code.application.model.response.CommonProductResponseModel;
import com.specialist.code.application.model.response.TechnicalProductResponseModel;

public interface ICommonProductPresenter {
    CommonProductResponseModel prepareFailView(CustomProductException e) throws CustomProductException;
    CommonProductResponseModel prepareSuccessView(CommonProductResponseModel responseModel);
}
