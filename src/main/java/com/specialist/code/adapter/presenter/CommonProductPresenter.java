package com.specialist.code.adapter.presenter;

import com.specialist.code.application.exception.CustomProductException;
import com.specialist.code.application.model.response.CommonProductResponseModel;
import com.specialist.code.application.presenter.ICommonProductPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CommonProductPresenter implements ICommonProductPresenter {
    @Override
    public CommonProductResponseModel prepareFailView(CustomProductException e) throws CustomProductException{
        throw e;
    }

    @Override
    public CommonProductResponseModel prepareSuccessView(CommonProductResponseModel responseModel) {
        return null;
    }
}
