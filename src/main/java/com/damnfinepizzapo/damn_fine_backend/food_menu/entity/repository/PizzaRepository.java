package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    @Query("SELECT p FROM Pizza p WHERE p.pizza_active = true")
    List<Pizza> findAllActive();
    @Query("SELECT p.pizza_name FROM Pizza p WHERE LOWER(p.pizza_name) LIKE LOWER(CONCAT('%', :pizza_name, '%'))")
    List<String> searchByPizzaName(@Param("pizza_name") String pizza_name);
}
