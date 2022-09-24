package com.miempresa.miEmpresa.webControllers;

import com.miempresa.miEmpresa.dto.CreateEmpleadoDTO;
import com.miempresa.miEmpresa.dto.EditEmpleadoDTO;
import com.miempresa.miEmpresa.entities.Empleado;
import com.miempresa.miEmpresa.entities.Empresa;
import com.miempresa.miEmpresa.entities.Perfil;
import com.miempresa.miEmpresa.entities.Transaccion;
import com.miempresa.miEmpresa.enums.RoleName;
import com.miempresa.miEmpresa.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
@RequestMapping("empleado")
public class EmpleadoWebController {

    private EmpleadoService empleadoService;
    private EmpresaService empresaService;
    private PerfilService perfilService;
    private TransaccionService transaccionService;
    private RoleNameService roleNameService;

    public EmpleadoWebController(EmpleadoService service, EmpresaService empservice, PerfilService perservice, TransaccionService traservice, RoleNameService rolservice){
        this.empleadoService = service;
        this.empresaService = empservice;
        this.perfilService = perservice;
        this.transaccionService = traservice;
        this.roleNameService = rolservice;
    }

    @GetMapping("listempleado")
    public String listEmpleado(Model empleados){
        ArrayList<Empleado> empleadosDB = this.empleadoService.selectAll();
        empleados.addAttribute("misempleados", empleadosDB);
        return "empleado/listempleado";
    }

    @GetMapping("createempleado")
    public String create(Model empresas, Model perfiles){
        // Cargar Empresas desde logica de negocio
        ArrayList<Empresa> empresasBD = this.empresaService.selectAll();
        ArrayList<Perfil> perfilesBD = this.perfilService.selectAll();
        // Pasar informacion al model con thymeleaf
        empresas.addAttribute("misempresas", empresasBD);
        perfiles.addAttribute("misperfiles", perfilesBD);
        return "empleado/createempleado";
    }

    @PostMapping("createempleado")
    public RedirectView createempleado(CreateEmpleadoDTO data){
        if (data.getContraseña().equals(null) || data.getContraseña().equals("")){
            return new RedirectView("/login/error");
        }
        if (!data.getContraseña().equals(data.getValidaContraseña())){
            return new RedirectView("/login/error");
        }
        Empleado empleado = new Empleado();
        empleado.setEmpresa(data.getEmpresa());
        empleado.setPerfil(data.getPerfil());
        empleado.setCorreoElectronico(data.getCorreoElectronico());
        empleado.setContraseña(data.getContraseña());
        empleado.setFechaCreado(data.getFechaCreado());
        empleado.setFechaActualizado(data.getFechaActualizado());

        Response response = this.empleadoService.createEmpleado(empleado);
        return new RedirectView("/empleado/listempleado");
    }

    @GetMapping("editempleado/{id}")
    public String editempleado(@PathVariable int id, Model data, Model empleados){
        Empleado empleadoinfo = this.empleadoService.selectById(id);
        data.addAttribute("empleado", empleadoinfo);

        ArrayList<Empresa> empresas = empresaService.selectAll();
        data.addAttribute("misempresas", empresas);

        ArrayList<Perfil> perfiles = perfilService.selectAll();
        data.addAttribute("misperfiles", perfiles);

        ArrayList<Transaccion> transacciones = transaccionService.selectAll();
        data.addAttribute("mistransacciones", transacciones);

        ArrayList<RoleName> roles = roleNameService.selectAll();
        data.addAttribute("misroles", roles);

        return "/empleado/editempleado";
    }

    @PostMapping("editempleadopost")
    public RedirectView editempleadopost(EditEmpleadoDTO data){
        Empleado empleado = new Empleado();
        empleado.setId(data.getId());
        empleado.setEmpresa(data.getEmpresa());
        empleado.setPerfil(data.getPerfil());
        empleado.setRol(data.getRol());
        empleado.setTransacciones(data.getTransacciones());
        empleado.setFechaActualizado(data.getFechaActualizado());

        Response response = this.empleadoService.actualizarEmpleado(empleado);

        return new RedirectView("/empleado/listempleado");
    }




}