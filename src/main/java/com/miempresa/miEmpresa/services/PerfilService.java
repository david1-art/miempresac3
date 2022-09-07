package com.miempresa.miEmpresa.services;

import com.miempresa.miEmpresa.entities.Perfil;
import com.miempresa.miEmpresa.repository.InterfacePerfil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PerfilService {

    private InterfacePerfil perfilRepository;
    public PerfilService(InterfacePerfil rep){
        this.perfilRepository = rep;
    }

    // Buscar todos los perfiles
    public ArrayList<Perfil> selectAll(){
        return (ArrayList<Perfil>) this.perfilRepository.findAll();
    }

    // Buscar perfil por id
    public Perfil selectById(int id){
        Optional<Perfil> exists = this.perfilRepository.findById(id);
        if (exists.isPresent()){
            return exists.get();
        }
        else{
            return null;
        }
    }

    // Crear un perfil
    public Response createPerfil(Perfil data){
        Response response = new Response();
        this.perfilRepository.save(data);
        response.setCode(200);
        response.setMessage("perfil registrado correctamente");
        return response;
    }

    // Eliminar un perfil
    public Response deletePerfilById(int id){
        Response response = new Response();
        try{
            this.perfilRepository.deleteById(id);
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

    // Actualizar perfil
    public Response actualizarPerfil (Perfil data){
        Response response = new Response();
        if(data.getId() == 0){
            response.setCode(500);
            response.setMessage("Error, el Id del perfil no es valido" );
            return response;
        }
        // Validar si el usuario existe
        Perfil exists = selectById(data.getId());
        if(exists == null){
            response.setCode(500);
            response.setMessage("Error, el perfil no existe en la base de datos");
            return response;
        }
        // Validar imagen
        if (data.getImagen().equals(null) || data.getImagen().equals("")){
            response.setCode(500);
            response.setMessage("Error, imagen no especificada");
            return response;
        }
        // Validar numero telefono
        if (data.getNumeroTelefono().equals(null) || data.getNumeroTelefono().equals("")){
            response.setCode(500);
            response.setMessage("Error, imagen no especificada");
            return response;
        }
        // Validar fecha creado
        if (data.getFechaCreado().equals(null) || data.getFechaCreado().equals("")){
            response.setCode(500);
            response.setMessage("Error, imagen no especificada");
            return response;
        }
        // Validar fecha actualizado
        if (data.getFechaActualizado().equals(null) || data.getFechaActualizado().equals("")){
            response.setCode(500);
            response.setMessage("Error, imagen no especificada");
            return response;
        }
        // Actualizar datos
        exists.setImagen(data.getImagen());
        exists.setNumeroTelefono(data.getNumeroTelefono());
        exists.setFechaCreado(data.getFechaCreado());
        exists.setFechaActualizado(data.getFechaActualizado());

        this.perfilRepository.save(exists);
        response.setCode(200);
        response.setMessage("Perfil modificado crectamente");
        return response;
    }
}
