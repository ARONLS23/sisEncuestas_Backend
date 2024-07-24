package com.aron.sistemaencuestas.services;

import com.aron.sistemaencuestas.entities.Pregunta;

import java.util.List;
import java.util.Optional;

public interface PreguntaService {

    Pregunta agregarPreguntaAEncuesta(Long encuestaId, String contenido);

    List<Pregunta> obtenerPreguntasByEncuestas(Long encuestasId);

    Optional<Pregunta> obtenerDetallesPregunta(Long preguntaId);

    Pregunta actualizarPregunta (Long preguntaId, String nuevoContenido, Long encuestaId);

    void eliminarPregunta (Long preguntaId);

}
