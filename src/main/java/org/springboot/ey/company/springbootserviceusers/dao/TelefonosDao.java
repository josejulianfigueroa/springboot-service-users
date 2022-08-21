package org.springboot.ey.company.springbootserviceusers.dao;

import org.springboot.ey.company.springbootserviceusers.entity.Telefono;
import org.springboot.ey.company.springbootserviceusers.entity.Usuarios;
import org.springboot.ey.company.springbootserviceusers.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TelefonosDao extends JpaRepository<Telefono, Long> {
    List<Telefono> findAllByIduser(Long id);
    List<Telefono> findAll();
}