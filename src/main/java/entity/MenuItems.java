package entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MenuItems")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; // Primary Key

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private int price;

    @Null
    private int large_price;

    @NotNull
    private int category_id; // Foreign Key


}
