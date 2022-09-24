package com.miempresa.miEmpresa.webControllers;

import com.miempresa.miEmpresa.dto.CreateTransaccionDTO;
import com.miempresa.miEmpresa.entities.Empleado;
import com.miempresa.miEmpresa.entities.Empresa;
import com.miempresa.miEmpresa.entities.Transaccion;
import com.miempresa.miEmpresa.services.EmpleadoService;
import com.miempresa.miEmpresa.services.EmpresaService;
import com.miempresa.miEmpresa.services.Response;
import com.miempresa.miEmpresa.services.TransaccionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
@RequestMapping("transaccion")
public class TransaccionWebController {

    private TransaccionService transaccionService;
    private EmpresaService empresaService;
    private EmpleadoService empleadoService;
    public TransaccionWebController(TransaccionService service, EmpresaService empservice, EmpleadoService emplservice){
        this.transaccionService = service;
        this.empresaService = empservice;
        this.empleadoService = emplservice;
    }

    @GetMapping("listtransaccion")
    public String listTransaccion(Model transacciones){
        ArrayList<Transaccion> transaccionesBD = this.transaccionService.selectAll();
        transacciones.addAttribute("mistransacciones", transaccionesBD);
        return "transaccion/listtransaccion";
    }

    @GetMapping("createtransaccion")
    public String create(Model empresas, Model empleados){
        ArrayList<Empresa> empresasDB = this.empresaService.selectAll();
        ArrayList<Empleado> empleadosDB = this.empleadoService.selectAll();
        empresas.addAttribute("misempresas", empresasDB);
        empleados.addAttribute("misempleados", empleadosDB);
        return "transaccion/createtransaccion";
    }

    @PostMapping("createtransaccion")
    public RedirectView createtransaccion(CreateTransaccionDTO data){
        Transaccion transaccion = new Transaccion();
        transaccion.setConcepto(data.getConcepto());
        transaccion.setMonto(data.getMonto());
        transaccion.setEmpresa(data.getEmpresa());
        transaccion.setEmpleado(data.getEmpleado());
        transaccion.setFechaCreado(data.getFechaCreado());
        transaccion.setFechaActualizado(data.getFechaCreado());

        Response response = this.transaccionService.createTransaccion(transaccion);
        return new RedirectView("/transaccion/listtransaccion");
    }
}