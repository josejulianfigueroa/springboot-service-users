package org.springboot.ey.company.springbootserviceusers.util;
import org.springboot.ey.company.springbootserviceusers.entity.Usuario;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class ResponseUtil {
    private static final String MENSAJE = "mensaje";
    private static final String CODE = "codigo";
    private static final String USUARIO = "usuario";

    public static ModelAndView getResponseOk(String codigo, Usuario data) {
        ModelAndView model = new ModelAndView();
        model.setView(new MappingJackson2JsonView());
        model.addObject(USUARIO, data);
        model.addObject(CODE, codigo);
        return model;
    }

    public static ModelAndView getResponseError(String codigo, String mensaje) {
        ModelAndView model = new ModelAndView();
        model.setView(new MappingJackson2JsonView());
        model.addObject(CODE, codigo);
        model.addObject(MENSAJE, mensaje);
        return model;
    }

    private ResponseUtil() {

    }
}

