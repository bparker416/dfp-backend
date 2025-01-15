package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Sauce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SauceRepository extends JpaRepository<Sauce, Integer> {
    @Query("SELECT s FROM Sauce s WHERE s.sauce_active = true")
    List<Sauce> findAllActive();
    @Query("SELECT s.sauce_name FROM Sauce s WHERE LOWER(s.sauce_name) LIKE LOWER(CONCAT('%', :sauce_name, '%'))")
    List<String> searchBySauceName(@Param("sauce_name") String sauce_name);
}
