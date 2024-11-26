package com.damnfinepizzapo.damn_fine_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Sauce")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sauce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sauce_id;

    @Column(name = "sauce_name")
    private String sauce_name;

    @Column(name = "sauce_active")
    private boolean sauce_active;

}
