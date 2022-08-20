package org.springboot.ey.company.springbootserviceusers.service;


import org.springboot.ey.company.springbootserviceusers.pojo.DataUsersIn;
import org.springboot.ey.company.springbootserviceusers.entity.Usuarios;

import java.util.List;

public interface IUsuariosService {

	public List<Usuarios> findAll();
	public Usuarios findById(Long id);
	public Usuarios addUser(DataUsersIn user);
}
