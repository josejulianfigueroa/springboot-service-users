package org.springboot.ey.company.springbootserviceusers.controller;

import org.springboot.ey.company.springbootserviceusers.entity.Telefono;
import org.springboot.ey.company.springbootserviceusers.service.ITelefonosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class TelefonosController {

	@Autowired
	private ITelefonosService telefonoService;


	@GetMapping("/telefonos/listar")
	public List<Telefono> listarTelefonos(){
		return telefonoService.findAll();
	}


}
