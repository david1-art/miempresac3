package com.miempresa.miEmpresa.services;

import com.miempresa.miEmpresa.entities.Empresa;
import com.miempresa.miEmpresa.repository.InterfaceEmpresa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmpresaService {

    private InterfaceEmpresa empresaRepository;

    public EmpresaService(InterfaceEmpresa rep){
        this.empresaRepository = rep;
    }

    // Buscar todas las empresas
    public ArrayList<Empresa> selectAll() {
        return (ArrayList<Empresa>) this.empresaRepository.findAll();
    }

    // Buscar empresa por id
    public Empresa selectById(int id){
        Optional<Empresa> exists = this.empresaRepository.findById(id);
        if (exists.isPresent()){
            return exists.get();
        }
        else{
            return null;
        }
    }

    // Crear una empresa
    public Response createEmpresa(Empresa data){
        Response response = new Response();
        // Validar nombre
        ArrayList<Empresa> existsNombre = this.empresaRepository.validarNombreEmpresa(data.getNombreEmpresa());
        if(existsNombre != null && existsNombre.size() > 0){
            response.setCode(500);
            response.setMessage("Nombre de empresa ya esta registrado");
            return response;
        }
        // Validar documento
        ArrayList<Empresa> existsDocumento = this.empresaRepository.validarDocumentoEmpresa(data.getDocumentoEmpresa());
        if(existsDocumento != null && existsDocumento.size() > 0){
            response.setCode(500);
            response.setMessage("Nombre de empresa ya esta registrado");
            return response;
        }
        this.empresaRepository.save(data);
        response.setCode(200);
        response.setMessage("empresa registrada correctamente");
        return response;
    }

    // Eliminar una empresa
    public Response deleteEmpresaById(int id){
        Response response = new Response();
        try{
            this.empresaRepository.deleteById(id);
            response.setCode(200);
            response.setMessage("usuario eliminado correctamente");
            return response;
        }
        catch (Exception ex){
            response.setCode(500);
            response.setMessage("Error " + ex.getMessage());
            return response;
        }
    }
}
