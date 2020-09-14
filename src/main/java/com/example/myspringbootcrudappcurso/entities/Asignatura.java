package com.example.myspringbootcrudappcurso.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;


import java.math.BigDecimal;

/**
 * Product entity.
 */
@Entity
public class Asignatura {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nombre")
    protected String nombre;
    
    /**
     * Holds value of property estudio.
     */
    @ManyToOne
    @JoinColumn(name = "estudio_id", nullable = false)
    private Estudio estudio;


    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    /**
     * Getter for property pet.
     *
     * @return Value of property pet.
     */
    public Estudio getEstudio() {
        return this.estudio;
    }

    /**
     * Setter for property pet.
     *
     * @param pet New value of property pet.
     */
    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }


}
