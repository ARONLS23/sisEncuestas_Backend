package com.aron.sistemaencuestas.services;

import com.aron.sistemaencuestas.entities.Respuesta;

import java.util.List;
import java.util.Optional;

public interface RespuestaService {

    Respuesta agregarRespuestaAPregunta(Long preguntaId, String contenido);

    List<Respuesta> obtenerRespuestasByPregunta(Long preguntaId);

    Optional<Respuesta> obtenerDetallesRespuesta(Long respuestaId);

    Respuesta actualizarRespuesta(Long respuestaId, String nuevoContenido);

    void eliminarRespuesta(Long respuestaId);

}
