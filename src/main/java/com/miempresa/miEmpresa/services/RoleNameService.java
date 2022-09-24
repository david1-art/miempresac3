package com.miempresa.miEmpresa.services;

import com.miempresa.miEmpresa.enums.RoleName;
import com.miempresa.miEmpresa.repository.InterfaceRoleName;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RoleNameService {

    private InterfaceRoleName roleNameRepository;
    public RoleNameService(InterfaceRoleName rep){
        this.roleNameRepository = rep;
    }

    public ArrayList<RoleName> selectAll(){
        return (ArrayList<RoleName>) this.roleNameRepository.findAll();
    }

    public RoleName selectById(int id){
        Optional<RoleName> exists = this.roleNameRepository.findById(id);
        if (exists.isPresent()){
            return exists.get();
        }
        else{
            return null;
        }
    }
}
