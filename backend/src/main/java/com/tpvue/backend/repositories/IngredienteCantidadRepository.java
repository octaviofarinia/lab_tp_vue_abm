package com.tpvue.backend.repositories;

import com.tpvue.backend.entities.IngredienteCantidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteCantidadRepository extends JpaRepository<IngredienteCantidad, Long> {
}
