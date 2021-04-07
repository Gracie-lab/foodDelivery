package com.delivery.servbytedelivery.repositories;

import com.delivery.servbytedelivery.models.City;
import com.delivery.servbytedelivery.models.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Integer> {
    List<ServiceProvider> findAllByCity(City city);
}
