package org.springboot.ey.company.springbootserviceusers.service;

import org.springboot.ey.company.springbootserviceusers.dao.TelefonosDao;
import org.springboot.ey.company.springbootserviceusers.dao.UsuariosDao;
import org.springboot.ey.company.springbootserviceusers.entity.Telefono;
import org.springboot.ey.company.springbootserviceusers.pojo.DataUsersIn;
import org.springboot.ey.company.springbootserviceusers.entity.Usuario;
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
	public List<Usuario> findAll() {
		return (List<Usuario>) usuariosDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return usuariosDao.findById(id).orElse(null);
	}

	@Override
	public Usuario addUser(DataUsersIn dataUsersIn) {
		List<Usuario> usuarioList = usuariosDao.findAll().stream()
				.filter(e -> e.getEmail().equals(dataUsersIn.getEmail()))
				.collect(Collectors.toList());
		Usuario usuarioAdd = null;
		if (usuarioList.isEmpty()) {
			// Usuario no existe
			usuarioAdd = usuariosDao.save(new Usuario(dataUsersIn.getName(), dataUsersIn.getEmail(), dataUsersIn.getPassword(), new Date(), new Date(), new Date(),  "", false));
			if(!dataUsersIn.getPhones().isEmpty()){
		for (Telefono objFono : dataUsersIn.getPhones()) {
			telefonosDao.save(new Telefono(objFono.getNumber(), objFono.getCitycode(), objFono.getContrycode(), usuarioAdd.getId()));
		}}
		}
		return usuarioAdd;
	}
}
