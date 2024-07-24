package com.aron.sistemaencuestas.repositories;

import com.aron.sistemaencuestas.entities.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreguntaRepository extends JpaRepository <Pregunta, Long> {

    List<Pregunta> findByEncuestaId(Long encuestaId);

}
