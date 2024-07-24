package com.aron.sistemaencuestas.controllers;

import com.aron.sistemaencuestas.entities.Encuesta;
import com.aron.sistemaencuestas.services.EncuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/encuestas")
public class EncuestaController {

    @Autowired
    private EncuestaService encuestaService;

    // TODO: Implementar los métodos para las operaciones CRUD de encuestas

    @PostMapping
    public ResponseEntity<Encuesta> crearEncuesta(@RequestBody Encuesta encuesta) throws URISyntaxException {
        Encuesta nuevaEncuesta = encuestaService.crearEncuesta(encuesta.getTitulo());
        return ResponseEntity.created(new URI("/api/encuestas" + nuevaEncuesta.getId())).body(nuevaEncuesta);
    }

    @GetMapping
    public List<Encuesta> obtenerTodasLasEncuestas(){
        return encuestaService.obtenerTodasLasEncuestas();
    }

    @GetMapping("/{encuestaId}")
    public ResponseEntity<Encuesta> obtenerDetallesEncuestas(@PathVariable long encuestaId){
        Optional<Encuesta> optionalEncuesta = encuestaService.ObtenerDetallesEncuesta(encuestaId);
        return optionalEncuesta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{encuestaId}")
    public ResponseEntity<Encuesta> actualizarEncuesta(@PathVariable long encuestaId, @RequestBody Encuesta encuesta){
        Encuesta encuestaActualizada = encuestaService.actualizarEncuesta(encuestaId, encuesta.getTitulo());
        return encuestaActualizada != null ? ResponseEntity.ok(encuestaActualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{encuestaId}")
    public ResponseEntity<Void> eliminarEncuesta(@PathVariable long encuestaId){
        encuestaService.eliminarEncuesta(encuestaId);
        return ResponseEntity.noContent().build();
    }
}
