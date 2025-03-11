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
@Table(name = "Appetizer", schema = "dfp_database")
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

    @Column(name = "app_description")
    @NotNull
    private String app_description;

    @Column(name = "app_price")
    @NotNull
    private Integer app_price;

    @Column(name = "additional_text")
    private String additional_text;

    @Column(name = "appetizer_active")
    @NotNull
    private Boolean appetizer_active;

}
