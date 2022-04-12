
package com.proyectoportfolio.primerportfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Localidad implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long Id;
    private String nombre;
    
    @OneToMany(mappedBy = "localidad", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("localidad")
    private List<Persona> personas;
    
    @ManyToOne
    @JoinColumn(name = "provincia_id")
    @JsonIgnoreProperties("localidades")
    private Provincia provincia;
            
    
    public Localidad() {
    
}
    public Localidad (String nombre){
        this.nombre = nombre;
    }
}
