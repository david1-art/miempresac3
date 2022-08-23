package com.miempresa.miEmpresa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Anotaciones
@RestController
public class UsuarioController {
    @RequestMapping(value = "saludo")
    public String saludo(){
        return "Hello";
    }

    @RequestMapping(value = "helloworld")
    public String helloworld(){
        return "Hello Developers";
    }
}
