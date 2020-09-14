package com.example.myspringbootcrudappcurso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.myspringbootcrudappcurso.entities.Asignatura;
import com.example.myspringbootcrudappcurso.entities.Estudio;


public interface AsignaturaRepository extends CrudRepository<Asignatura, Integer> {

	@Query("SELECT a from Asignatura a INNER JOIN a.estudio e where e.nombre = :nombre")
	List<Asignatura> findByEstudio(@Param("nombre") String nombre);
	
}
