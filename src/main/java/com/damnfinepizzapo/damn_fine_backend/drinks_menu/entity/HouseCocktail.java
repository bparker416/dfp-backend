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
@Table(name = "house_cocktails", schema = "dfp_database")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HouseCocktail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cocktail_id;

    @Column(name = "cocktail_name")
    @NotNull
    private String cocktail_name;

    @Column(name = "cocktail_price")
    @NotNull
    private Integer cocktail_price;

    @Column(name = "cocktail_description")
    @NotNull
    private String cocktail_description;

    @Column(name = "cocktail_active")
    private boolean cocktail_active;
}
