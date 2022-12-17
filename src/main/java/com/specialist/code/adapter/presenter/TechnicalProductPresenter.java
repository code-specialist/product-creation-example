package com.specialist.code.adapter.presenter;

import com.specialist.code.application.exception.ProductCustomException;
import com.specialist.code.application.model.response.TechnicalProductResponseModel;
import com.specialist.code.application.presenter.ITechnicalProductPresenter;

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
