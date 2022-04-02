
package com.proyectoportfolio.primerportfolio.service;

import com.proyectoportfolio.primerportfolio.model.Educacion;
import java.util.List;


public interface IEducacionService {
    public List<Educacion> getEducaciones();
    public void saveEducacion(Educacion edu);
    public void deleteEducacion (Long id);
    public Educacion findEducacion(Long id);
}
