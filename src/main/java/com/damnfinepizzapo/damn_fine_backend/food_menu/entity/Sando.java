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
@Table(name = "Sando")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sando {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sando_id;

    @Column(name = "sando_name")
    @NotNull
    private String sando_name;

    @Column(name = "sando_description")
    @NotNull
    private String sando_description;

    @Column(name = "sando_price")
    @NotNull
    private Integer sando_price;

    @Column(name = "additional_text")
    private String additional_text;

    @Column(name = "sando_active")
    private boolean sando_active;

}
