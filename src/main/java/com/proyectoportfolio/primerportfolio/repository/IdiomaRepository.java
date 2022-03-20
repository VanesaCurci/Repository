
package com.proyectoportfolio.primerportfolio.repository;

import com.proyectoportfolio.primerportfolio.model.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdiomaRepository extends JpaRepository<Idioma,Long>{
    
}
