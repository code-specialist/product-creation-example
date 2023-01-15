package com.specialist.code.integration;


import com.specialist.code.adapter.gateways.mongodb.CommonProductCreationMongoDBGateway;
import com.specialist.code.application.productcreation.boundaries.output.register.ICommonProductRegisterGateway;
import com.specialist.code.domain.CommonProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
public class ProductCreationGatewayIntegrationTest {

    @Container
    public GenericContainer mongodb = new GenericContainer(DockerImageName.parse("mongo:latest"))
            .withExposedPorts(27017);


    @Test
    public void givenValidCommonProduct_whenSave_thenPersist_andAssertThatExistsInDatabase(){
        ICommonProductRegisterGateway registerGateway = new CommonProductCreationMongoDBGateway(mongodb.getHost(), mongodb.getFirstMappedPort());

        CommonProduct product = new CommonProduct("001", "NameAbc", "description", 240.02, 24098170492L);
        registerGateway.save(product);

        Assertions.assertTrue(registerGateway.existsById("001"));
    }

    @Test
    public void givenNothing_whenExistsById_thenReturnFalse(){
        ICommonProductRegisterGateway registerGateway = new CommonProductCreationMongoDBGateway(mongodb.getHost(), mongodb.getFirstMappedPort());

        Assertions.assertFalse(registerGateway.existsById("001"));
    }


}
