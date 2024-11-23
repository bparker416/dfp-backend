package com.damnfinepizzapo.damn_fine_backend.repository;

import com.damnfinepizzapo.damn_fine_backend.entity.Appetizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppetizerRepository extends JpaRepository<Appetizer, Integer> {
}
