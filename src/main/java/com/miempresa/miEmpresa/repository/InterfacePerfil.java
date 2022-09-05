package com.miempresa.miEmpresa.repository;

import com.miempresa.miEmpresa.entities.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfacePerfil extends JpaRepository<Perfil, Integer> {
}
