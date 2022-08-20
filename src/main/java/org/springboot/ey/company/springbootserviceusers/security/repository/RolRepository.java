package org.springboot.ey.company.springbootserviceusers.security.repository;

import org.springboot.ey.company.springbootserviceusers.security.entity.Rol;
import org.springboot.ey.company.springbootserviceusers.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
