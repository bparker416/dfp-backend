package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Appetizer;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Cheese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheeseRepository extends JpaRepository<Cheese, Integer> {
    @Query("SELECT c FROM Cheese c WHERE c.cheese_price IS NULL AND c.cheese_active = true")
    List<Cheese> findByPriceIsRegular();
    @Query("SELECT c FROM Cheese c WHERE c.cheese_price = 1 AND c.cheese_active = true")
    List<Cheese> findByPriceIsOne();
    @Query("SELECT c FROM Cheese c WHERE c.cheese_price = 2 AND c.cheese_active = true")
    List<Cheese> findByPriceIsTwo();
    @Query("SELECT c FROM Cheese c WHERE c.cheese_active = true")
    List<Cheese> findAllActive();
    @Query("SELECT c from Cheese c WHERE LOWER(c.cheese_name) LIKE LOWER(CONCAT('%', :cheese_name, '%'))")
    List<Cheese> searchByCheeseName(@Param("cheese_name") String cheese_name);
}
