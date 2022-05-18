
package com.proyectoportfolio.primerportfolio.security.repository;

import com.proyectoportfolio.primerportfolio.security.entity.Rol;
import com.proyectoportfolio.primerportfolio.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
