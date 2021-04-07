package com.delivery.servbytedelivery.web;

import com.delivery.servbytedelivery.dto.SelectServiceProvider;
import com.delivery.servbytedelivery.exceptions.ApplicationException;
import com.delivery.servbytedelivery.models.City;
import com.delivery.servbytedelivery.models.Menu;
import com.delivery.servbytedelivery.models.ServiceProvider;
import com.delivery.servbytedelivery.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    DeliveryService deliveryService;

    @PostMapping("/findProviderByCity")
    public ResponseEntity<?> findProviderByCity(String city){
        List<ServiceProvider> serviceProviderList;
        try{
            serviceProviderList = deliveryService.findServiceProviderByCity(city);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body(serviceProviderList);
    }

    @PostMapping("/showMenuOfSelectedProvider")
    public ResponseEntity<?> showMenu(SelectServiceProvider selectServiceProvider){
        Menu menu ;
        try{
            menu = deliveryService.showMenuOfSelectedProvider(selectServiceProvider);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body(menu);
    }
}
