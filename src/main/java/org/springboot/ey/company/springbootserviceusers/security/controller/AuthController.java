package org.springboot.ey.company.springbootserviceusers.security.controller;

import org.springboot.ey.company.springbootserviceusers.security.dto.JwtDto;
import org.springboot.ey.company.springbootserviceusers.security.dto.LoginUsuario;
import org.springboot.ey.company.springbootserviceusers.security.dto.Mensaje;
import org.springboot.ey.company.springbootserviceusers.security.dto.NuevoUsuario;
import org.springboot.ey.company.springbootserviceusers.security.entity.Rol;
import org.springboot.ey.company.springbootserviceusers.security.entity.Usuario;
import org.springboot.ey.company.springbootserviceusers.security.enums.RolNombre;
import org.springboot.ey.company.springbootserviceusers.security.jwt.JwtProvider;
import org.springboot.ey.company.springbootserviceusers.security.service.RolService;
import org.springboot.ey.company.springbootserviceusers.security.service.UsuarioService;
import org.springboot.ey.company.springbootserviceusers.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    private IUsuariosService usuariosService;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevoUsuarioJwt(@Valid @RequestBody NuevoUsuario nuevoUsuario){
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("El nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("El email ya existe"), HttpStatus.BAD_REQUEST);
        Usuario usuario =
                new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
                        passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("Usuario guardado con exito"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        usuariosService.updateUserJwt(jwtDto.getNombreUsuario(), jwtDto.getToken());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
