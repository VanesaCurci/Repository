
package com.proyectoportfolio.primerportfolio.controller;

import com.proyectoportfolio.primerportfolio.model.Idioma;
import com.proyectoportfolio.primerportfolio.service.IIdiomaService;



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
public class IdiomaController {
    @Autowired
    private IIdiomaService interIdioma;
    
    @GetMapping("/idiomas")
    public List<Idioma> getIdiomas(){
        return interIdioma.getIdiomas();
    }
    
    @GetMapping("/idiomas/{id}")
   public Idioma findIdioma(@PathVariable Long id){
   Idioma idi = interIdioma.findIdioma(id);
   return idi;}
    
   @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/idiomas")
    public String createIdioma (@RequestBody Idioma idi){
        interIdioma.saveIdioma(idi);
        return "El idioma fue creado correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/idiomas/borrar/{id}")
    public String deleteIdioma (@PathVariable Long id){
        interIdioma.deleteIdioma(id);
        return "El idioma fue eliminado correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("idiomas/{id}")
    public Idioma editProyecto (@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam ("nivel") Long nuevoNivel){
        
        Idioma idi = interIdioma.findIdioma(id);
        idi.setNombre(nuevoNombre);
        idi.setNivel(nuevoNivel);
        
        
        interIdioma.saveIdioma(idi);
        return idi;
    }
}

