package com.seguridad.seguridad.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import com.seguridad.seguridad.modelo.Rol;
import com.seguridad.seguridad.servicio.ServicioRol;

@Controller
public class ControladorRol {

    private final ServicioRol rs;

    public ControladorRol(ServicioRol rs) {
        this.rs = rs;
    }

    @GetMapping("/rol")
    public String verVistaRol() {
        return "rol";
    }

    @GetMapping("/rol_agregar")
    public String agregarRol(Model modelo) {
        Rol rol = new Rol();
        rol.setNom_rol("");
        rol.setDes_rol("");
        rol.setEst_rol("");
        modelo.addAttribute("rol", rol);
        return "rol_agregar";
    }

    // Método para guardar los datos introducidos en el formulario
    @PostMapping("/rol_agregar")
    public String agregarRol(@ModelAttribute("rol") Rol rol, RedirectAttributes redirectAttrs) {
        try {
            rol.setNom_rol(rol.getNom_rol() != null ? rol.getNom_rol().trim() : "");
            rol.setDes_rol(rol.getDes_rol() != null ? rol.getDes_rol().trim() : "");
            rol.setEst_rol(rol.getEst_rol() != null ? rol.getEst_rol().toUpperCase() : "A");
            rs.agregarRol(rol);
            
            redirectAttrs.addFlashAttribute("mensaje", "exito");
        } catch (Exception e) {
            redirectAttrs.addFlashAttribute("mensaje", "error");
        }
        return "redirect:/rol_listar";
    }

    // Método para mostrar la vista con los datos del rol seleccionado para ver/editar[span_1](start_span)[span_1](end_span)
    @GetMapping("/rol_ver")
    public String buscarRol(@RequestParam("cod_rol") int cod_rol, Model modelo) {
        Rol rol = rs.buscarRol(cod_rol);
        modelo.addAttribute("rol", rol);
        return "rol_ver";
    }

    @GetMapping("/rol_listar")
    public String listarRoles(Model modelo) {
        List<Rol> roles = rs.listarRoles();
        modelo.addAttribute("roles", roles);
        return "rol_listar";
    }

    //Metodo para mostra la vista de editar rol con datos reales
    @GetMapping ("/rol_editar")
    public String editarRol (@org.springframework.web.bind.annotation.RequestParam("cod_rol") int cod_rol, Model modelo){
        Rol rol = rs.buscarRol(cod_rol);
        modelo.addAttribute("rol", rol);
        return "rol_editar";
    }
    @PostMapping ("/rol_editar")
    public String editarRol(@ModelAttribute("rol") Rol rol, RedirectAttributes redirectAttrs){
        try{
            rs.editarRol(rol);
            redirectAttrs.addFlashAttribute("Exito", "Rol editado correctamente");
        }catch (Exception e){
            redirectAttrs.addFlashAttribute("Error", "Error al editar el rol");
        }
        return "redirect:/rol_listar";
    }
    
  @GetMapping("/rol_eliminar")
    public String eliminarRol(@org.springframework.web.bind.annotation.RequestParam("cod_rol") int cod_rol, RedirectAttributes flash) {
        try {
            boolean eliminado = rs.eliminarRol(cod_rol);
            if (eliminado) {
               
                flash.addFlashAttribute("exito", "Rol eliminado correctamente"); 
            } else {
                
                flash.addFlashAttribute("error", "No se encontró el rol para eliminar"); 
            }
        } catch (Exception e) {
            
            flash.addFlashAttribute("error", "Error al eliminar el rol"); 
        }
        return "redirect:/rol_listar";
    }
}