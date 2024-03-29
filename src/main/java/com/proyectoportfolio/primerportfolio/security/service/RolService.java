
package com.proyectoportfolio.primerportfolio.security.service;

import com.proyectoportfolio.primerportfolio.security.entity.Rol;
import com.proyectoportfolio.primerportfolio.security.enums.RolNombre;
import com.proyectoportfolio.primerportfolio.security.repository.RolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    
    @Autowired
    RolRepository rolRepository;
    
    public Optional<Rol>getByRolNombre(RolNombre rolNombre){
    return rolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
    rolRepository.save(rol);
    }
}
