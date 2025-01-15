package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Veggie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeggieRepository extends JpaRepository<Veggie, Integer> {
    @Query("SELECT v FROM Veggie v WHERE v.veggie_active = true")
    List<Veggie> findAllActive();
    @Query("SELECT v.veggie_name FROM Veggie v WHERE LOWER(v.veggie_name) LIKE LOWER(CONCAT('%', :veggie_name, '%'))")
    List<String> searchByVeggieName(@Param("veggie_name") String veggie_name);
}
