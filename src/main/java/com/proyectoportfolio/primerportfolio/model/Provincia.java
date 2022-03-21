
package com.proyectoportfolio.primerportfolio.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Provincia implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    
    @OneToMany(mappedBy = "provincia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Localidad> localidades;
    
    public Provincia() {
    
}
    public Provincia(String nombre){
        this.nombre = nombre;
    }
}
