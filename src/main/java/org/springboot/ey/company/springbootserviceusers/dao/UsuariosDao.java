package org.springboot.ey.company.springbootserviceusers.dao;

import org.springboot.ey.company.springbootserviceusers.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuariosDao extends JpaRepository<Usuarios, Long> {
    List<Usuarios> findAll();
    Usuarios findByEmail(String email);
    void deleteById(Long id);
    Optional<Usuarios> findById(Long id);
}
