package com.damnfinepizzapo.damn_fine_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "salad")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Salad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salad_id;

    @Column(name = "salad_name")
    @NotNull
    private String salad_name;

    @Column(name = "salad_description")
    @NotNull
    private String salad_description;

    @Column(name = "small_price")
    @NotNull
    private Integer small_price;

    @Column(name = "large_price")
    private Integer large_price;

    @Column(name = "additional_text")
    private String additional_text;

}
