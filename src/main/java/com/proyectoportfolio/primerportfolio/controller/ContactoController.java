
package com.proyectoportfolio.primerportfolio.controller;

import com.proyectoportfolio.primerportfolio.model.Contacto;
import com.proyectoportfolio.primerportfolio.service.IContactoService;



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


public class ContactoController {
    @Autowired
    private IContactoService interContacto;
    
    @GetMapping("/contactos")
    public List<Contacto> getContactos(){
        return interContacto.getContactos();
    }
    
    @GetMapping("/contactos/{id}")
   public Contacto findContacto(@PathVariable Long id){
   Contacto conta = interContacto.findContacto(id);
   return conta;}
    
    @PostMapping ("/agregar/contactos")
    public String createContacto (@RequestBody Contacto conta){
        interContacto.saveContacto(conta);
        return "El contacto fue creado correctamente";
    }
    
    @DeleteMapping ("/contactos/borrar/{id}")
    public String deleteContacto (@PathVariable Long id){
        interContacto.deleteContacto(id);
        return "El contacto fue eliminado correctamente";
    }
    
    @PutMapping ("contactos/editar/{id}")
    public Contacto editContacto (@PathVariable Long id,
                                @RequestParam("mail") String nuevoMail,
                                @RequestParam("facebook") String nuevoFacebook,
                                @RequestParam("whatsapp") int nuevoWhatsapp,
                                @RequestParam("twitter") String nuevoTwitter,
                                @RequestParam("linkedIn") String nuevoLinkedIn,
                                @RequestParam ("instagram") String nuevoInstagram){
        
        Contacto conta = interContacto.findContacto(id);
        conta.setMail(nuevoMail);
        conta.setFacebook(nuevoFacebook);
        conta.setWhatsapp(nuevoWhatsapp);
        conta.setTwitter(nuevoTwitter);
        conta.setLinkedIn(nuevoLinkedIn);
        conta.setInstagram(nuevoInstagram);
        
        
        interContacto.saveContacto(conta);
        return conta;
    }
}


