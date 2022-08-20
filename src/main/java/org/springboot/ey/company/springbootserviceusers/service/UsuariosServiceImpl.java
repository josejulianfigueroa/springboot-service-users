package org.springboot.ey.company.springbootserviceusers.service;

import org.springboot.ey.company.springbootserviceusers.dao.TelefonosDao;
import org.springboot.ey.company.springbootserviceusers.dao.UsuariosDao;
import org.springboot.ey.company.springbootserviceusers.entity.Telefono;
import org.springboot.ey.company.springbootserviceusers.dto.DataUsersIn;
import org.springboot.ey.company.springbootserviceusers.entity.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
	@Transactional(readOnly = true)
	public Usuarios findByEmail(String email) { return usuariosDao.findByEmail(email);};

	@Override
	public Usuarios addUser(DataUsersIn dataUsersIn) {
		Usuarios user = usuariosDao.findByEmail(dataUsersIn.getEmail());
		/*List<Usuarios> usuariosList = usuariosDao.findAll().stream()
				.filter(e -> e.getEmail().equals(dataUsersIn.getEmail()))
				.collect(Collectors.toList());*/
		Usuarios usuariosAdd = null;
		if (user == null) { 			// Si el usuarios by email no existe en la base de datos
			usuariosAdd = usuariosDao.save(new Usuarios(dataUsersIn.getName(), dataUsersIn.getEmail(), dataUsersIn.getPassword(), new Date(), new Date(), new Date(),  "", false));
			if(!dataUsersIn.getPhones().isEmpty()){
		for (Telefono objFono : dataUsersIn.getPhones()) {
			telefonosDao.save(new Telefono(objFono.getNumber(), objFono.getCitycode(), objFono.getContrycode(), usuariosAdd.getId()));
		}}
		}
		return usuariosAdd;
	}
	@Override
	public void updateUserJwt(String email, String token) {
		Usuarios user = usuariosDao.findByEmail(email);
		user.setIsactive(true);
		user.setToken(token);
		user.setLast_login(new Date());
		usuariosDao.save(user);
	}

	@Override
	public boolean existsByEmail(String email){
		return usuariosDao.existsByEmail(email);
	}
	@Override
	public boolean existsById(Long id){
		return usuariosDao.existsById(id);
	}

	@Override
	public void deleteById(Long id){
		List<Telefono> listaTelefonosUser = telefonosDao.findAllByIduser(id);
		if(!listaTelefonosUser.isEmpty()){
			for (Telefono objFono : listaTelefonosUser) {
				telefonosDao.deleteById(objFono.getId());
			}}
		usuariosDao.deleteById(id);
	}
}
