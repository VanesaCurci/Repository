
package com.proyectoportfolio.primerportfolio.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educación implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String título;
    private String lugar;
    private String duración;
    
    public Educación() {
    
}
    public Educación(String título, String lugar, String duración){
        this.título = título;
        this.lugar = lugar;
        this.duración = duración;
    }
}
