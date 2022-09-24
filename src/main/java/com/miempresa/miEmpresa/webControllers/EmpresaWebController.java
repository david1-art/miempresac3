package com.miempresa.miEmpresa.webControllers;

import com.miempresa.miEmpresa.dto.CreateEmpresaDTO;
import com.miempresa.miEmpresa.entities.Empresa;
import com.miempresa.miEmpresa.entities.Transaccion;
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
@RequestMapping("empresa")
public class EmpresaWebController {

    private EmpresaService empresaService;
    private TransaccionService transaccionService;
    public EmpresaWebController(EmpresaService service, TransaccionService traservice) {
        this.empresaService = service;
        this.transaccionService = traservice;
    }

    @GetMapping("listempresa")
    public String listEmpresa(Model empresas, Model transacciones) {
        // Consultar las empresas en BD por medio de la logica de negocio
        ArrayList<Empresa> empresasDB = this.empresaService.selectAll();
        ArrayList<Transaccion> trasaccionesDB = this.transaccionService.selectAll();
        // Armar el modelo que se pasa a thymeleaf
        empresas.addAttribute("misempresas", empresasDB);
        transacciones.addAttribute("mistransacciones", trasaccionesDB);
        return "empresa/listempresa";
    }

    @GetMapping("createempresa")
    public String create() {
        return "empresa/createempresa";
    }

    @PostMapping("createempresa")
    public RedirectView createempresa(CreateEmpresaDTO data) {
        Empresa empresa = new Empresa();
        empresa.setNombreEmpresa(data.getNombreEmpresa());
        empresa.setDireccionEmpresa(data.getDireccionEmpresa());
        empresa.setTelefonoEmpresa(data.getTelefonoEmpresa());
        empresa.setDocumentoEmpresa(data.getDocumentoEmpresa());
        empresa.setFechaCreado(data.getFechaCreado());
        empresa.setFechaModificado(data.getFechaModificado());

        Response response = this.empresaService.createEmpresa(empresa);
        return new RedirectView("/empresa/listempresa");
    }
}