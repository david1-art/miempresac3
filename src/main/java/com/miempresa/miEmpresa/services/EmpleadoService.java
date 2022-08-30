package com.miempresa.miEmpresa.services;

import com.miempresa.miEmpresa.entities.EmpleadoModel;
import com.miempresa.miEmpresa.repository.InterfaceEmpleado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmpleadoService {

    private InterfaceEmpleado empleadoRepository;

    public EmpleadoService(InterfaceEmpleado rep){
        this.empleadoRepository = rep;
    }

    public ArrayList<EmpleadoModel> selectAll(){
        return (ArrayList<EmpleadoModel>) this.empleadoRepository.findAll();
    }

    public Response createEmpleado(EmpleadoModel data){
        Response response = new Response();
        this.empleadoRepository.save(data);
        response.setCode(200);
        response.setMessage("empleado registrado correctamente");
        return response;
    }
}