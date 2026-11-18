package com.seguridad.seguridad.controlador;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.seguridad.seguridad.modelo.TipoPrivacidad;

import com.seguridad.seguridad.servicio.ServicioTipoPrivacidad;

@Controller 
public class ControladorTipoPrivacidad {

    private final ServicioTipoPrivacidad tp;

    public ControladorTipoPrivacidad(ServicioTipoPrivacidad tp) {
        this.tp = tp;
    }


    @GetMapping("/tipo_privacidad")
    public String verVistaTipoPrivacidad(){
        return "tipo_privacidad";
    }


    @GetMapping("/tipo_privacidad_listar")
    public String listarTipoPrivacidad(Model modelo) {
        List <TipoPrivacidad> tipos = tp.listarTipos();
        modelo.addAttribute("tipos",tipos);
        return "tipo_privacidad_listar";
    }


    @GetMapping("/tipo_privacidad_agregar")
    public String agregarTipoPrivacidad(Model modelo) {
        TipoPrivacidad tipopriv = new TipoPrivacidad();
        tipopriv.setNom_tip("");
        tipopriv.setEst_tip("");
        modelo.addAttribute("tipopriv", tipopriv);
        return "tipo_privacidad_agregar";
    }

    @PostMapping("/tipo_privacidad_agregar")
    public String agregarTipoPrivacidad(@ModelAttribute("tipopriv") TipoPrivacidad tipopriv, RedirectAttributes redirectAttrs) {
        try{
            tipopriv.setNom_tip(tipopriv.getNom_tip() != null ? tipopriv.getNom_tip().trim() : "");
            tipopriv.setEst_tip(tipopriv.getEst_tip() != null ? tipopriv.getEst_tip().toUpperCase() : "A");
            tp.agregarTipoPrivacidad(tipopriv);
            redirectAttrs.addFlashAttribute("exito", "¡Tipo creado correctamente!");
        }catch (Exception e) {
            redirectAttrs.addFlashAttribute("error", "Error al crear el tipo:" + e.getMessage());
        }
        return "redirect:/tipo_privacidad_listar";
    }

    @GetMapping("/tipo_privacidad_ver")
    public String buscarTipoPrivacidad(@RequestParam("cod_tip") int codTip, Model modelo,
            RedirectAttributes redirectAttrs) {
        TipoPrivacidad tipo = tp.buscarTipoPrivacidad(codTip);
        if (tipo == null) {
            redirectAttrs.addFlashAttribute("error", "El tipo de privacidad no existe.");
            return "redirect:/tipo_privacidad_listar";
        }
        modelo.addAttribute("tipopriv", tipo);
        return "tipo_privacidad_ver";
    }

    @GetMapping("/tipo_privacidad_editar")
    public String editarTipoPrivacidad(@RequestParam("cod_tip") int codTip, Model modelo,
            RedirectAttributes redirectAttrs) {
        TipoPrivacidad tipo = tp.buscarTipoPrivacidad(codTip);
        if (tipo == null) {
            redirectAttrs.addFlashAttribute("error", "El tipo de privacidad no existe.");
            return "redirect:/tipo_privacidad_listar";
        }
        modelo.addAttribute("tipopriv", tipo);
        return "tipo_privacidad_editar";
    }

    @PostMapping("/tipo_privacidad_editar")
    public String editarTipoPrivacidad(@ModelAttribute("tipopriv") TipoPrivacidad tipopriv,
            RedirectAttributes redirectAttrs) {
        try {
            tipopriv.setNom_tip(tipopriv.getNom_tip() != null ? tipopriv.getNom_tip().trim() : "");
            tipopriv.setEst_tip(tipopriv.getEst_tip() != null ? tipopriv.getEst_tip().trim().toUpperCase() : "A");
            tp.editarTipoPrivacidad(tipopriv);
            redirectAttrs.addFlashAttribute("exito", "Tipo de privacidad modificado correctamente.");
        } catch (Exception e) {
            redirectAttrs.addFlashAttribute("error", "Error al modificar el tipo: " + e.getMessage());
        }
        return "redirect:/tipo_privacidad_listar";
    }

    @GetMapping("/tipo_privacidad_eliminar")
    public String eliminarTipoPrivacidad(@RequestParam("cod_tip") int codTip,
            RedirectAttributes redirectAttrs) {
        try {
            if (tp.eliminarTipoPrivacidad(codTip)) {
                redirectAttrs.addFlashAttribute("exito", "Tipo de privacidad eliminado correctamente.");
            } else {
                redirectAttrs.addFlashAttribute("error", "El tipo de privacidad no existe.");
            }
        } catch (Exception e) {
            redirectAttrs.addFlashAttribute("error", "No se pudo eliminar el tipo: " + e.getMessage());
        }
        return "redirect:/tipo_privacidad_listar";
    }
}