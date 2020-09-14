package com.example.myspringbootcrudappcurso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.myspringbootcrudappcurso.entities.Asignatura;
import com.example.myspringbootcrudappcurso.entities.Estudio;
import com.example.myspringbootcrudappcurso.entities.Examen;
import com.example.myspringbootcrudappcurso.entities.Pregunta;


public interface PreguntaRepository extends CrudRepository<Pregunta, Integer> {

	@Query("SELECT p from Pregunta p INNER JOIN p.examen ex INNER JOIN ex.asignatura a INNER JOIN a.estudio e where e.nombre = :nombre")
	List<Pregunta> findByEstudio(@Param("nombre") String nombre);

}
