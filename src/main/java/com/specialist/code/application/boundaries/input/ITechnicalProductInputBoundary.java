package com.specialist.code.application.boundaries.input;

import com.specialist.code.application.exception.CustomProductException;
import com.specialist.code.application.model.request.TechnicalProductRequestModel;
import com.specialist.code.application.model.response.TechnicalProductResponseModel;

public interface ITechnicalProductInputBoundary {
    TechnicalProductResponseModel create(TechnicalProductRequestModel requestModel) throws CustomProductException;
}
