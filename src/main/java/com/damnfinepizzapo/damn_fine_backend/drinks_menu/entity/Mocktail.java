package com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity;

import com.damnfinepizzapo.damn_fine_backend.logging.AuditEntityListener;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditEntityListener.class)
@Table(name = "mocktails")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mocktail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mocktail_id;

    @Column(name = "mocktail_name")
    @NotNull
    private String mocktail_name;

    @Column(name = "mocktail_price")
    @NotNull
    private Integer mocktail_price;

    @Column(name = "mocktail_description")
    @NotNull
    private String mocktail_description;

    @Column(name = "mocktail_active")
    @NotNull
    private boolean mocktail_active;
}
