package com.miempresa.miEmpresa.controllers;

import com.miempresa.miEmpresa.entities.TransaccionModel;
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

    @RequestMapping("gettransaccion")
    public ArrayList<TransaccionModel> getTransaccion(){
        return this.transaccionService.selectAll();
    }

    @PostMapping("createtransaccion")
    public Response createTransaccion(@RequestBody TransaccionModel request){
        return this.transaccionService.createTransaccion(request);
    }

    @DeleteMapping("deletetransaccion/{id}")
    public Response deleteTransaccion(@PathVariable int id){
        return this.transaccionService.deleteTransaccionById(id);
    }
}
