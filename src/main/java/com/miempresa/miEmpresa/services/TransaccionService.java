package com.miempresa.miEmpresa.services;

import com.miempresa.miEmpresa.entities.Transaccion;
import com.miempresa.miEmpresa.repository.InterfaceTransaccion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TransaccionService {

    private InterfaceTransaccion transaccionRepository;

    public TransaccionService(InterfaceTransaccion rep){
        this.transaccionRepository = rep;
    }

    // Buscar todas las transacciones
    public ArrayList<Transaccion> selectAll(){
        return (ArrayList<Transaccion>) this.transaccionRepository.findAll();
    }

    // Buscar transaccion por id
    public Transaccion selectById(int id){
        Optional<Transaccion> exists = this.transaccionRepository.findById(id);
        if (exists.isPresent()){
            return exists.get();
        }
        else{
            return null;
        }
    }

    // Crear transaccion
    public Response createTransaccion(Transaccion data){
        Response response = new Response();
        this.transaccionRepository.save(data);
        response.setCode(200);
        response.setMessage("transaccion registrada correctamente");
        return response;
    }

    // Eliminar transaccion
    public Response deleteTransaccionById(int id){
        Response response = new Response();
        try{
            this.transaccionRepository.deleteById(id);
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
