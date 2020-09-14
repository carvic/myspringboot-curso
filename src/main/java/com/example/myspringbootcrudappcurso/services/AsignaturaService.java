package com.example.myspringbootcrudappcurso.services;

import com.example.myspringbootcrudappcurso.entities.Asignatura;

public interface AsignaturaService {

    Iterable<Asignatura> listAllAsignaturas();

    Asignatura getAsignaturaById(Integer id);

    Asignatura saveAsignatura(Asignatura asignatura);

    void deleteAsignatura(Integer id);

}
