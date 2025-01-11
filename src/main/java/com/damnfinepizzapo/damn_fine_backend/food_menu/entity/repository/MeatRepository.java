package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Meat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeatRepository extends JpaRepository<Meat, Integer> {
    @Query("SELECT m FROM Meat m WHERE m.meat_price = 3 AND m.meat_active = true")
    List<Meat> findByPriceIsThree();
    @Query("SELECT m FROM Meat m WHERE m.meat_price = 4 AND m.meat_active = true")
    List<Meat> findByPriceIsFour();
    @Query("SELECT m FROM Meat m WHERE m.meat_active = true")
    List<Meat> findAllActive();
    @Query("SELECT m from Meat m WHERE LOWER(m.meat_name) LIKE LOWER(CONCAT('%', :meat_name, '%'))")
    List<Meat> searchByMeatName(@Param("meat_name") String meat_name);
}
