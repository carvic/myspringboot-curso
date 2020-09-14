package com.example.myspringbootcrudappcurso.services;

import com.example.myspringbootcrudappcurso.entities.Asignatura;
import com.example.myspringbootcrudappcurso.entities.Estudio;

public interface EstudioService {

    Iterable<Estudio> listAllEstudios();

    Estudio getEstudioById(Integer id);

    Estudio saveEstudio(Estudio estudio);

    void deleteEstudio(Integer id);

    //Iterable<Asignatura> listAllAsignaturas();

}
