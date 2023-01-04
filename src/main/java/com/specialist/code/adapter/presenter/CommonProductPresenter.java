package com.specialist.code.adapter.presenter;

import com.specialist.code.application.productcreation.exception.ProductCustomException;
import com.specialist.code.application.productcreation.model.response.CommonProductResponseModel;
import com.specialist.code.application.productcreation.presenter.ICommonProductPresenter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonProductPresenter implements ICommonProductPresenter {
    @Override
    public CommonProductResponseModel prepareFailView(ProductCustomException e) throws ProductCustomException {
        throw e;
    }

    @Override
    public CommonProductResponseModel prepareSuccessView(CommonProductResponseModel responseModel) {
        LocalDateTime responseTime = LocalDateTime.parse(responseModel.getCreatedAt());
        responseModel.setCreatedAt(responseTime.format(DateTimeFormatter.ISO_LOCAL_DATE));
        return responseModel;
    }
}
