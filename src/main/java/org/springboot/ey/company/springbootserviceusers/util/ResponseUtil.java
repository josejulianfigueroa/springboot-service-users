package org.springboot.ey.company.springbootserviceusers.util;
import org.springboot.ey.company.springbootserviceusers.entity.Usuarios;
import org.springframework.web.servlet.ModelAndView;

public class ResponseUtil {
    private static final String MENSAJE = "mensaje";
    private static final String CODE = "codigo";
    private static final String USUARIO = "usuario";

    public static ModelAndView getResponseOk(String codigo, String data) {
        ModelAndView model = new ModelAndView("responseOk");
        model.addObject(USUARIO, data);
        model.addObject(CODE, codigo);
        return model;
    }

    public static ModelAndView getResponseError(String codigo, String mensaje) {
        ModelAndView model = new ModelAndView("responseError");
        model.addObject(CODE, codigo);
        model.addObject(MENSAJE, mensaje);
        return model;
    }

    private ResponseUtil() {

    }
}

