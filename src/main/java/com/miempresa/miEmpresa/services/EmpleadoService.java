package com.miempresa.miEmpresa.services;

import com.miempresa.miEmpresa.entities.Empleado;
import com.miempresa.miEmpresa.repository.InterfaceEmpleado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmpleadoService {

    private InterfaceEmpleado empleadoRepository;

    public EmpleadoService(InterfaceEmpleado rep){
        this.empleadoRepository = rep;
    }

    // Buscar todos los empleados
    public ArrayList<Empleado> selectAll(){
        return (ArrayList<Empleado>) this.empleadoRepository.findAll();
    }

    // Buscar Empleado por id
    public Empleado selectById(int id){
        Optional<Empleado> exists = this.empleadoRepository.findById(id);
        if (exists.isPresent()){
            return exists.get();
        }
        else {
            return null;
        }
    }

    // Crear un empleado
    public Response createEmpleado(Empleado data){
        Response response = new Response();
        // Validar correo
        if(!validarCorreoElectronico(data.getCorreoElectronico())){
            response.setCode(500);
            response.setMessage("Error, el correo dado no es válido.");
            return  response;
        }

        //validar password -- aun no tenemos la casilla de password
        /*if (data.getPassword().equals(null) && data.getPassword().equals("")) {
            response.setCode(500);
            response.setMessage("Contraseña incorrecta");
            return response;
        }*/

        // Validar que no se repita el correo
        /*ArrayList<Empleado> exists = this.empleadoRepository.validarCorreo(data.getCorreoElectronico());
        if (exists != null && exists.size() > 0){
            response.setCode(500);
            response.setMessage("el correo ya esta en uso");
            return response;
        }*/

        this.empleadoRepository.save(data);
        response.setCode(200);
        response.setMessage("empleado registrado correctamente");
        return response;
    }

    // Eliminar un empleado
    public Response deleteEmpleadoById(int id){
        Response response = new Response();
        try {
            this.empleadoRepository.deleteById(id);
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

    // Validar que si sea un correo electronico
    public boolean validarCorreoElectronico(String correo) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher =emailPat.matcher(correo);
        return matcher.find();
    }
}
