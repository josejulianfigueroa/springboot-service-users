package org.springboot.ey.company.springbootserviceusers.util;

import org.springboot.ey.company.springbootserviceusers.security.entity.Rol;
import org.springboot.ey.company.springbootserviceusers.security.enums.RolNombre;
import org.springboot.ey.company.springbootserviceusers.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Clase para crear los Roles al iniciar el servicio
 */

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) {
         Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        rolService.save(rolAdmin);
        rolService.save(rolUser);
    }
}
