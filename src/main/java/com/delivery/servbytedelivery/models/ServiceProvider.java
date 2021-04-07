package com.delivery.servbytedelivery.models;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Data
@Entity
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameOfRestaurant;
    private String emailAddress;
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Menu menu;

    @Enumerated(EnumType.ORDINAL)
    private City city;

}
