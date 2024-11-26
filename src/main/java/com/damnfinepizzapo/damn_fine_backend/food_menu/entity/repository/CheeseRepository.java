package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Cheese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheeseRepository extends JpaRepository<Cheese, Integer> {
    @Query("SELECT c FROM Cheese c WHERE c.cheese_price IS NULL")
    List<Cheese> findByPriceIsRegular();
    @Query("SELECT c FROM Cheese c WHERE c.cheese_price = 1")
    List<Cheese> findByPriceIsOne();
    @Query("SELECT c FROM Cheese c WHERE c.cheese_price = 2")
    List<Cheese> findByPriceIsTwo();
}
