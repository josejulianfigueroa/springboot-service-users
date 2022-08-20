package org.springboot.ey.company.springbootserviceusers.service;

import org.springboot.ey.company.springbootserviceusers.dao.TelefonosDao;
import org.springboot.ey.company.springbootserviceusers.dao.UsuariosDao;
import org.springboot.ey.company.springbootserviceusers.entity.Telefonos;
import org.springboot.ey.company.springbootserviceusers.pojo.DataUsersIn;
import org.springboot.ey.company.springbootserviceusers.entity.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuariosServiceImpl implements IUsuariosService{

	@Autowired
	private UsuariosDao usuariosDao;

	@Autowired
	private TelefonosDao telefonosDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuarios> findAll() {
		return (List<Usuarios>) usuariosDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuarios findById(Long id) {
		return usuariosDao.findById(id).orElse(null);
	}

	@Override
	public Usuarios addUser(DataUsersIn dataUsersIn) {
		List<Usuarios> usuariosList = usuariosDao.findAll().stream()
				.filter(e -> e.getEmail().equals(dataUsersIn.getEmail()))
				.collect(Collectors.toList());
		Usuarios usuarioAdd = null;
		if (usuariosList.isEmpty()) {
			// Usuario no existe
			usuarioAdd = usuariosDao.save(new Usuarios(dataUsersIn.getName(), dataUsersIn.getEmail(), dataUsersIn.getPassword(), new Date(), new Date(), new Date(),  "", false));
		}
		/*for (Telefonos objUsuario : usuariosDao.findAll() {

		}

		for (Telefonos obj : dataUsersIn.getPhones()) {
				Telefonos fono = new Telefonos(obj.getNumber(), obj.getCitycode(), obj.getContrycode(), user);
				telefonosDao.save(fono);
			System.out.println("Telefono Insertado" + fono);
		}*/
		return usuarioAdd;
	}
}
