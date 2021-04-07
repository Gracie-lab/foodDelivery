package com.delivery.servbytedelivery.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<Meal> meals;

}
