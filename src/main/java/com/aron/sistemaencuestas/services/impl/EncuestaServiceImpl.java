package com.aron.sistemaencuestas.services.impl;

import com.aron.sistemaencuestas.entities.Encuesta;
import com.aron.sistemaencuestas.repositories.EncuestaRepository;
import com.aron.sistemaencuestas.services.EncuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EncuestaServiceImpl implements EncuestaService {

    @Autowired
    private EncuestaRepository encuestaRepository;

    @Override
    public Encuesta crearEncuesta(String titulo) {
        Encuesta encuesta = new Encuesta();
        encuesta.setTitulo(titulo);
        return encuestaRepository.save(encuesta);
    }

    @Override
    public List<Encuesta> obtenerTodasLasEncuestas() {
        return encuestaRepository.findAll();
    }

    @Override
    public Optional<Encuesta> ObtenerDetallesEncuesta(Long encuestaId) {
        return encuestaRepository.findById(encuestaId);
    }

    @Override
    public Encuesta actualizarEncuesta(Long encuestaId, String nuevoTitulo) {
        return encuestaRepository.findById(encuestaId).map(encuesta -> {
            encuesta.setTitulo(nuevoTitulo);
            return encuestaRepository.save(encuesta);
        }).orElse(null);
    }

    @Override
    public void eliminarEncuesta(Long encuestaId) {
        encuestaRepository.deleteById(encuestaId);
    }
}
