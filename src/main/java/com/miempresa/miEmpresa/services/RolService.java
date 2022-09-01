package com.miempresa.miEmpresa.services;

import com.miempresa.miEmpresa.entities.PerfilModel;
import com.miempresa.miEmpresa.entities.RolModel;
import com.miempresa.miEmpresa.repository.InterfaceRol;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RolService {

    private InterfaceRol rolRepository;

    public RolService(InterfaceRol rep){
        this.rolRepository = rep;
    }

    public ArrayList<RolModel> selectAll(){
        return (ArrayList<RolModel>) this.rolRepository.findAll();
    }
}
