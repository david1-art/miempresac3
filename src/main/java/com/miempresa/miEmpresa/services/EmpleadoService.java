package com.miempresa.miEmpresa.services;

import com.miempresa.miEmpresa.entities.Empleado;
import com.miempresa.miEmpresa.repository.InterfaceEmpleado;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    // buscar por correo Electronico
    public Empleado selectByUserName (String username){
        Empleado exists = this.empleadoRepository.findByUserName(username);
        return exists;
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

        // validar password -- aun no tenemos la casilla de password
        if (data.getContraseña().equals(null) && data.getContraseña().equals("")) {
            response.setCode(500);
            response.setMessage("Contraseña incorrecta");
            return response;
        }

        // Validar que no se repita el correo
        ArrayList<Empleado> exists = this.empleadoRepository.validarCorreoEmpleado(data.getCorreoElectronico());
        if (exists != null && exists.size() > 0){
            response.setCode(500);
            response.setMessage("el correo ya esta en uso");
            return response;
        }

        // Encriptar contraseña
        BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();
        data.setContraseña(encrypt.encode(data.getContraseña()));

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

    // Actualizar empleado
    public Response actualizarEmpleado (Empleado data){
        Response response = new Response();
        // validar id de empleado
        if(data.getId() == 0){
            response.setCode(500);
            response.setMessage("Error, el Id del empleado no es valido" );
            return response;
        }
        // Validar si el empleado existe
        Empleado exists = selectById(data.getId());
        if(exists == null){
            response.setCode(500);
            response.setMessage("Error, el empleado no existe en la base de datos");
            return response;
        }
        // validar correo electronico
        if (data.getCorreoElectronico().equals(null) || data.getCorreoElectronico().equals("")){
            response.setCode(500);
            response.setMessage("Error, Correo no especificado");
            return response;
        }
        // validar perfil
        if (data.getPerfil().equals(null) || data.getPerfil().equals("")){
            response.setCode(500);
            response.setMessage("Error, Perfil no especificado");
            return response;
        }
        // validar rol
        if (data.getRol().equals(null) || data.getRol().equals("")){
            response.setCode(500);
            response.setMessage("Error, Rol no especificado");
            return response;
        }
        // validar empresa
        if (data.getEmpresa().equals(null) || data.getEmpresa().equals("")){
            response.setCode(500);
            response.setMessage("Error, Empresa no especificada");
            return response;
        }
        // validar transacciones
        if (data.getTransacciones().equals(null) || data.getTransacciones().equals("")){
            response.setCode(500);
            response.setMessage("Error, Rol no especificado");
            return response;
        }
        // validar fecha creado
        if (data.getFechaCreado().equals(null) || data.getFechaCreado().equals("")){
            response.setCode(500);
            response.setMessage("Error, Rol no especificado");
            return response;
        }
        // validar fecha actualizado
        if (data.getFechaActualizado().equals(null) || data.getFechaActualizado().equals("")){
            response.setCode(500);
            response.setMessage("Error, Rol no especificado");
            return response;
        }

        // Actualizar datos
        exists.setCorreoElectronico(data.getCorreoElectronico());
        exists.setPerfil(data.getPerfil());
        exists.setRol(data.getRol());
        exists.setEmpresa(data.getEmpresa());
        exists.setTransacciones(data.getTransacciones());
        exists.setFechaCreado(data.getFechaCreado());
        exists.setFechaActualizado(data.getFechaActualizado());

        this.empleadoRepository.save(exists);
        response.setCode(200);
        response.setMessage("Usuario modificado crectamente");
        return response;
    }

    public Response actualizarEmpleadoDTO (Empleado data){
        Response response = new Response();
        // validar id de empleado
        if(data.getId() == 0){
            response.setCode(500);
            response.setMessage("Error, el Id del empleado no es valido" );
            return response;
        }
        // Validar si el empleado existe
        Empleado exists = selectById(data.getId());
        if(exists == null){
            response.setCode(500);
            response.setMessage("Error, el empleado no existe en la base de datos");
            return response;
        }
        // validar perfil
        if (data.getPerfil().equals(null) || data.getPerfil().equals("")){
            response.setCode(500);
            response.setMessage("Error, Perfil no especificado");
            return response;
        }
        // validar rol
        if (data.getRol().equals(null) || data.getRol().equals("")){
            response.setCode(500);
            response.setMessage("Error, Rol no especificado");
            return response;
        }
        // validar empresa
        if (data.getEmpresa().equals(null) || data.getEmpresa().equals("")){
            response.setCode(500);
            response.setMessage("Error, Empresa no especificada");
            return response;
        }
        // validar transacciones
        if (data.getTransacciones().equals(null) || data.getTransacciones().equals("")){
            response.setCode(500);
            response.setMessage("Error, Rol no especificado");
            return response;
        }
        // validar fecha actualizado
        if (data.getFechaActualizado().equals(null) || data.getFechaActualizado().equals("")){
            response.setCode(500);
            response.setMessage("Error, Rol no especificado");
            return response;
        }

        // Actualizar datos
        exists.setPerfil(data.getPerfil());
        exists.setRol(data.getRol());
        exists.setEmpresa(data.getEmpresa());
        exists.setTransacciones(data.getTransacciones());
        exists.setFechaActualizado(data.getFechaActualizado());

        this.empleadoRepository.save(exists);
        response.setCode(200);
        response.setMessage("Usuario modificado crectamente");
        return response;
    }

    // Login

    public Response loginEmpleado(Empleado data){
        Response response = new Response();

        // Validar datos
        if (!validarCorreoElectronico(data.getCorreoElectronico())){
            response.setCode(500);
            response.setMessage("Error, correo / usuario no válido.");
        }

        // Validar contraseña
        if(data.getContraseña().equals(null) || data.getContraseña().equals("")){
            response.setCode(500);
            response.setMessage("Error, contraseña incorrecta.");
            return  response;
        }

        ArrayList<Empleado> exists = this.empleadoRepository.validarCredenciales(data.getCorreoElectronico(), data.getContraseña());
        if(exists != null && exists.size() > 0){
            response.setCode(200);
            response.setMessage("Usuario autenticado correctamente.");
            return  response;
        }

        response.setCode(500);
        response.setMessage("Error, sus datos de acceso no son correctos");
        return  response;
    }


}
