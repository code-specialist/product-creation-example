package com.specialist.code.adapter.presenter;

import com.specialist.code.application.productcreation.exception.ProductCustomException;
import com.specialist.code.application.productcreation.model.response.TechnicalProductResponseModel;
import com.specialist.code.application.productcreation.presenter.ITechnicalProductPresenter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TechnicalProductPresenter implements ITechnicalProductPresenter {
    @Override
    public TechnicalProductResponseModel prepareFailView(ProductCustomException e) throws ProductCustomException {
        throw e;
    }

    @Override
    public TechnicalProductResponseModel prepareSuccessView(TechnicalProductResponseModel responseModel) {
        LocalDateTime responseTime = LocalDateTime.parse(responseModel.getCreatedAt());
        responseModel.setCreatedAt(responseTime.format(DateTimeFormatter.ISO_LOCAL_DATE));
        return responseModel;
    }
}
