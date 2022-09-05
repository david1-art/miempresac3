package com.miempresa.miEmpresa.controllers;

import com.miempresa.miEmpresa.entities.Perfil;
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

    // Buscar todos los perfiles
    @RequestMapping("getperfiles")
    public ArrayList<Perfil> getPerfiles(){
        return this.perfilService.selectAll();
    }

    // Buscar perfil por id
    @RequestMapping("getperfil/{id}")
    public Perfil getperfil(@PathVariable int id){
        return this.perfilService.selectById(id);
    }

    // Crear perfil
    @PostMapping("createperfil")
    public Response createPerfil(@RequestBody Perfil request){
        return this.perfilService.createPerfil(request);
    }

    // Eliminar perfil
    @DeleteMapping("deleteperfil/{id}")
    public Response deletePerfil(@PathVariable int id){
        return this.perfilService.deletePerfilById(id);
    }
}
