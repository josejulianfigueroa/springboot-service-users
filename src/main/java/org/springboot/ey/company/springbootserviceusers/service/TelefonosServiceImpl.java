package org.springboot.ey.company.springbootserviceusers.service;

import org.springboot.ey.company.springbootserviceusers.dao.TelefonosDao;
import org.springboot.ey.company.springbootserviceusers.dao.UsuariosDao;
import org.springboot.ey.company.springbootserviceusers.entity.Telefonos;
import org.springboot.ey.company.springbootserviceusers.entity.Usuarios;
import org.springboot.ey.company.springbootserviceusers.pojo.DataUsersIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TelefonosServiceImpl implements ITelefonosService{


	@Autowired
	private TelefonosDao telefonosDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Telefonos> findAll() {
		return (List<Telefonos>) telefonosDao.findAll();
	}

}
