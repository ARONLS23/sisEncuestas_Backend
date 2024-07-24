package com.aron.sistemaencuestas.services;

import com.aron.sistemaencuestas.entities.Encuesta;

import java.util.List;
import java.util.Optional;

public interface EncuestaService {

    Encuesta crearEncuesta(String titulo);

    List<Encuesta> obtenerTodasLasEncuestas();

    Optional<Encuesta> ObtenerDetallesEncuesta(Long encuestaId);

    Encuesta actualizarEncuesta(Long encuestaId, String nuevoTitulo);

    void eliminarEncuesta(Long encuestaId);

}
