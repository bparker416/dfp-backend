package com.damnfinepizzapo.damn_fine_backend.repository;

import com.damnfinepizzapo.damn_fine_backend.entity.Side;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SideRepository extends JpaRepository<Side, Integer> {
}
