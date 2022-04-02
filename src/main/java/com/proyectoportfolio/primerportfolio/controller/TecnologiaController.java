
package com.proyectoportfolio.primerportfolio.controller;

import com.proyectoportfolio.primerportfolio.model.Tecnologia;
import com.proyectoportfolio.primerportfolio.service.ITecnologiaServicio;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

@CrossOrigin(origins = "http://localhost:4200")
public class TecnologiaController {
    @Autowired
    private ITecnologiaServicio interTecnologia;
    
    @GetMapping("/tecnologias")
    public List<Tecnologia> getTecnologias(){
        return interTecnologia.getTecnologias();
    }
    
   @GetMapping("/tecnologias/{id}")
   public Tecnologia findTecnologia(@PathVariable Long id){
   Tecnologia tecno = interTecnologia.findTecnologia(id);
   return tecno;}
   
    @PostMapping ("/tecnologias")
    public String createTecnologia (@RequestBody Tecnologia tecno){
        interTecnologia.saveTecnologia(tecno);
        return "La tecnología fue creada correctamente";
    }
    
    @DeleteMapping ("/tecnologias/borrar/{id}")
    public String deleteTecnologia (@PathVariable Long id){
        interTecnologia.deleteTecnologia(id);
        return "La tecnologia fue eliminada correctamente";
    }
    
    @PutMapping ("/tecnologias/{id}")
    public Tecnologia editTecnologia (@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam ("imagen") String nuevoImagen){
        
        Tecnologia tecno = interTecnologia.findTecnologia(id);
        tecno.setNombre(nuevoNombre);
        tecno.setImagen(nuevoImagen);
        
        
        interTecnologia.saveTecnologia(tecno);
        return tecno;
    }
}
