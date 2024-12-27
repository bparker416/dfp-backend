package com.damnfinepizzapo.damn_fine_backend.drinks_menu.repository;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.Mocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MocktailRepository extends JpaRepository<Mocktail, Integer> {
    @Query("SELECT m FROM Mocktail m WHERE m.mocktail_active = true")
    List<Mocktail> findAllActive();
}
