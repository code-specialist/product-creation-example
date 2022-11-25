package com.specialist.code.application.presenter;

import com.specialist.code.application.exception.ProductCustomException;
import com.specialist.code.application.model.response.TechnicalProductResponseModel;

public interface ITechnicalProductPresenter {
    TechnicalProductResponseModel prepareFailView(Exception e) throws ProductCustomException;
    TechnicalProductResponseModel prepareSuccessView(TechnicalProductResponseModel responseModel);
}
