package com.damnfinepizzapo.damn_fine_backend.drinks_menu.repository;

import com.damnfinepizzapo.damn_fine_backend.drinks_menu.entity.Libation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibationRepository extends JpaRepository<Libation, Integer> {
    @Query("SELECT l FROM Libation l WHERE l.libation_active = true")
    List<Libation> findAllActive();
}
