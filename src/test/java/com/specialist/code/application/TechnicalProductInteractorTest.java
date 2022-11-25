package com.specialist.code.application;

import com.specialist.code.application.boundaries.output.ITechnicalProdutRegisterGateway;
import com.specialist.code.application.exception.ProductCustomException;
import com.specialist.code.application.exception.InvalidNameException;
import com.specialist.code.application.exception.InvalidTechnicalInformationException;
import com.specialist.code.application.exception.ProductAlreadyExistsException;
import com.specialist.code.application.interactors.TechnicalProductInteractor;
import com.specialist.code.application.model.request.TechnicalProductRequestModel;
import com.specialist.code.application.model.response.TechnicalProductResponseModel;
import com.specialist.code.application.presenter.ITechnicalProductPresenter;
import com.specialist.code.domain.ITechnicalProduct;
import com.specialist.code.domain.TechnicalProduct;
import com.specialist.code.domain.factories.ITechnicalProductFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TechnicalProductInteractorTest {
    private ITechnicalProdutRegisterGateway gateway;

    private ITechnicalProductFactory factory;

    private ITechnicalProductPresenter presenter;

    @BeforeEach
    void setup(){
        gateway = Mockito.mock(ITechnicalProdutRegisterGateway.class);
        factory = Mockito.mock(ITechnicalProductFactory.class);
        presenter = Mockito.mock(ITechnicalProductPresenter.class);
    }

    @Test
    void givenValidTechnicalProperties_whenCreate_thenPrepareSuccessView() throws ProductCustomException {
        // ARRANGE
        long timestamp = 1668617824L;
        TechnicalProductRequestModel requestModel = new TechnicalProductRequestModel("SomeId", "ValidName", "Some description",
                25.68, "A valid technical information", "A valid technical manual");
        ITechnicalProduct product = new TechnicalProduct(requestModel.getId(), requestModel.getName(), requestModel.getDescription(),
                requestModel.getPrice(), requestModel.getTechnicalInformation(), requestModel.getInstructionManual(),
                timestamp);
        TechnicalProductResponseModel responseModel = new TechnicalProductResponseModel(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getTechnicalInformation(), product.getInstructionManual(), String.valueOf(timestamp));
        TechnicalProductResponseModel finalResponseModel = new TechnicalProductResponseModel(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getTechnicalInformation(), product.getInstructionManual(), "2022-11-16");

        Mockito.when(gateway.existsById(product.getId())).thenReturn(false);
        Mockito.when(factory.create(requestModel.getId(), requestModel.getName(), requestModel.getDescription(), requestModel.getPrice(), requestModel.getTechnicalInformation(), requestModel.getInstructionManual())).thenReturn(product);
        Mockito.when(presenter.prepareSuccessView(responseModel)).thenReturn(finalResponseModel);

        // ACT
        TechnicalProductInteractor interactor = new TechnicalProductInteractor(factory, presenter, gateway);
        TechnicalProductResponseModel verifyResponseModel = interactor.create(requestModel);

        Mockito.verify(gateway, Mockito.times(1)).save(product);
        Mockito.verify(presenter, Mockito.times(1)).prepareSuccessView(responseModel);

        Assertions.assertEquals(finalResponseModel.getId(), verifyResponseModel.getId());
        Assertions.assertEquals(finalResponseModel.getName(), verifyResponseModel.getName());
        Assertions.assertEquals(finalResponseModel.getDescription(), verifyResponseModel.getDescription());
        Assertions.assertEquals(finalResponseModel.getPrice(), verifyResponseModel.getPrice());
        Assertions.assertEquals(finalResponseModel.getTechnicalInformation(), verifyResponseModel.getTechnicalInformation());
        Assertions.assertEquals(finalResponseModel.getInstructionManual(), verifyResponseModel.getInstructionManual());
        Assertions.assertEquals("2022-11-16", verifyResponseModel.getCreatedAt());
    }

    @Test
    void givenTechnicalProductAlreadyExists_whenCreate_thenPrepareFailView() throws ProductCustomException {
        // ARRANGE
        TechnicalProductRequestModel requestModel = new TechnicalProductRequestModel("ExistingID", "ValidName", "Some description",
                25.68, "A valid technical information", "A valid technical manual");
        Mockito.when(gateway.existsById(requestModel.getId())).thenReturn(true);

        String errorMessage = "TechnicalProduct with id ExistingID already in database";
        ProductAlreadyExistsException alreadyExistsException = new ProductAlreadyExistsException(errorMessage);
        Mockito.when(presenter.prepareFailView(alreadyExistsException)).thenThrow(alreadyExistsException);

        Exception failViewException = Assertions.assertThrows(ProductCustomException.class, () -> {
            presenter.prepareFailView(alreadyExistsException);
        });

        // ACT
        TechnicalProductInteractor interactor = new TechnicalProductInteractor(factory, presenter, gateway);
        interactor.create(requestModel);

        // ASSERT
        Assertions.assertTrue(failViewException.getMessage().contains(errorMessage));
        Mockito.verify(gateway, Mockito.times(1)).existsById(requestModel.getId());
        Mockito.verify(presenter, Mockito.times(1)).prepareFailView(alreadyExistsException);
    }

    @Test
    void givenTechnicalProductWithInvalidName_whenCreate_thenPrepareFailView() throws ProductCustomException {
        // ARRANGE
        long timestamp = 1668617824L;
        TechnicalProductRequestModel requestModel = new TechnicalProductRequestModel("SomeId", "123", "Some description",
                25.68, "A valid technical information", "A valid technical manual");
        ITechnicalProduct product = new TechnicalProduct(requestModel.getId(), requestModel.getName(), requestModel.getDescription(),
                requestModel.getPrice(), requestModel.getTechnicalInformation(), requestModel.getInstructionManual(),
                timestamp);
        Mockito.when(gateway.existsById(product.getId())).thenReturn(false);
        Mockito.when(factory.create(requestModel.getId(), requestModel.getName(), requestModel.getDescription(), requestModel.getPrice(), requestModel.getTechnicalInformation(), requestModel.getInstructionManual())).thenReturn(product);
        String errorMessage = "Name 123 is not valid";
        InvalidNameException invalidNameException = new InvalidNameException(errorMessage);
        Mockito.when(presenter.prepareFailView(invalidNameException)).thenThrow(invalidNameException);

        Exception failViewException = Assertions.assertThrows(Exception.class, () -> {
            presenter.prepareFailView(invalidNameException);
        });

        // ACT
        TechnicalProductInteractor interactor = new TechnicalProductInteractor(factory, presenter, gateway);
        interactor.create(requestModel);

        // ASSERT
        Assertions.assertTrue(failViewException.getMessage().contains(errorMessage));
        Mockito.verify(gateway, Mockito.times(1)).existsById(product.getId());
        Mockito.verify(factory, Mockito.times(1)).create(requestModel.getId(), requestModel.getName(), requestModel.getDescription(), requestModel.getPrice(), requestModel.getTechnicalInformation(), requestModel.getInstructionManual());
        Mockito.verify(presenter, Mockito.times(1)).prepareFailView(invalidNameException);
    }

    @Test
    void givenTechnicalProductWithInvalidTechnicalInformation_whenCreate_thenPrepareFailView() throws ProductCustomException {
        // ARRANGE
        long timestamp = 1668617824L;
        TechnicalProductRequestModel requestModel = new TechnicalProductRequestModel("SomeId", "ValidName", "Some description",
                25.68, "", "A valid technical manual");
        ITechnicalProduct product = new TechnicalProduct(requestModel.getId(), requestModel.getName(), requestModel.getDescription(),
                requestModel.getPrice(), requestModel.getTechnicalInformation(), requestModel.getInstructionManual(),
                timestamp);
        Mockito.when(gateway.existsById(product.getId())).thenReturn(false);
        Mockito.when(factory.create(requestModel.getId(), requestModel.getName(), requestModel.getDescription(), requestModel.getPrice(), requestModel.getTechnicalInformation(), requestModel.getInstructionManual())).thenReturn(product);
        String errorMessage = "Technical information 123 is not valid";
        InvalidTechnicalInformationException invalidTechnicalInformationException = new InvalidTechnicalInformationException(errorMessage);
        Mockito.when(presenter.prepareFailView(invalidTechnicalInformationException)).thenThrow(invalidTechnicalInformationException);
        Exception failViewException = Assertions.assertThrows(InvalidTechnicalInformationException.class, () -> {
            presenter.prepareFailView(invalidTechnicalInformationException);
        });

        // ACT
        TechnicalProductInteractor interactor = new TechnicalProductInteractor(factory, presenter, gateway);
        interactor.create(requestModel);

        // ASSERT
        Assertions.assertTrue(failViewException.getMessage().contains(errorMessage));
        Mockito.verify(gateway, Mockito.times(1)).existsById(product.getId());
        Mockito.verify(factory, Mockito.times(1)).create(requestModel.getId(), requestModel.getName(), requestModel.getDescription(), requestModel.getPrice(), requestModel.getTechnicalInformation(), requestModel.getInstructionManual());
        Mockito.verify(presenter, Mockito.times(1)).prepareFailView(invalidTechnicalInformationException);
    }
}
