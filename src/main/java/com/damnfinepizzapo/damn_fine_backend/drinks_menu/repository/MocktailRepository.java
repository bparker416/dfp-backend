package com.damnfinepizzapo.damn_fine_backend.drinks_menu.repository;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.Mocktail;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Appetizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MocktailRepository extends JpaRepository<Mocktail, Integer> {
    @Query("SELECT m FROM Mocktail m WHERE m.mocktail_active = true")
    List<Mocktail> findAllActive();
    @Query("SELECT m from Mocktail m WHERE LOWER(m.mocktail_name) LIKE LOWER(CONCAT('%', :mocktail_name, '%'))")
    List<String> searchByMocktailName(@Param("mocktail_name") String mocktail_name);
}
