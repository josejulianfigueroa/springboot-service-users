package org.springboot.ey.company.springbootserviceusers.util;
import org.springboot.ey.company.springbootserviceusers.entity.Telefono;
import org.springboot.ey.company.springbootserviceusers.entity.Usuarios;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

public class ResponseUtil {
    private static final String MENSAJE = "mensaje";
    private static final String CODE = "codigo";
    private static final String USUARIO = "usuario";
    private static final String DATA = "data";

    public static ModelAndView getResponseOk(String codigo, Usuarios data) {
        ModelAndView model = new ModelAndView();
        model.setView(new MappingJackson2JsonView());
        model.addObject(USUARIO, data);
        model.addObject(CODE, codigo);
        return model;
    }

    public static ModelAndView getResponseOkListUsuarios(String codigo, List<Usuarios> data) {
        ModelAndView model = new ModelAndView();
        model.setView(new MappingJackson2JsonView());
        model.addObject(DATA, data);
        model.addObject(CODE, codigo);
        return model;
    }
    public static ModelAndView getResponseOkListTelefonos(String codigo, List<Telefono> data) {
        ModelAndView model = new ModelAndView();
        model.setView(new MappingJackson2JsonView());
        model.addObject(DATA, data);
        model.addObject(CODE, codigo);
        return model;
    }

    public static ModelAndView getResponseMensaje(String codigo, String mensaje) {
        ModelAndView model = new ModelAndView();
        model.setView(new MappingJackson2JsonView());
        model.addObject(CODE, codigo);
        model.addObject(MENSAJE, mensaje);
        return model;
    }

    private ResponseUtil() {

    }
}

