package com.example.myspringbootcrudappcurso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myspringbootcrudappcurso.entities.Asignatura;
import com.example.myspringbootcrudappcurso.repositories.AsignaturaRepository;

/**
 * Asignatura service implement.
 */
@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    private AsignaturaRepository asignaturaRepository;

    @Autowired
    public void setAsignaturaRepository(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }
    
   
    @Override
    public Iterable<Asignatura> listAllAsignaturas() {
        return asignaturaRepository.findAll();
    }
   
    /*
    @Override
    public Iterable<Asignatura> listAllAsignaturas() {
        return asignaturaRepository.findByEstudio("Ingeniería industrial");
    }
	*/
    @Override
    public Asignatura getAsignaturaById(Integer id) {
        return asignaturaRepository.findOne(id);
    }

    @Override
    public Asignatura saveAsignatura(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public void deleteAsignatura(Integer id) {
        asignaturaRepository.delete(id);
    }

}
