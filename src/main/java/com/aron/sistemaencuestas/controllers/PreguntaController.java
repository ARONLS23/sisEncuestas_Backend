package com.aron.sistemaencuestas.controllers;

import com.aron.sistemaencuestas.entities.Pregunta;
import com.aron.sistemaencuestas.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    // TODO: Implementar los métodos para las operaciones CRUD de preguntas

    @RequestMapping("/agregar/{encuestaId}")
    public ResponseEntity<Pregunta> agregarPreguntaAEncuesta(@PathVariable Long encuestaId, @RequestBody Pregunta pregunta) throws URISyntaxException {
        Pregunta nuevaPregunta = preguntaService.agregarPreguntaAEncuesta(encuestaId, pregunta.getContenido());
        return ResponseEntity.created(new URI("/api/preguntas/agregar/" + nuevaPregunta.getId())).body(nuevaPregunta);
    }

    @GetMapping("/por-encuesta/{encuestaId}")
    public List<Pregunta> obtenerPreguntasPorEncuesta(@PathVariable long encuestaId){
        return preguntaService.obtenerPreguntasByEncuestas(encuestaId);
    }

    @GetMapping("/{preguntaId}")
    public ResponseEntity<Pregunta> obtenerDetallesPregunta(@PathVariable long preguntaId){
        return  preguntaService.obtenerDetallesPregunta(preguntaId)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping("/{preguntaId}/encuesta/{encuestaId}")
    public ResponseEntity<Pregunta> actualizarPregunta(@PathVariable long preguntaId, @RequestBody Pregunta pregunta, @PathVariable long encuestaId) {
        Pregunta preguntaActualizada =  preguntaService.actualizarPregunta(preguntaId, pregunta.getContenido(), encuestaId);
        return  preguntaActualizada != null ? ResponseEntity.ok(preguntaActualizada) : ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{preguntaId}")
    public ResponseEntity<Void> eliminarPregunta(@PathVariable long preguntaId) {
        preguntaService.eliminarPregunta(preguntaId);
        return ResponseEntity.noContent().build();
    }
}
