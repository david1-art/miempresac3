package com.miempresa.miEmpresa.controllers;

import com.miempresa.miEmpresa.entities.Perfil;
import com.miempresa.miEmpresa.entities.Transaccion;
import com.miempresa.miEmpresa.services.Response;
import com.miempresa.miEmpresa.services.TransaccionService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TransaccionController {

    private TransaccionService transaccionService;

    public TransaccionController(TransaccionService service){
        this.transaccionService = service;
    }

    // Buscar todas las tansacciones
    @RequestMapping("gettransacciones")
    public ArrayList<Transaccion> getTransacciones(){
        return this.transaccionService.selectAll();
    }

    // Buscar transaccion por id
    @RequestMapping("gettransaccion/{id}")
    public Transaccion gettransaccion(@PathVariable int id){
        return this.transaccionService.selectById(id);
    }

    // Crear una transaccion
    @PostMapping("createtransaccion")
    public Response createTransaccion(@RequestBody Transaccion request){
        return this.transaccionService.createTransaccion(request);
    }

    // Eliminar una transaccion
    @DeleteMapping("deletetransaccion/{id}")
    public Response deleteTransaccion(@PathVariable int id){
        return this.transaccionService.deleteTransaccionById(id);
    }
}
