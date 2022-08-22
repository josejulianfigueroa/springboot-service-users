package org.springboot.ey.company.springbootserviceusers.security.dto;

import javax.validation.constraints.NotBlank;

public class LoginUsuario {
    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String password;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public LoginUsuario setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginUsuario setPassword(String password) {
        this.password = password;
        return this;
    }
}
