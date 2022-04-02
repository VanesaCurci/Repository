
package com.proyectoportfolio.primerportfolio.service;


import com.proyectoportfolio.primerportfolio.model.Tecnologia;
import com.proyectoportfolio.primerportfolio.repository.TecnologiaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnologiaServicio implements ITecnologiaServicio{
    @Autowired
    private TecnologiaRepository tecnoRepository;

    @Override
    public List<Tecnologia> getTecnologias() {
        List<Tecnologia> listaTecnologias = tecnoRepository.findAll();
        return listaTecnologias;
    }

    @Override
    public void saveTecnologia(Tecnologia tecno) {
        tecnoRepository.save(tecno);
    }

    @Override
    public void deleteTecnologia(Long id) {
        tecnoRepository.deleteById(id);
    }
    @Override
     public Tecnologia findTecnologia (Long id){
        Tecnologia tecno = tecnoRepository.findById(id).orElse(null);
        return tecno;
    }
    
}
