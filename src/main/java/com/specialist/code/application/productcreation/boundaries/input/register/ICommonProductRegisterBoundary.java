package com.specialist.code.application.productcreation.boundaries.input.register;

import com.specialist.code.application.productcreation.exception.ProductCustomException;
import com.specialist.code.application.productcreation.model.request.CommonProductRequestModel;
import com.specialist.code.application.productcreation.model.response.CommonProductResponseModel;

public interface ICommonProductRegisterBoundary {
    CommonProductResponseModel create(CommonProductRequestModel requestModel) throws ProductCustomException;
}
