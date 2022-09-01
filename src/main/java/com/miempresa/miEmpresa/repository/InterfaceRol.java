package com.miempresa.miEmpresa.repository;

import com.miempresa.miEmpresa.entities.RolModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceRol extends JpaRepository<RolModel, Integer> {
}
