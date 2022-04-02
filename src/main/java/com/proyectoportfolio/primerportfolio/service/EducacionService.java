
package com.proyectoportfolio.primerportfolio.service;

import com.proyectoportfolio.primerportfolio.model.Educacion;
import com.proyectoportfolio.primerportfolio.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EducacionService implements IEducacionService{
    @Autowired
    private EducacionRepository eduRepository;

    @Override
    public List<Educacion> getEducaciones() {
      List<Educacion> listaEducaciones = eduRepository.findAll();
          return listaEducaciones;    
    }

    @Override
    public void saveEducacion(Educacion educa) {
        eduRepository.save(educa);
    }

    @Override
    public void deleteEducacion(Long id) {
        eduRepository.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Long id) {
        Educacion edu = eduRepository.findById(id).orElse(null);
        return edu;
    }
}
 
