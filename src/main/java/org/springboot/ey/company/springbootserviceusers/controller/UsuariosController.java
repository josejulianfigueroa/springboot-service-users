package org.springboot.ey.company.springbootserviceusers.controller;

import org.springboot.ey.company.springbootserviceusers.dto.DataUsersIn;
import org.springboot.ey.company.springbootserviceusers.dto.DataUsersPhone;
import org.springboot.ey.company.springbootserviceusers.entity.Usuarios;
import org.springboot.ey.company.springbootserviceusers.security.controller.AuthController;
import org.springboot.ey.company.springbootserviceusers.security.dto.LoginUsuario;
import org.springboot.ey.company.springbootserviceusers.service.IUsuariosService;
import org.springboot.ey.company.springbootserviceusers.util.EmailValidator;
import org.springboot.ey.company.springbootserviceusers.util.PasswordValidator;
import org.springboot.ey.company.springbootserviceusers.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
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
	private final String SIN_RESULTADOS = "No existen registros";
	private final String SIN_RESULTADO = "No existe el registro";
	private final String ID_NO_EXISTE = "No existe el id en la base de datos";
	private final String USUARIO_ELIMINADO = "El usuario ha sido eliminado con éxito";
	private final String USUARIO_ACTUALIZADO_OK = "Los datos han sido actualizados con éxito";
	private final String USUARIO_YA_EXITE = "Usuario ya existe";

	@Autowired
	AuthController authController;

	@Autowired
	private IUsuariosService usuariosService;

	@PostMapping(value = "/insertar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView addUser(@Valid @RequestBody DataUsersIn dataUsersIn)  {
		Usuarios usuarioExiste = usuariosService.findByEmail(dataUsersIn.getEmail());
		if (usuarioExiste == null) {
			EmailValidator validatorEmail = new EmailValidator();
				if(validatorEmail.isValid(dataUsersIn.getEmail())) {
					PasswordValidator validatorPassword = new PasswordValidator();
						if (validatorPassword.isValid(dataUsersIn.getPassword())) {
							Usuarios users = usuariosService.addUser(dataUsersIn);
								if (users != null) {
									authController.getInUser(dataUsersIn.getName(), dataUsersIn.getEmail(), dataUsersIn.getEmail(), dataUsersIn.getPassword(), dataUsersIn.getRoles());
									authController.login(new LoginUsuario().setNombreUsuario(dataUsersIn.getEmail()).setPassword(dataUsersIn.getPassword()));
									return ResponseUtil.getResponseOk(HttpStatus.CREATED.toString(), users);
								} else {
									return ResponseUtil.getResponseMensaje(HttpStatus.BAD_REQUEST.toString(), EMAIL_EXISTE);
								}
						} else {
							return ResponseUtil.getResponseMensaje(HttpStatus.BAD_REQUEST.toString(), PASSWORD_INCORRECTO);
					}
				}else {
						return ResponseUtil.getResponseMensaje(HttpStatus.BAD_REQUEST.toString(), EMAIL_INCORRECTO);
			}
		} else {
			return ResponseUtil.getResponseMensaje(HttpStatus.BAD_REQUEST.toString(), USUARIO_YA_EXITE);
		}
	}


	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView listUsers(){
		List<Usuarios> usuarios = usuariosService.findAll();
		if (!usuarios.isEmpty()) {
			return ResponseUtil.getResponseOkListUsuarios(HttpStatus.OK.toString(), usuarios);
		} else {
			return ResponseUtil.getResponseMensaje(HttpStatus.NO_CONTENT.toString(), SIN_RESULTADOS);
		}
	}
	
	@GetMapping(value = "/ver/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView getUser(@PathVariable String email) {
		Usuarios usuario = usuariosService.findByEmail(email);
		if (usuario != null) {
			return ResponseUtil.getResponseOk(HttpStatus.OK.toString(), usuario);
		} else {
			return ResponseUtil.getResponseMensaje(HttpStatus.NO_CONTENT.toString(), SIN_RESULTADO);
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView getDeleteUser(@PathVariable Long id){
		if(!usuariosService.existsById(id))
			return ResponseUtil.getResponseMensaje(HttpStatus.NOT_FOUND.toString(), ID_NO_EXISTE);
		usuariosService.deleteById(id);
		return ResponseUtil.getResponseMensaje(HttpStatus.OK.toString(), USUARIO_ELIMINADO);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{id}")
	public ModelAndView getUpdateUser(@PathVariable Long id, @RequestBody DataUsersPhone dataUsersIn) {
		if (!usuariosService.existsById(id)) {
			return ResponseUtil.getResponseMensaje(HttpStatus.NOT_FOUND.toString(), ID_NO_EXISTE);
		} else {
			EmailValidator validatorEmail = new EmailValidator();
			if (validatorEmail.isValid(dataUsersIn.getEmail())) {
				PasswordValidator validatorPassword = new PasswordValidator();
				if (validatorPassword.isValid(dataUsersIn.getPassword())) {
					usuariosService.updateUserAndPhones(id, dataUsersIn);
					return ResponseUtil.getResponseMensaje(HttpStatus.OK.toString(), USUARIO_ACTUALIZADO_OK);
				} else {
					return ResponseUtil.getResponseMensaje(HttpStatus.BAD_REQUEST.toString(), PASSWORD_INCORRECTO);
				}
			} else {
				return ResponseUtil.getResponseMensaje(HttpStatus.BAD_REQUEST.toString(), EMAIL_INCORRECTO);
			}
		}
	}
}
