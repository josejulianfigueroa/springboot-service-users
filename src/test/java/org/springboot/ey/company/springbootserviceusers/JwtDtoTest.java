package org.springboot.ey.company.springbootserviceusers;

import java.util.List;

public class JwtDtoTest {
    private String token;
    private String bearer = "Bearer";
    private String nombreUsuario;
    private List<AuthorityTest> authorities;

    public List<AuthorityTest> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<AuthorityTest> authorities) {
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

}
