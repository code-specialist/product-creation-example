package com.specialist.code.application.productcreation.boundaries.input.register;

import com.specialist.code.application.productcreation.exception.ProductCustomException;
import com.specialist.code.application.productcreation.model.request.TechnicalProductRequestModel;
import com.specialist.code.application.productcreation.model.response.TechnicalProductResponseModel;

public interface ITechnicalProductInputBoundary {
    TechnicalProductResponseModel create(TechnicalProductRequestModel requestModel) throws ProductCustomException;
}
