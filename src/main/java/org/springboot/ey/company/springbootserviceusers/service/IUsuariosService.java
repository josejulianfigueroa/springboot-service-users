package org.springboot.ey.company.springbootserviceusers.service;


import org.springboot.ey.company.springbootserviceusers.pojo.DataUsersIn;
import org.springboot.ey.company.springbootserviceusers.entity.Usuario;

import java.util.List;

public interface IUsuariosService {

	public List<Usuario> findAll();
	public Usuario findById(Long id);
	public Usuario addUser(DataUsersIn user);
}
