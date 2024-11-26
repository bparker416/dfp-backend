package com.damnfinepizzapo.damn_fine_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cheese")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cheese {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cheese_id;

    @Column(name = "cheese_name")
    @NotNull
    private String cheese_name;

    @Column(name = "cheese_price")
    private Integer cheese_price;

    @Column(name = "cheese_active")
    private Boolean cheese_active;

}
