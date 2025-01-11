package com.damnfinepizzapo.damn_fine_backend.food_menu.entity.repository;

import com.damnfinepizzapo.damn_fine_backend.food_menu.entity.Side;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SideRepository extends JpaRepository<Side, Integer> {
    @Query("SELECT s FROM Side s WHERE s.side_active = true")
    List<Side> findAllActive();
    @Query("SELECT s FROM Side s WHERE LOWER(s.side_name) LIKE LOWER(CONCAT('%', :side_name, '%'))")
    List<Side> searchBySideName(@Param("side_name") String side_name);
}
