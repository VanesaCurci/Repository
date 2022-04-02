
package com.proyectoportfolio.primerportfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String titulo;
    private String lugar;
    private String duracion;
    
    @ManyToMany(mappedBy = "educaciones")
    @JsonIgnoreProperties(value="educaciones")
    private Set<Persona> personas;
    
    public Educacion() {
    
}
    public Educacion(String titulo, String lugar, String duracion){
        this.titulo = titulo;
        this.lugar = lugar;
        this.duracion = duracion;
    }
}
