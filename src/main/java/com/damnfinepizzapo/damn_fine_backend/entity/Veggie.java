package com.damnfinepizzapo.damn_fine_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public class Veggie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer veggie_id;

    @Column(name = "veggie_name")
    @NotNull
    private String veggie_name;

    @Column(name = "veggie_description")
    private String veggie_description;
}
