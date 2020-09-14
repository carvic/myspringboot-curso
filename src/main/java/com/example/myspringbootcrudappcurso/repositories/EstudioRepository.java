package com.example.myspringbootcrudappcurso.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.myspringbootcrudappcurso.entities.Asignatura;
import com.example.myspringbootcrudappcurso.entities.Estudio;

public interface EstudioRepository extends CrudRepository<Estudio, Integer> {
	
    
	
}
