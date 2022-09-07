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

    // Actualizar empresa
    public Response actualizarEmpresa (Empresa data){
        Response response = new Response();
        if(data.getId() == 0){
            response.setCode(500);
            response.setMessage("Error, el Id de la Empresa no es valido" );
            return response;
        }
        // Validar si la empresa existe
        Empresa exists = selectById(data.getId());
        if(exists == null){
            response.setCode(500);
            response.setMessage("Error, la empresa no existe en la base de datos");
            return response;
        }
        // Validar nombre de empresa
        if (data.getNombreEmpresa().equals(null) || data.getNombreEmpresa().equals("")){
            response.setCode(500);
            response.setMessage("Error, nombre de empresa no especificado");
            return response;
        }

        // Validar documento de empresa
        if (data.getDocumentoEmpresa().equals(null) || data.getDocumentoEmpresa().equals("")){
            response.setCode(500);
            response.setMessage("Error, documento de empresa no especificado");
            return response;
        }

        // Validar telefono de empresa
        if (data.getTelefonoEmpresa().equals(null) || data.getTelefonoEmpresa().equals("")){
            response.setCode(500);
            response.setMessage("Error, telefono de empresa no especificado");
            return response;
        }

        // Validar direccion de empresa
        if (data.getDireccionEmpresa().equals(null) || data.getDireccionEmpresa().equals("")){
            response.setCode(500);
            response.setMessage("Error, telefono de empresa no especificado");
            return response;
        }

        // Validar transacciones de empresa
        if (data.getTransacciones().equals(null) || data.getTransacciones().equals("")){
            response.setCode(500);
            response.setMessage("Error, telefono de empresa no especificado");
            return response;
        }

        // Validar fecha creado
        if (data.getFechaCreado().equals(null) || data.getFechaCreado().equals("")){
            response.setCode(500);
            response.setMessage("Error, telefono de empresa no especificado");
            return response;
        }

        // Validar fecha modificado
        if (data.getFechaModificado().equals(null) || data.getFechaModificado().equals("")){
            response.setCode(500);
            response.setMessage("Error, telefono de empresa no especificado");
            return response;
        }

        // Actualizar datos
        exists.setNombreEmpresa(data.getNombreEmpresa());
        exists.setDocumentoEmpresa(data.getDocumentoEmpresa());
        exists.setTelefonoEmpresa(data.getTelefonoEmpresa());
        exists.setDireccionEmpresa(data.getDireccionEmpresa());
        exists.setTransacciones(data.getTransacciones());
        exists.setFechaCreado(data.getFechaCreado());
        exists.setFechaModificado(data.getFechaModificado());

        this.empresaRepository.save(exists);
        response.setCode(200);
        response.setMessage("Empresa modificada crectamente");
        return response;

    }
}
