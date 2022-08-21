package org.springboot.ey.company.springbootserviceusers.controller;

import org.springboot.ey.company.springbootserviceusers.entity.Telefono;
import org.springboot.ey.company.springbootserviceusers.service.TelefonosService;
import org.springboot.ey.company.springbootserviceusers.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/telefonos")
public class TelefonosController {

	private final String SIN_RESULTADOS = "No existen registros";

	@Autowired
	TelefonosService telefonosService;

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView  listarTelefonos(){
		List<Telefono> telefonos;
		telefonos = telefonosService.findAll();
		if (!telefonos.isEmpty()) {
			return ResponseUtil.getResponseOkListTelefonos(HttpStatus.OK.toString(), telefonos);
		} else {
			return ResponseUtil.getResponseMensaje(HttpStatus.NO_CONTENT.toString(), SIN_RESULTADOS);
		}
	}


}
