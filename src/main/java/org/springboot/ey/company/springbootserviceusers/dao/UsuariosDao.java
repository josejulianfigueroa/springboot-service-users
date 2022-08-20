package org.springboot.ey.company.springbootserviceusers.dao;


import org.springboot.ey.company.springbootserviceusers.entity.Usuarios;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuariosDao extends CrudRepository<Usuarios, Long> {
    List<Usuarios> findAll();
}
