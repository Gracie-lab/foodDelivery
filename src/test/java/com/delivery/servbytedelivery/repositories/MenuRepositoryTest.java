package com.delivery.servbytedelivery.repositories;

import com.delivery.servbytedelivery.models.Meal;
import com.delivery.servbytedelivery.models.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MenuRepositoryTest {
    @Autowired
    MenuRepository menuRepository;

    @Autowired
    MealRepository mealRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void testThatICanAddMealsToMenu(){
        Menu menu = new Menu();
        menu.setMeals(new ArrayList<>());
        Meal rice = new Meal();
        Meal beans = new Meal();

         menu.getMeals().add(rice);
         mealRepository.save(rice);
         menu.getMeals().add(beans);
         mealRepository.save(beans);
        menuRepository.save(menu);

        assertThat(menu.getMeals().size()).isEqualTo(2);
    }
}