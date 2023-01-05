package com.specialist.code.adapter.controller.register;

import com.specialist.code.application.productcreation.boundaries.input.register.ICommonProductRegisterBoundary;
import com.specialist.code.application.productcreation.exception.ProductCustomException;
import com.specialist.code.application.productcreation.model.request.CommonProductRequestModel;
import com.specialist.code.application.productcreation.model.response.CommonProductResponseModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/commonProducts")
public class CommonProductRegisterController {
    ICommonProductRegisterBoundary inputBoundary;

    public CommonProductRegisterController(ICommonProductRegisterBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    @PostMapping("/create")
    public CommonProductResponseModel create(@RequestBody CommonProductRequestModel requestModel) throws ProductCustomException {
        return this.inputBoundary.create(requestModel);
    }
}
