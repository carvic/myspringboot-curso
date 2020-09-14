package com.example.myspringbootcrudappcurso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.myspringbootcrudappcurso.entities.Asignatura;
import com.example.myspringbootcrudappcurso.entities.Estudio;
import com.example.myspringbootcrudappcurso.entities.Examen;


public interface ExamenRepository extends CrudRepository<Examen, Integer> {

	@Query("SELECT a from Examen ex INNER JOIN ex.asignatura a INNER JOIN a.estudio e where e.nombre = :nombre")
	List<Examen> findByEstudio(@Param("nombre") String nombre);

}
