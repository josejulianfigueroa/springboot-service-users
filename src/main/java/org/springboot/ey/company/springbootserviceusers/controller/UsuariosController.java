package org.springboot.ey.company.springbootserviceusers.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springboot.ey.company.springbootserviceusers.pojo.DataUsersIn;
import org.springboot.ey.company.springbootserviceusers.entity.Usuarios;
import org.springboot.ey.company.springbootserviceusers.pojo.ResponseMensaje;
import org.springboot.ey.company.springbootserviceusers.service.IUsuariosService;
import org.springboot.ey.company.springbootserviceusers.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class UsuariosController {
	
	//@Autowired
	//private Environment env;
	
	//@Value("${server.port}")
	//private Integer port;
	
	@Autowired
	private IUsuariosService usuariosService;
	
	@GetMapping(value = "/usuarios/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuarios> listarUsuarios(){
		/*return usuariosService.findAll().stream().map(producto ->{
			//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			//producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());*/
		return usuariosService.findAll();
	}
	
	@GetMapping("/ver/{id}")
	public Usuarios detalle(@PathVariable Long id) {
		Usuarios usuario = usuariosService.findById(id);
		//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return usuario;
	}

	@PostMapping(value = "/usuarios/insertar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView addUser(@RequestBody DataUsersIn dataUsersIn) throws JsonProcessingException {
		Usuarios users = usuariosService.addUser(dataUsersIn);
		if(users != null){
			return ResponseUtil.getResponseOk(HttpStatus.OK.toString(),new ObjectMapper().writeValueAsString(users));
		}else{
			return ResponseUtil.getResponseError(HttpStatus.BAD_REQUEST.toString(),"El email ya existe en la base de datos");
		}

	}

}
