package com.specialist.code.application.presenter;

import com.specialist.code.application.exception.CustomProductException;
import com.specialist.code.application.model.response.TechnicalProductResponseModel;

public interface ITechnicalProductPresenter {
    TechnicalProductResponseModel prepareFailView(Exception e) throws CustomProductException;
    TechnicalProductResponseModel prepareSuccessView(TechnicalProductResponseModel responseModel);
}
