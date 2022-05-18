
package com.proyectoportfolio.primerportfolio.controller;

import com.proyectoportfolio.primerportfolio.model.Provincia;
import com.proyectoportfolio.primerportfolio.service.IProvinciaService;



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

@CrossOrigin(origins = "https://portafolio-web-70535.web.app/")
public class ProvinciaController {
    @Autowired
    private IProvinciaService interProvincia;
    
    @GetMapping("/provincias")
    public List<Provincia> getProvincias(){
        return interProvincia.getProvincias();
    }
    
    @GetMapping("/provincias/{id}")
   public Provincia findProvincia(@PathVariable Long id){
   Provincia provi = interProvincia.findProvincia(id);
   return provi;}
    
   @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/provincias")
    public String createProvincia (@RequestBody Provincia provi){
        interProvincia.saveProvincia(provi);
        return "La provincia fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/provincias/borrar/{id}")
    public String deleteProvincia (@PathVariable Long id){
        interProvincia.deleteProvincia(id);
        return "La provinica fue eliminada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("provincias/editar/{id}")
    public Provincia editProvincia (@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre){
        
        Provincia provi = interProvincia.findProvincia(id);
        provi.setNombre(nuevoNombre);
        
        
     
        interProvincia.saveProvincia(provi);
        return provi;
    }
}


