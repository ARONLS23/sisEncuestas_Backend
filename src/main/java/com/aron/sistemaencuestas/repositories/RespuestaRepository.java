package com.aron.sistemaencuestas.repositories;

import com.aron.sistemaencuestas.entities.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    List<Respuesta> findByPreguntaId(Long preguntaId);

}
