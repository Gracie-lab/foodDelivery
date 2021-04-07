package com.delivery.servbytedelivery.services;

import com.delivery.servbytedelivery.dto.ChooseAMeal;
import com.delivery.servbytedelivery.dto.SelectServiceProvider;
import com.delivery.servbytedelivery.exceptions.ApplicationException;
import com.delivery.servbytedelivery.models.City;
import com.delivery.servbytedelivery.models.Meal;
import com.delivery.servbytedelivery.models.Menu;
import com.delivery.servbytedelivery.models.ServiceProvider;
import com.delivery.servbytedelivery.repositories.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    ServiceProviderRepository serviceProviderRepository;
    List<ServiceProvider> serviceProviderListByCity;

    @Override
    public List<ServiceProvider> findServiceProviderByCity(String city) throws ApplicationException {
        this.serviceProviderListByCity = serviceProviderRepository.findAllByCity(City.valueOf(city.toUpperCase()));
        if(serviceProviderListByCity == null){
            throw new ApplicationException("We apologize, there are no providers from " +city);
        }
        return serviceProviderListByCity;
    }

    @Override
    public Menu showMenuOfSelectedProvider(SelectServiceProvider selectServiceProvider) {
        Menu menuOfSelectedProvider = selectServiceProvider.getServiceProvider().getMenu();
        return menuOfSelectedProvider;
    }

    @Override
    public Meal showChosenMealDetails(SelectServiceProvider selectServiceProvider, ChooseAMeal chooseAMeal) throws ApplicationException {
        List<Meal> mealsInMenu = showMenuOfSelectedProvider(selectServiceProvider).getMeals();
        Meal chosenMeal = new Meal();
        for(Meal meal : mealsInMenu){
            if(!meal.equals(chooseAMeal.getMeal())){
                throw new ApplicationException("This mean is not on the menu");
            }else{
                chosenMeal = meal;
            }
        }
        return chosenMeal;
    }
}
