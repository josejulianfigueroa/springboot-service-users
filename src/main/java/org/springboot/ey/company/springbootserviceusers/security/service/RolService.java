package org.springboot.ey.company.springbootserviceusers.security.service;

import org.springboot.ey.company.springbootserviceusers.security.entity.Rol;
import org.springboot.ey.company.springbootserviceusers.security.enums.RolNombre;
import org.springboot.ey.company.springbootserviceusers.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
