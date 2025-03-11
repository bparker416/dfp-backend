package com.damnfinepizzapo.damn_fine_backend.food_menu.entity;

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
@Table(name = "Cheese", schema = "dfp_database")
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
