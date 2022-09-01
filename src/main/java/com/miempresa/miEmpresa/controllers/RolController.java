package com.miempresa.miEmpresa.controllers;

import com.miempresa.miEmpresa.entities.RolModel;
import com.miempresa.miEmpresa.services.RolService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RolController {

    private RolService rolService;

    public RolController(RolService service){
        this.rolService = service;
    }

    @RequestMapping("getrol")
    public ArrayList<RolModel> getRol(){
        return this.rolService.selectAll();
    }
}
