package com.example.myspringbootcrudappcurso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myspringbootcrudappcurso.entities.Pregunta;
import com.example.myspringbootcrudappcurso.repositories.PreguntaRepository;

/**
 * Pregunta service implement.
 */
@Service
public class PreguntaServiceImpl implements PreguntaService {

    private PreguntaRepository preguntaRepository;

    @Autowired
    public void setPreguntaRepository(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }
    
   
    @Override
    public Iterable<Pregunta> listAllPreguntas() {
        return preguntaRepository.findAll();
    }
    
 
    
    @Override
    public Iterable<Pregunta> listAllPreguntasByEstudio(String estudio) {
        return preguntaRepository.findByEstudio(estudio);
    }
    
	
    @Override
    public Pregunta getPreguntaById(Integer id) {
        return preguntaRepository.findOne(id);
    }

    @Override
    public Pregunta savePregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @Override
    public void deletePregunta(Integer id) {
        preguntaRepository.delete(id);
    }

}
