package com.specialist.code.application.presenter;

import com.specialist.code.application.model.response.TechnicalProductResponseModel;

public interface ITechnicalProductPresenter {
    TechnicalProductResponseModel prepareFailView(String error);
    TechnicalProductResponseModel prepareSuccessView(TechnicalProductResponseModel responseModel);
}
