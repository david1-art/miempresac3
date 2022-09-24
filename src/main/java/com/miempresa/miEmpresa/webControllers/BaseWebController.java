package com.miempresa.miEmpresa.webControllers;

import com.miempresa.miEmpresa.entities.Empleado;
import com.miempresa.miEmpresa.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

@Controller
public class BaseWebController {

    @Autowired
    protected EmpleadoService empleadoService;

    protected Empleado seguridad(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Empleado empleado = this.empleadoService.selectByUserName(currentPrincipalName);
        return empleado;
    }

}
