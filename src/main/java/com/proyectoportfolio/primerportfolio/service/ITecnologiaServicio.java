
package com.proyectoportfolio.primerportfolio.service;


import com.proyectoportfolio.primerportfolio.model.Tecnologia;
import java.util.List;


public interface ITecnologiaServicio {
    public List<Tecnologia> getTecnologias ();
    public void saveTecnologia (Tecnologia tecno);
    public void deleteTecnologia (Long id);
    public Tecnologia findTecnologia (Long id);
}
