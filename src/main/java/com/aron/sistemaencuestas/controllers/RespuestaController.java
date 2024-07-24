package com.aron.sistemaencuestas.controllers;

import com.aron.sistemaencuestas.entities.Respuesta;
import com.aron.sistemaencuestas.services.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    // TODO: Implementar los métodos para las operaciones CRUD de respuestas

    @PostMapping("/agregar/{preguntaId}")
    public ResponseEntity<Respuesta> agregarRespuestaAPregunta(@PathVariable long preguntaId, @RequestBody Respuesta respuesta) throws URISyntaxException {
        Respuesta nuevaRespuesta = respuestaService.agregarRespuestaAPregunta(preguntaId, respuesta.getContenido());
        return ResponseEntity.created(new URI("/api/respuestas/agregar/" + nuevaRespuesta.getId())).body(nuevaRespuesta);
    }

    @GetMapping("/por-pregunta/{preguntaId}")
    public List<Respuesta> obtenerRespuestasPorPregunta(@PathVariable long preguntaId){
        return respuestaService.obtenerRespuestasByPregunta(preguntaId);
    }

    @GetMapping("/{respuestaId}")
    public ResponseEntity<Respuesta> obtenerDetallesRespuesta(@PathVariable long respuestaId){
        Optional<Respuesta> optionalRespuesta = respuestaService.obtenerDetallesRespuesta(respuestaId);
        return optionalRespuesta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{respuestaId}")
    public ResponseEntity<Respuesta> actualizarRespuesta(@PathVariable long respuestaId, @RequestBody Respuesta respuesta){
        Respuesta respuestaActualizada = respuestaService.actualizarRespuesta(respuestaId, respuesta.getContenido());
        return respuestaActualizada != null ? ResponseEntity.ok(respuestaActualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{respuestaId}")
    public ResponseEntity<Void> eliminarRespuesta(@PathVariable long respuestaId){
        respuestaService.eliminarRespuesta(respuestaId);
        return ResponseEntity.noContent().build();
    }
}
