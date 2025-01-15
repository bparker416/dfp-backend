package com.damnfinepizzapo.damn_fine_backend.drinks_menu.repository;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.Libation;
import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Appetizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibationRepository extends JpaRepository<Libation, Integer> {
    @Query("SELECT l FROM Libation l WHERE l.libation_active = true")
    List<Libation> findAllActive();
    @Query("SELECT l.libation_name from Libation l WHERE LOWER(l.libation_name) LIKE LOWER(CONCAT('%', :libation_name, '%'))")
    List<String> searchByLibationName(@Param("libation_name") String libation_name);
}
