package com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "seasonal_libations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Libation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seasonal_id")
    private Integer libation_id;

    @Column(name = "seasonal_name")
    @NotNull
    private String libation_name;

    @Column(name = "seasonal_price")
    @NotNull
    private Integer libation_price;

    @Column(name = "seasonal_description")
    @NotNull
    private String libation_description;

    @Column(name = "seasonal_active")
    private boolean libation_active;
}
