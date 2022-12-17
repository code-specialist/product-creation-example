package com.specialist.code.application.boundaries.input.register;

import com.specialist.code.application.exception.ProductCustomException;
import com.specialist.code.application.model.request.CommonProductRequestModel;
import com.specialist.code.application.model.response.CommonProductResponseModel;

public interface ICommonProductInputBoundary {
    CommonProductResponseModel create(CommonProductRequestModel requestModel) throws ProductCustomException;
}
