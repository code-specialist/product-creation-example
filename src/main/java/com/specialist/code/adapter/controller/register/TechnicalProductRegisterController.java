package com.specialist.code.adapter.controller.register;

import com.specialist.code.application.boundaries.input.register.ITechnicalProductInputBoundary;
import com.specialist.code.application.exception.ProductCustomException;
import com.specialist.code.application.model.request.TechnicalProductRequestModel;
import com.specialist.code.application.model.response.TechnicalProductResponseModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/technicalProduct")
public class TechnicalProductRegisterController {
    ITechnicalProductInputBoundary inputBoundary;

    public TechnicalProductRegisterController(ITechnicalProductInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    @PostMapping("/create")
    public TechnicalProductResponseModel create(@RequestBody TechnicalProductRequestModel requestModel) throws ProductCustomException {
        return inputBoundary.create(requestModel);
    }
}
