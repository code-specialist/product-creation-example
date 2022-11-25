package com.specialist.code.adapter.presenter;

import com.specialist.code.application.exception.ProductCustomException;
import com.specialist.code.application.model.response.CommonProductResponseModel;
import com.specialist.code.application.presenter.ICommonProductPresenter;

public class CommonProductPresenter implements ICommonProductPresenter {
    @Override
    public CommonProductResponseModel prepareFailView(ProductCustomException e) throws ProductCustomException {
        throw e;
    }

    @Override
    public CommonProductResponseModel prepareSuccessView(CommonProductResponseModel responseModel) {
        return null;
    }
}
