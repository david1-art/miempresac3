package com.miempresa.miEmpresa.webControllers;

import com.miempresa.miEmpresa.dto.CreatePerfilDTO;
import com.miempresa.miEmpresa.entities.Perfil;
import com.miempresa.miEmpresa.services.PerfilService;
import com.miempresa.miEmpresa.services.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
@RequestMapping("perfil")
public class PerfilWebController {

    private PerfilService perfilService;
    public PerfilWebController(PerfilService service) {
        this.perfilService = service;
    }

    @GetMapping("listperfil")
    public String listPerfil(Model perfiles) {
        ArrayList<Perfil> perfilesDB = this.perfilService.selectAll();
        perfiles.addAttribute("misperfiles", perfilesDB);
        return "perfil/listperfil";
    }

    @GetMapping("createperfil")
    public String cretae() {
        return "perfil/createperfil";
    }


    @PostMapping("createperfil")
    public RedirectView createperfil(CreatePerfilDTO data) {
        Perfil perfil = new Perfil();
        perfil.setImagen(data.getImagen());
        perfil.setNumeroTelefono(data.getNumeroTelefono());
        perfil.setFechaCreado(data.getFechaCreado());
        perfil.setFechaActualizado(data.getFechaActualizado());

        Response response = this.perfilService.createPerfil(perfil);
        return new RedirectView("/perfil/listperfil");
    }
}