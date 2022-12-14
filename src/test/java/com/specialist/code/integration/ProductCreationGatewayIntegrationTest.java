package com.specialist.code.integration;


import com.specialist.code.adapter.gateways.CommonProductCreationMongoDBGateway;
import com.specialist.code.application.boundaries.output.ICommonProductRegisterGateway;
import com.specialist.code.domain.CommonProduct;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.wait.strategy.WaitAllStrategy;

import java.io.File;

public class ProductCreationGatewayIntegrationTest {

    @ClassRule
    public static DockerComposeContainer<?> compose =
            new DockerComposeContainer<>(
                    new File("src/test/resources/test-compose.yml"))
                    .withExposedService("mongo", 27017).waitingFor("mongo", new WaitAllStrategy());

    @Test
    public void givenValidCommonProduct_whenSave_thenPersist_andAssertThatExistsInDatabase(){
        ICommonProductRegisterGateway registerGateway = new CommonProductCreationMongoDBGateway("localhost", 27017);

        CommonProduct product = new CommonProduct("001", "NameAbc", "description", 240.02, 24098170492L);
        registerGateway.save(product);

        Assert.assertTrue(registerGateway.existsById("001"));
    }

    @Test
    public void givenNothing_whenExistsById_thenReturnFalse(){
        ICommonProductRegisterGateway registerGateway = new CommonProductCreationMongoDBGateway("localhost", 27017);

        Assert.assertFalse(registerGateway.existsById("001"));
    }


}
