package com.damnfinepizzapo.damn_fine_backend.food_menu.entity;

import com.damnfinepizzapo.damn_fine_backend.logging.AuditEntityListener;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@EntityListeners(AuditEntityListener.class)
@Table(name = "veggie", schema = "dfp_database")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Veggie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer veggie_id;

    @Column(name = "veggie_name")
    @NotNull
    private String veggie_name;

    @Column(name = "veggie_description")
    private String veggie_description;

    @Column(name = "veggie_active")
    private boolean veggie_active;

}
