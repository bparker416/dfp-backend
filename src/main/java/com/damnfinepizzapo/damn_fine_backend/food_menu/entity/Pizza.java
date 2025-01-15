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
@Table(name = "Pizza")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pizza_id;

    @Column(name = "pizza_name")
    @NotNull
    private String pizza_name;

    @Column(name = "pizza_description")
    @NotNull
    private String pizza_description;

    @Column(name = "small_price")
    @NotNull
    private Integer small_price;

    @Column(name = "large_price")
    @NotNull
    private Integer large_price;

    @Column(name = "additional_text")
    private String additional_text;

    @Column(name = "pizza_active")
    private boolean pizza_active;

}
