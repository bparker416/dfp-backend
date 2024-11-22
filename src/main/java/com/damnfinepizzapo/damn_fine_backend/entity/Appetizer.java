package com.damnfinepizzapo.damn_fine_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Appetizer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Appetizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer app_id;

    @Column(name = "app_name")
    @NotNull
    private String app_name;

    @Column(name = "app_price")
    @NotNull
    private Integer app_price;

    @Column(name = "additional_text")
    private String additional_text;
}
