package com.specialist.code.application.presenter;

import com.specialist.code.application.model.response.CommonProductResponseModel;
import com.specialist.code.application.model.response.TechnicalProductResponseModel;

public interface ICommonProductPresenter {
    CommonProductResponseModel prepareFailView(String error);
    CommonProductResponseModel prepareSuccessView(CommonProductResponseModel responseModel);
}
