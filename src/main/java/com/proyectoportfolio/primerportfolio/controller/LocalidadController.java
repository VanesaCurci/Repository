
package com.proyectoportfolio.primerportfolio.controller;

import com.proyectoportfolio.primerportfolio.model.Localidad;
import com.proyectoportfolio.primerportfolio.service.ILocalidadService;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class LocalidadController {
    @Autowired
    private ILocalidadService interLocalidad;
    
    @GetMapping("/localidades")
    public List<Localidad> getLocalidades(){
        return interLocalidad.getLocalidades();
    }
    
    @PostMapping ("/agregar/localidades")
    public String createLocalidad (@RequestBody Localidad loca){
        interLocalidad.saveLocalidad(loca);
        return "La localidad fue creada correctamente";
    }
    
    @DeleteMapping ("/localidades/borrar/{id}")
    public String deleteLocalidad (@PathVariable Long id){
        interLocalidad.deleteLocalidad(id);
        return "La localidad fue eliminada correctamente";
    }
    
    @PutMapping ("localidades/editar/{id}")
    public Localidad editLocalidad (@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre){
        
        Localidad loca = interLocalidad.findLocalidad(id);
        loca.setNombre(nuevoNombre);
        
        interLocalidad.saveLocalidad(loca);
        return loca;
    }
}

