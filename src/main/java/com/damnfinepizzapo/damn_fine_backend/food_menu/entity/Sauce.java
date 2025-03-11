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
@Table(name = "Sauce", schema = "dfp_database")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sauce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sauce_id;

    @Column(name = "sauce_name")
    @NotNull
    private String sauce_name;

    @Column(name = "sauce_active")
    private boolean sauce_active;

}
