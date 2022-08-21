package org.springboot.ey.company.springbootserviceusers;

import javax.validation.constraints.NotBlank;

public class LoginUsuarioTest {
    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String password;

    public LoginUsuarioTest(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
