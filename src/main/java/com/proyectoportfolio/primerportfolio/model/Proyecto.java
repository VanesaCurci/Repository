
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
public class Proyecto implements Serializable {
  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE)
  private Long id;
  private String titulo;
  private String descripcion;
  
  @ManyToMany(mappedBy = "proyectos")
  @JsonIgnoreProperties("proyectos")
  private Set<Persona> personas;
  
  public Proyecto() {
    
}
  public Proyecto(String titulo, String descripcion){
      this.titulo = titulo;
      this.descripcion = descripcion;
  }
  
}