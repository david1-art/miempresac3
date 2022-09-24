package com.miempresa.miEmpresa.webControllers;

import com.miempresa.miEmpresa.dto.LoginDTO;
import com.miempresa.miEmpresa.dto.RegistroDTO;
import com.miempresa.miEmpresa.entities.Empleado;
import com.miempresa.miEmpresa.services.EmpleadoService;
import com.miempresa.miEmpresa.services.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("login")
public class LoginWebController {

    public EmpleadoService service;
    public LoginWebController(EmpleadoService service){
        this.service = service;
    }

    @GetMapping("login")
    public String login(){
        return "/login/login";
    }

    @GetMapping("registro")
    public String registro(){
        return "/login/registro";
    }

    @PostMapping("postlogin")
    public RedirectView postlogin(LoginDTO data){
        Empleado empleado = new Empleado();
        empleado.setCorreoElectronico(data.getCorreoElectronico());
        empleado.setContraseña(data.getContraseña());
        Response response = this.service.loginEmpleado(empleado);
        if (response.getCode() == 200){
            return new RedirectView("/index");
        }
        else {
            return new RedirectView("/login/error");
        }
    }

    @PostMapping("postregistro")
    public RedirectView postregistro(RegistroDTO data){
        if (data.getContraseña().equals(null) || data.getContraseña().equals("")){
            return new RedirectView("/login/error");
        }
        if (!data.getContraseña().equals(data.getValidaContraseña())){
            return new RedirectView("/login/error");
        }
        Empleado empleado = new Empleado();
        empleado.setCorreoElectronico(data.getCorreoElectronico());
        empleado.setContraseña(data.getContraseña());

        Response response = this.service.createEmpleado(empleado);
        if (response.getCode() == 200){
            return new RedirectView("/index");
        }
        else {
            return new RedirectView("/login/error");
        }
    }

    @GetMapping("error")
    public String error(){
        return "/error/credenciales";
    }
}
