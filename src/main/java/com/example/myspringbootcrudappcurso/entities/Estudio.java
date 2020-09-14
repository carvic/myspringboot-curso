package com.example.myspringbootcrudappcurso.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
/*import javax.validation.constraints.NotEmpty;*/


import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Product entity.
 */
@Entity
public class Estudio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

   
    @Column(name = "nombre")
    protected String nombre;

    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudio", fetch = FetchType.EAGER)
    private Set<Asignatura> asignaturas;

    
    
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
    
    
    
    protected Set<Asignatura> getAsignaturasInternal() {
        if (this.asignaturas == null) {
            this.asignaturas = new HashSet<>();
        }
        return this.asignaturas;
    }

    protected void setAsignaturasInternal(Set<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public List<Asignatura> getAsignaturas() {
        List<Asignatura> sortedAsignaturas = new ArrayList<>(getAsignaturasInternal());
        PropertyComparator.sort(sortedAsignaturas, new MutableSortDefinition("date", false, false));
        return Collections.unmodifiableList(sortedAsignaturas);
    }

    public void addAsignatura(Asignatura asignatura) {
        getAsignaturasInternal().add(asignatura);
        asignatura.setEstudio(this);
    }
   


}
