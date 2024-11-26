package com.damnfinepizzapo.damn_fine_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Meat")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Meat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer meat_id;

    @Column(name = "meat_name")
    @NotNull
    private String meat_name;

    @Column(name = "meat_description")
    private String meat_description;

    @Column(name = "meat_price")
    @NotNull
    private Integer meat_price;

    @Column(name = "meat_active")
    private boolean meat_active;
}
