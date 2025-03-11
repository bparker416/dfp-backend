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
@Table(name = "drinks", schema = "dfp_database")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer drink_id;

    @Column(name = "drink_name")
    @NotNull
    private String drink_name;

    @Column(name = "drink_price")
    @NotNull
    private Integer drink_price;

    @Column(name = "drink_description")
    @NotNull
    private String drink_description;

    @Column(name = "drink_active")
    private boolean drink_active;
}
