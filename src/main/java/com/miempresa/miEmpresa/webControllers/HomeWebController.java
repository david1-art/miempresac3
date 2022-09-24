package com.miempresa.miEmpresa.webControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeWebController extends BaseWebController {

    @GetMapping("index")
    public String index(Model data){
        data.addAttribute("usuarioautenticado", seguridad());
        return "home/index";
    }
}
