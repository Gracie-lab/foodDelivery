package com.delivery.servbytedelivery.services;

import com.delivery.servbytedelivery.dto.ChooseAMeal;
import com.delivery.servbytedelivery.dto.SelectServiceProvider;
import com.delivery.servbytedelivery.exceptions.ApplicationException;
import com.delivery.servbytedelivery.models.City;
import com.delivery.servbytedelivery.models.Meal;
import com.delivery.servbytedelivery.models.Menu;
import com.delivery.servbytedelivery.models.ServiceProvider;

import java.util.List;

public interface DeliveryService {

    List<ServiceProvider> findServiceProviderByCity(String city) throws ApplicationException;

    Menu showMenuOfSelectedProvider(SelectServiceProvider selectServiceProvider);

    Meal showChosenMealDetails(SelectServiceProvider selectServiceProvider, ChooseAMeal chooseAMeal) throws ApplicationException;
}
