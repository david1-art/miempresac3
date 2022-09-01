package com.miempresa.miEmpresa.controllers;

import com.miempresa.miEmpresa.entities.PerfilModel;
import com.miempresa.miEmpresa.services.PerfilService;
import com.miempresa.miEmpresa.services.Response;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PerfilController {

    private PerfilService perfilService;

    public PerfilController(PerfilService service){
        this.perfilService = service;
    }

    @RequestMapping("getperfil")
    public ArrayList<PerfilModel> getPerfil(){
        return this.perfilService.selectAll();
    }

    @PostMapping("createperfil")
    public Response createPerfil(@RequestBody PerfilModel request){
        return this.perfilService.createPerfil(request);
    }

    @DeleteMapping("deleteperfil/{id}")
    public Response deletePerfil(@PathVariable int id){
        return this.perfilService.deletePerfilById(id);
    }
}
