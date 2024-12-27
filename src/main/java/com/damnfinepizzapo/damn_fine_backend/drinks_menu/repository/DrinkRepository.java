package com.damnfinepizzapo.damn_fine_backend.drinks_menu.repository;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Integer> {
    @Query("SELECT d FROM Drink d WHERE d.drink_active = true")
    List<Drink> findAllActive();
}