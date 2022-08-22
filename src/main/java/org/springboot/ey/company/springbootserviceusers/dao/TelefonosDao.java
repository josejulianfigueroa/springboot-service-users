package org.springboot.ey.company.springbootserviceusers.dao;

import org.springboot.ey.company.springbootserviceusers.entity.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TelefonosDao extends JpaRepository<Telefono, Long> {
    List<Telefono> findAllByIduser(Long id);
    Optional<Telefono> findById(Long id);
    List<Telefono> findAll();
}