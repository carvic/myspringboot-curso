package com.example.myspringbootcrudappcurso.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.myspringbootcrudappcurso.entities.Asignatura;
import com.example.myspringbootcrudappcurso.entities.Estudio;


public interface AsignaturaRepositoryCrud extends CrudRepository<Asignatura, Integer> {

}
