package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Dessert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DessertRepository extends JpaRepository<Dessert, Integer> {
    @Query("SELECT d FROM Dessert d WHERE d.dessert_active = true")
    List<Dessert> findAllActive();
    @Query("SELECT d.dessert_name from Dessert d WHERE LOWER(d.dessert_name) LIKE LOWER(CONCAT('%', :dessert_name, '%'))")
    List<String> searchByDessertName(@Param("dessert_name") String dessert_name);
}
