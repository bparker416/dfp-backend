package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Appetizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppetizerRepository extends JpaRepository<Appetizer, Integer> {
    @Query("SELECT a FROM Appetizer a WHERE a.appetizer_active = true")
    List<Appetizer> findAllActive();
    @Query("SELECT a.app_name from Appetizer a WHERE LOWER(a.app_name) LIKE LOWER(CONCAT('%', :app_name, '%'))")
    List<String> searchByAppName(@Param("app_name") String app_name);
}
