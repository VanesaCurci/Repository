
package com.proyectoportfolio.primerportfolio.controller;

import com.proyectoportfolio.primerportfolio.model.Educacion;
import com.proyectoportfolio.primerportfolio.service.IEducacionService;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class EducacionController {
    @Autowired
    private IEducacionService interEducacion;
    
    @GetMapping("/educacion")
    public List<Educacion> getEducaciones(){
        return interEducacion.getEducaciones();
    }
    
    @GetMapping("/educacion/{id}")
    public Educacion findEducacion(@PathVariable Long id){
        Educacion edu = interEducacion.findEducacion(id);
        return edu;
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/educacion")
    public String createEducacion (@RequestBody Educacion edu){
        interEducacion.saveEducacion(edu);
        return "Educacion fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/educacion/{id}")
    public String deleteEducacion (@PathVariable Long id){
        interEducacion.deleteEducacion(id);
        return "Educacion fue eliminada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("educacion/{id}")
    public Educacion editEducación (@PathVariable Long id,
                                @RequestParam("titulo") String nuevoTitulo,
                                @RequestParam ("lugar") String nuevoLugar,
                                @RequestParam ("duracion") String nuevoDuracion){
        
        Educacion edu = interEducacion.findEducacion(id);
        edu.setTitulo(nuevoTitulo);
        edu.setLugar(nuevoLugar);
        edu.setDuracion(nuevoDuracion);
        
        
        interEducacion.saveEducacion(edu);
        return edu;
    }
}

