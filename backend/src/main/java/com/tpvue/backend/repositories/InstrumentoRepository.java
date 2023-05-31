package com.tpvue.backend.repositories;

import com.tpvue.backend.entities.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentoRepository extends JpaRepository<Instrumento, Long>  {
}
