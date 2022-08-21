package org.springboot.ey.company.springbootserviceusers.dao;

import org.springboot.ey.company.springbootserviceusers.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuariosDao extends JpaRepository<Usuarios, Long> {
    List<Usuarios> findAll();
    Usuarios findByEmail(String email);
    boolean existsByEmail(String email);
    void deleteById(Long id);
}
