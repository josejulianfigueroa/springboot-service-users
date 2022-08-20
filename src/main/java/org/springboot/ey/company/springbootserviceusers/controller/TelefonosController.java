package org.springboot.ey.company.springbootserviceusers.controller;

import org.springboot.ey.company.springbootserviceusers.entity.Telefonos;
import org.springboot.ey.company.springbootserviceusers.entity.Usuarios;
import org.springboot.ey.company.springbootserviceusers.pojo.DataUsersIn;
import org.springboot.ey.company.springbootserviceusers.service.ITelefonosService;
import org.springboot.ey.company.springbootserviceusers.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class TelefonosController {

	@Autowired
	private ITelefonosService telefonoService;


	@GetMapping("/telefonos/listar")
	public List<Telefonos> listarTelefonos(){
		return telefonoService.findAll();
	}


}
