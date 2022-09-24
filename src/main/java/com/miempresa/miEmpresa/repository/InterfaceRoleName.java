package com.miempresa.miEmpresa.repository;

import com.miempresa.miEmpresa.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceRoleName extends JpaRepository<RoleName, Integer> {
}
