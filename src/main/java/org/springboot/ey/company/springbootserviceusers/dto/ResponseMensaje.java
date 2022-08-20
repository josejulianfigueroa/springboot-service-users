package org.springboot.ey.company.springbootserviceusers.dto;

public class ResponseMensaje {

    String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ResponseMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
