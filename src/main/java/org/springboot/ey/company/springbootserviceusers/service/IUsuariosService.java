package org.springboot.ey.company.springbootserviceusers.service;

import org.springboot.ey.company.springbootserviceusers.dto.DataUsersIn;
import org.springboot.ey.company.springbootserviceusers.entity.Usuarios;
import java.util.List;

public interface IUsuariosService {

	List<Usuarios> findAll();
	Usuarios findById(Long id);
	boolean existsById(Long id);
	Usuarios findByEmail(String email);
	Usuarios addUser(DataUsersIn user);
	void updateUserJwt(String email, String token);
	boolean existsByEmail(String email);
	void deleteById(Long id);

}
