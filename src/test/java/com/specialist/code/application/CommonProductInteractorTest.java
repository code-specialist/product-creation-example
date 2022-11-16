package com.specialist.code.application;

import com.specialist.code.application.boundaries.output.ICommonProductRegisterGateway;
import com.specialist.code.application.model.request.CommonProductRequestModel;
import com.specialist.code.application.model.response.CommonProductResponseModel;
import com.specialist.code.application.presenter.ICommonProductPresenter;
import com.specialist.code.domain.CommonProduct;
import com.specialist.code.domain.factories.ICommonProductFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CommonProductInteractorTest {

    @Mock
    ICommonProductFactory mockedFactory;

    @Mock
    ICommonProductPresenter mockedPresenter;

    @Mock
    ICommonProductRegisterGateway mockedGateway;

    CommonProductRequestModel requestModel;

    @BeforeEach
    void Setup(){
        requestModel = new CommonProductRequestModel("TestId", "ValidTestName", "Test description", 52.2);
    }

    @Test
    void givenValidCommonProductProperties_whenCreate_thenSaveItAndPrepareSuccessView(){

        long timestmap = 1668617824L;
        CommonProduct product = new CommonProduct("001", "ValidName", "Some Description", 25.25d, timestmap);

        Mockito.when(mockedFactory.create(requestModel.getId(), requestModel.getName(), requestModel.getDescription(), requestModel.getPrice())).thenReturn(product);


        Mockito.verify(mockedGateway, Mockito.times(1)).save(product);

        CommonProductResponseModel responseModel = Mockito.verify(mockedPresenter.prepareSuccessView(new CommonProductResponseModel(product.getId(), product.getName(), product.getDescription(), product.getPrice(), String.valueOf(timestmap))), Mockito.times(1));

        Assertions.assertEquals("2022-11-16", responseModel.getCreatedAt());

    }
}
