package com.damnfinepizzapo.damn_fine_backend.repository;

import com.damnfinepizzapo.damn_fine_backend.entity.Veggie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeggieRepository extends JpaRepository<Veggie, Integer> {
}
