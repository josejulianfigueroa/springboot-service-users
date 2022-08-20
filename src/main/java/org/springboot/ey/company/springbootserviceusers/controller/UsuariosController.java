package org.springboot.ey.company.springbootserviceusers.controller;

import org.springboot.ey.company.springbootserviceusers.pojo.DataUsersIn;
import org.springboot.ey.company.springbootserviceusers.entity.Usuario;
import org.springboot.ey.company.springbootserviceusers.service.IUsuariosService;
import org.springboot.ey.company.springbootserviceusers.util.EmailValidator;
import org.springboot.ey.company.springbootserviceusers.util.PasswordValidator;
import org.springboot.ey.company.springbootserviceusers.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/usuarios")
@Validated
@CrossOrigin
public class UsuariosController {

	private final String EMAIL_EXISTE = "El email ya existe en la base de datos";
	private final String PASSWORD_INCORRECTO = "El password debe tener el siguiente formatato: Una Mayuscula, letras minúsculas, y dos numeros, ejemplo Aprueba22";
	private final String EMAIL_INCORRECTO = "El email no es válido";

	//@Autowired
	//private Environment env;
	
	//@Value("${server.port}")
	//private Integer port;
	
	@Autowired
	private IUsuariosService usuariosService;
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> listarUsuarios(){
		/*return usuariosService.findAll().stream().map(producto ->{
			//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			//producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());*/
		return usuariosService.findAll();
	}
	
	@GetMapping("/ver/{id}")
	public Usuario detalle(@PathVariable Long id) {
		Usuario usuario = usuariosService.findById(id);
		//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return usuario;
	}

	@PostMapping(value = "/insertar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView addUser(@Valid @RequestBody DataUsersIn dataUsersIn)  {

		EmailValidator validatorEmail = new EmailValidator();
		if(validatorEmail.isValid(dataUsersIn.getEmail())) {
			PasswordValidator validatorPassword = new PasswordValidator();
			if (validatorPassword.isValid(dataUsersIn.getPassword())) {
				Usuario users = usuariosService.addUser(dataUsersIn);
				if (users != null) {
					return ResponseUtil.getResponseOk(HttpStatus.OK.toString(), users);
				} else {
					return ResponseUtil.getResponseError(HttpStatus.BAD_REQUEST.toString(), EMAIL_EXISTE);
				}
			} else {
				return ResponseUtil.getResponseError(HttpStatus.BAD_REQUEST.toString(), PASSWORD_INCORRECTO);
			}
		}else {
			return ResponseUtil.getResponseError(HttpStatus.BAD_REQUEST.toString(), EMAIL_INCORRECTO);
		}
	}

}
