package com.miempresa.miEmpresa.controllers;


import com.miempresa.miEmpresa.entities.Empleado;
import com.miempresa.miEmpresa.services.EmpleadoService;
import com.miempresa.miEmpresa.services.Response;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EmpleadoController {

    private EmpleadoService empleadoService;
    public EmpleadoController(EmpleadoService service){
        this.empleadoService = service;
    }

    // Buscar todos los empleados
    @RequestMapping("getempleados")
    public ArrayList<Empleado> getEmpleados(){
        return this.empleadoService.selectAll();
    }

    // Buscar empleado por id
    @RequestMapping("getempleado/{id}")
    public Empleado getEmpleado(@PathVariable int id){
        return this.empleadoService.selectById(id);
    }

    // Crear un empleado
    @PostMapping("createempleado")
    public Response createEmpleado(@RequestBody Empleado request){
        return this.empleadoService.createEmpleado(request);
    }

    // Eliminar un empleado
    @DeleteMapping("deleteempleado/{id}")
    public Response deleteEmpleado(@PathVariable int id){
        return this.empleadoService.deleteEmpleadoById(id);
    }

    // Actualizar un empleado
    @PutMapping("actualizarempleado/{id}")
    public Response updateEmpleado(@RequestBody Empleado request){
        return this.empleadoService.actualizarEmpleado(request);
    }
}
