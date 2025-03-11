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
@Table(name = "seasonal_libations", schema = "dfp_database")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Libation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seasonal_id")
    private Integer libation_id;

    @Column(name = "seasonal_name")
    @NotNull
    private String libation_name;

    @Column(name = "seasonal_price")
    @NotNull
    private Integer libation_price;

    @Column(name = "seasonal_description")
    @NotNull
    private String libation_description;

    @Column(name = "seasonal_active")
    private boolean libation_active;
}
