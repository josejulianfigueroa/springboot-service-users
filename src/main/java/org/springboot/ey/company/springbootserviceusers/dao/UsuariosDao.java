package org.springboot.ey.company.springbootserviceusers.dao;


import org.springboot.ey.company.springbootserviceusers.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuariosDao extends CrudRepository<Usuario, Long> {
    List<Usuario> findAll();
}
