
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
public class Idioma implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private Long nivel;
    
   @ManyToMany(mappedBy = "idiomas")
   @JsonIgnoreProperties("idiomas")
   private Set<Persona> personas;
    
    public Idioma() {
    
}
    public Idioma (String nombre, Long nivel){
        this.nombre = nombre;
        this.nivel = nivel;   
    }
}
