package com.delivery.servbytedelivery.repositories;

import com.delivery.servbytedelivery.models.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Integer> {
}
