package com.damnfinepizzapo.damn_fine_backend.drinks_menu.repository;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.Drink;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Appetizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Integer> {
    @Query("SELECT d FROM Drink d WHERE d.drink_active = true")
    List<Drink> findAllActive();
    @Query("SELECT d from Drink d WHERE LOWER(d.drink_name) LIKE LOWER(CONCAT('%', :drink_name, '%'))")
    List<String> searchByDrinkName(@Param("drink_name") String drink_name);
}