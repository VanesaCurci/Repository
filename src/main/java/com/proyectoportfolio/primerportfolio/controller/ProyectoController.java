
package com.proyectoportfolio.primerportfolio.controller;

import com.proyectoportfolio.primerportfolio.model.Proyecto;
import com.proyectoportfolio.primerportfolio.service.IProyectoService;



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

@CrossOrigin(origins = "https://portafolio-web-70535.web.app/")
public class ProyectoController {
    @Autowired
    private IProyectoService interProyecto;
    
    @GetMapping("/proyectos")
    public List<Proyecto> getProyectos(){
        return interProyecto.getProyectos();
    }
    
    @GetMapping("/proyectos/{id}")
   public Proyecto findProyecto(@PathVariable Long id){
   Proyecto proye = interProyecto.findProyecto(id);
   return proye;}
    
    @PostMapping ("/proyectos")
    public String createProyecto (@RequestBody Proyecto proye){
        interProyecto.saveProyecto(proye);
        return "El proyecto fue creado correctamente";
    }
    
    @DeleteMapping ("/proyectos/{id}")
    public String deleteProyecto (@PathVariable Long id){
        interProyecto.deleteProyecto(id);
        return "El proyecto fue eliminado correctamente";
    }
    
    @PutMapping ("proyectos/{id}")
    public Proyecto editProyecto (@PathVariable Long id,
                                @RequestParam("titulo") String nuevoTítulo,
                                @RequestParam ("descripcion") String nuevoDescripción){
        
        Proyecto proye = interProyecto.findProyecto(id);
        proye.setTitulo(nuevoTítulo);
        proye.setDescripcion(nuevoDescripción);
        
        
        interProyecto.saveProyecto(proye);
        return proye;
    }
}

