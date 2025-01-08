package com.damnfinepizzapo.damn_fine_backend.food_menu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Dessert")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dessert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dessert_id;

    @Column(name = "dessert_name")
    @NotNull
    private String dessert_name;

    @Column(name = "dessert_description")
    @NotNull
    private String dessert_description;

    @Column(name = "dessert_price")
    @NotNull
    private Integer dessert_price;

    @Column(name = "additional_text")
    private String additional_text;

    @Column(name = "dessert_active")
    @NotNull
    private Boolean dessert_active;

}
