package com.delivery.servbytedelivery.services;

import com.delivery.servbytedelivery.exceptions.ApplicationException;
import com.delivery.servbytedelivery.models.City;
import com.delivery.servbytedelivery.models.Meal;
import com.delivery.servbytedelivery.models.Menu;
import com.delivery.servbytedelivery.models.ServiceProvider;
import com.delivery.servbytedelivery.repositories.ServiceProviderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.context.ServerPortInfoApplicationContextInitializer;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeliveryServiceImplTest {

    @Autowired
    DeliveryService deliveryService;

    @Autowired
    ServiceProviderRepository serviceProviderRepository;



    @BeforeEach
    void setUp() {
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setCity(City.ABIA);
        ServiceProvider newProvider = new ServiceProvider();
        newProvider.setCity(City.ABIA);
        serviceProviderRepository.save(serviceProvider);
        serviceProviderRepository.save(newProvider);


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test_find_service_provider_by_city() throws ApplicationException {
        List<ServiceProvider> serviceProviders = deliveryService.findServiceProviderByCity("Abia");
        assertThat(serviceProviders.size()).isEqualTo(2);
    }

    @Test
    void test_I_Can_View_Menu_Of_Selected_Restaurant(){

    }
}