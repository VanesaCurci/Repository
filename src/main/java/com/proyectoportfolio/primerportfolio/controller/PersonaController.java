
package com.proyectoportfolio.primerportfolio.controller;

import com.proyectoportfolio.primerportfolio.model.Persona;
import com.proyectoportfolio.primerportfolio.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController

@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired
    private IPersonaService interPersona;
    
    @GetMapping("/personas")
    public List<Persona> getPersonas(){
        return interPersona.getPersonas();
    }
    
    @GetMapping("/personas/{id}")
    public Persona findPersona(@PathVariable Long id){
    Persona perso = interPersona.findPersona(id);
    return perso;}
   
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/personas")
    public String createPersona (@RequestBody Persona perso){
        interPersona.savePersona(perso);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/personas/borrar/{id}")
    public String deletePersona (@PathVariable Long id_persona){
        interPersona.deletePersona(id_persona);
        return "La persona fue eliminada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("personas/editar/{id}")
    public Persona editPersona (@PathVariable Long id_persona,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam ("apellido") String nuevoApellido,
                                @RequestParam ("edad") int nuevaEdad,
                                @RequestParam ("foto_perfil")String nuevoFoto_perfil,
                                @RequestParam ("foto_fondo")String nuevoFoto_fondo){
        
        Persona perso = interPersona.findPersona(id_persona);
        perso.setApellido(nuevoApellido);
        perso.setNombre(nuevoNombre);
        perso.setEdad(nuevaEdad);
        perso.setFoto_perfil(nuevoFoto_perfil);
        perso.setFoto_fondo(nuevoFoto_fondo);
        
        interPersona.savePersona(perso);
        return perso;
    }
}
