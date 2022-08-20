package org.springboot.ey.company.springbootserviceusers.service;

import org.springboot.ey.company.springbootserviceusers.dao.TelefonosDao;
import org.springboot.ey.company.springbootserviceusers.entity.Telefono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TelefonosServiceImpl implements ITelefonosService{


	@Autowired
	private TelefonosDao telefonosDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Telefono> findAll() {
		return (List<Telefono>) telefonosDao.findAll();
	}

}
