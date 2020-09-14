package com.example.myspringbootcrudappcurso.services;

import com.example.myspringbootcrudappcurso.entities.Pregunta;

public interface PreguntaService {

    Iterable<Pregunta> listAllPreguntas();
    
    Iterable<Pregunta> listAllPreguntasByEstudio(String estudio);


    Pregunta getPreguntaById(Integer id);

    Pregunta savePregunta(Pregunta pregunta);

    void deletePregunta(Integer id);

}
