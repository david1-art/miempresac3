package com.miempresa.miEmpresa.controllers;

import com.miempresa.miEmpresa.entities.Empresa;
import com.miempresa.miEmpresa.services.EmpresaService;
import com.miempresa.miEmpresa.services.Response;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EmpresaController {

    private EmpresaService empresaService;

    public EmpresaController(EmpresaService service){
        this.empresaService = service;
    }

    // Buscar todas las empresas
    @RequestMapping("getempresas")
    public ArrayList<Empresa> getEmpresas(){
        return this.empresaService.selectAll();
    }

    // Buscar empresa por id
    @RequestMapping("getempresa/{id}")
    public Empresa getEmpresa(@PathVariable int id){
        return this.empresaService.selectById(id);
    }

    // Crear una empresa
    @PostMapping("createempresa")
    public Response createEmpresa(@RequestBody Empresa request){
        return this.empresaService.createEmpresa(request);
    }

    // Eliminar una empresa
    @DeleteMapping("deleteempresa/{id}")
    public Response deleteEmpresa(@PathVariable int id){
        return this.empresaService.deleteEmpresaById(id);
    }

    // Actualizar empresa
    @PutMapping("actualizarempresa/{id}")
    public Response updateEmpresa(@RequestBody Empresa request){
        return this.empresaService.actualizarEmpresa(request);
    }
}
