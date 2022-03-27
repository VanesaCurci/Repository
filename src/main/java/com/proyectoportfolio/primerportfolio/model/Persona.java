
package com.proyectoportfolio.primerportfolio.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


import lombok.Getter;
import lombok.Setter;






@Getter @Setter
@Entity

public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
    private String foto_perfil;
    private String foto_fondo;
    
    
   @JoinColumn(name = "id_contacto")
   @OneToOne(fetch = FetchType.LAZY)
   private Contacto contacto;
   
   @ManyToOne
   @JoinColumn(name = "localidad_id")
   @JsonBackReference
   private Localidad localidad;
  
   @ManyToMany( cascade = {
       CascadeType.PERSIST,
       CascadeType.MERGE
   })
   
   @JoinTable(
           name = "persona_tecnología",
           joinColumns = {@JoinColumn(name = "persona_id")},
           inverseJoinColumns = {@JoinColumn(name = "tecnología_id")}
                 
   )
   @JsonIgnoreProperties(value="personas")
   private Set<Tecnología>tecnologías;
   
   @ManyToMany( cascade = {
       CascadeType.PERSIST,
       CascadeType.MERGE
   })
   
   @JoinTable(
           name = "persona_proyecto",
           joinColumns = {@JoinColumn(name = "persona_id")},
           inverseJoinColumns = {@JoinColumn(name = "proyecto_id")}
                 
   )
   @JsonIgnoreProperties(value="personas")
   private Set<Proyecto>proyectos;
   
   @ManyToMany( cascade = {
       CascadeType.PERSIST,
       CascadeType.MERGE
   })
   
   @JoinTable(
           name = "persona_idioma",
           joinColumns = {@JoinColumn(name = "persona_id")},
           inverseJoinColumns = {@JoinColumn(name = "idioma_id")}
                 
   )
   @JsonIgnoreProperties(value="personas")
   private Set<Idioma>idiomas;
   
   @ManyToMany( cascade = {
       CascadeType.PERSIST,
       CascadeType.MERGE
   })
   
   @JoinTable(
           name = "persona_educación",
           joinColumns = {@JoinColumn(name = "persona_id")},
           inverseJoinColumns = {@JoinColumn(name = "educación_id")}
                 
   )
   @JsonIgnoreProperties(value="personas")
   private Set<Educación>educaciones;
   
    
    public Persona() {
    
}
    public Persona (String nombre,String apellido, int edad, String foto_perfil, String foto_fondo ){
        
      
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.foto_perfil = foto_perfil;
        this.foto_fondo = foto_fondo;          
    }

    
}

