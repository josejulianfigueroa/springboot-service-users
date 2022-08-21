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
		return usuariosDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuarios findByEmail(String email) { return usuariosDao.findByEmail(email);};

	@Override
	public Usuarios addUser(DataUsersIn dataUsersIn) {
		Usuarios user = usuariosDao.findByEmail(dataUsersIn.getEmail());
		Usuarios usuariosAdd = null;
		if (user == null) {
			usuariosAdd = usuariosDao.save(new Usuarios(dataUsersIn.getName(), dataUsersIn.getEmail(), dataUsersIn.getPassword(), new Date(), new Date(), new Date(),  "", false));
			if(!dataUsersIn.getPhones().isEmpty()){
		for (Telefono objFono : dataUsersIn.getPhones()) {
			telefonosDao.save(new Telefono(objFono.getNumber(), objFono.getCitycode(), objFono.getContrycode(), usuariosAdd.getId()));
		}}
		}
		return usuariosAdd;
	}
	@Override
	public void updateUserJwt(String email, String token, boolean activo) {
		Usuarios user = usuariosDao.findByEmail(email);
		if(user != null){
		user.setIsactive(activo);
		user.setToken(token);
		user.setLast_login(new Date());
		usuariosDao.save(user);}
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
