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

    // Actualizar transaccion
    public Response actualizarTransaccion(Transaccion data){
        Response response = new Response();
        if(data.getId() == 0){
            response.setCode(500);
            response.setMessage("Error, el Id de la transaccion no es valido" );
            return response;
        }
        // Validar si la transaccion existe
        Transaccion exists = selectById(data.getId());
        if(exists == null){
            response.setCode(500);
            response.setMessage("Error, la transaccion no existe en la base de datos");
            return response;
        }
        // Validar concepto
        if (data.getConcepto().equals(null) || data.getConcepto().equals("")){
            response.setCode(500);
            response.setMessage("Error, concepto no especificado");
            return response;
        }
        // Validar monto
        if (data.getMonto().equals(null) || data.getMonto().equals("")){
            response.setCode(500);
            response.setMessage("Error, concepto no especificado");
            return response;
        }
        // Validar fecha creado
        if (data.getFechaCreado().equals(null) || data.getFechaCreado().equals("")){
            response.setCode(500);
            response.setMessage("Error, concepto no especificado");
            return response;
        }
        // Validar fecha Actualizado
        if (data.getFechaActualizado().equals(null) || data.getFechaActualizado().equals("")){
            response.setCode(500);
            response.setMessage("Error, concepto no especificado");
            return response;
        }
        // Actualizar datos
        exists.setConcepto(data.getConcepto());
        exists.setMonto(data.getMonto());
        exists.setFechaCreado(data.getFechaCreado());
        exists.setFechaActualizado(data.getFechaActualizado());

        this.transaccionRepository.save(exists);
        response.setCode(200);
        response.setMessage("Usuario modificado crectamente");
        return response;
    }
}
