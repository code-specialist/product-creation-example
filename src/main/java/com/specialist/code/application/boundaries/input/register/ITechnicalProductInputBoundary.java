package com.specialist.code.application.boundaries.input.register;

import com.specialist.code.application.exception.ProductCustomException;
import com.specialist.code.application.model.request.TechnicalProductRequestModel;
import com.specialist.code.application.model.response.TechnicalProductResponseModel;

public interface ITechnicalProductInputBoundary {
    TechnicalProductResponseModel create(TechnicalProductRequestModel requestModel) throws ProductCustomException;
}
