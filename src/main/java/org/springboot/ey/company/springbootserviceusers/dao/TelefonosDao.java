package org.springboot.ey.company.springbootserviceusers.dao;

import org.springboot.ey.company.springbootserviceusers.entity.Telefono;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TelefonosDao extends CrudRepository<Telefono, Long> {
    void deleteByIduser(Long id);
    List<Telefono> findAllByIduser(Long id);
;}
