package com.specialist.code.application.boundaries.input;

import com.specialist.code.application.model.request.CommonProductRequestModel;
import com.specialist.code.application.model.request.TechnicalProductRequestModel;
import com.specialist.code.application.model.response.CommonProductResponseModel;
import com.specialist.code.application.model.response.TechnicalProductResponseModel;

public interface ICommonProductInputBoundary {
    CommonProductResponseModel create(CommonProductRequestModel requestModel) throws Exception;
}
