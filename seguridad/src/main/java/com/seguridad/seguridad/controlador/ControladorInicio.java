package com.seguridad.seguridad.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorInicio {
    @GetMapping("/index")
    public String verVistaIndex() {
        return "index";
    }
    @GetMapping("/seguridad")
    public String verVistaSeguridad() {
        return "seguridad";
    }
}
