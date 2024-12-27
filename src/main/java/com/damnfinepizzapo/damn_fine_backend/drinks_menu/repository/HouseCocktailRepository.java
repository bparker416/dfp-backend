package com.damnfinepizzapo.damn_fine_backend.drinks_menu.repository;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.HouseCocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseCocktailRepository extends JpaRepository<HouseCocktail, Integer> {
    @Query("SELECT h FROM HouseCocktail h WHERE h.cocktail_active = true")
    List<HouseCocktail> findAllActive();
}