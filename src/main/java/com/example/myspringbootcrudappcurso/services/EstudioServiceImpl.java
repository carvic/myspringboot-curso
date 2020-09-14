package com.example.myspringbootcrudappcurso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myspringbootcrudappcurso.entities.Asignatura;
import com.example.myspringbootcrudappcurso.entities.Estudio;
import com.example.myspringbootcrudappcurso.repositories.EstudioRepository;

/**
 * Estudio service implement.
 */
@Service
public class EstudioServiceImpl implements EstudioService {

    private EstudioRepository estudioRepository;

    @Autowired
    public void setEstudioRepository(EstudioRepository estudioRepository) {
        this.estudioRepository = estudioRepository;
    }

    @Override
    public Iterable<Estudio> listAllEstudios() {
        return estudioRepository.findAll();
    }

    @Override
    public Estudio getEstudioById(Integer id) {
        return estudioRepository.findOne(id);
    }

    @Override
    public Estudio saveEstudio(Estudio estudio) {
        return estudioRepository.save(estudio);
    }

    @Override
    public void deleteEstudio(Integer id) {
        estudioRepository.delete(id);
    }



    

}
