package com.damnfinepizzapo.damn_fine_backend.drinks_menu.repository;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.HouseCocktail;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Appetizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseCocktailRepository extends JpaRepository<HouseCocktail, Integer> {
    @Query("SELECT h FROM HouseCocktail h WHERE h.cocktail_active = true")
    List<HouseCocktail> findAllActive();
    @Query("SELECT h from HouseCocktail h WHERE LOWER(h.cocktail_name) LIKE LOWER(CONCAT('%', :cocktail_name, '%'))")
    List<HouseCocktail> searchByCocktailName(@Param("cocktail_name") String cocktail_name);
}