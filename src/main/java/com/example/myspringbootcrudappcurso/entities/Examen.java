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
public class Examen {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nombre")
    protected String nombre;
    
    /**
     * Holds value of property estudio.
     */
    @ManyToOne
    @JoinColumn(name = "asignatura_id", nullable = false)
    private Asignatura asignatura;


    

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
    public Asignatura getAsignatura() {
        return this.asignatura;
    }

    /**
     * Setter for property pet.
     *
     * @param pet New value of property pet.
     */
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }


}
