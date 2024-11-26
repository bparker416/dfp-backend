package com.damnfinepizzapo.damn_fine_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Sides")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Side {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer side_id;

    @Column(name = "side_name")
    @NotNull
    private String side_name;

    @Column(name = "side_description")
    @NotNull
    private String side_description;

    @Column(name = "side_price")
    @NotNull
    private Integer side_price;

    @Column(name = "additional_text")
    private String additional_text;

    @Column(name = "side_active")
    private Boolean side_active;

}
