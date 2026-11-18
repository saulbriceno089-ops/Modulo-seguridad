package com.seguridad.seguridad.controlador;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.seguridad.seguridad.modelo.RolFanPage;
import com.seguridad.seguridad.servicio.ServicioFanPage;
import com.seguridad.seguridad.servicio.ServicioPersona;
import com.seguridad.seguridad.servicio.ServicioRol;
import com.seguridad.seguridad.servicio.ServicioRolFanPage;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.seguridad.seguridad.modelo.FanPage;
import com.seguridad.seguridad.modelo.Persona;
import com.seguridad.seguridad.modelo.Rol;

@Controller 
public class ControladorRolFanPage {
    private final ServicioPersona persona;
    private final ServicioFanPage fanpage;
    private final ServicioRol rol;
    private final ServicioRolFanPage rfp;
    
    
    public ControladorRolFanPage(ServicioPersona persona, ServicioFanPage fanpage, ServicioRol rol,
            ServicioRolFanPage rfp) {
        this.persona = persona;
        this.fanpage = fanpage;
        this.rol = rol;
        this.rfp = rfp;
    }

    //Realiza el llamado o la invocacion a la vista inicial de RolFanPage
    @GetMapping("/rol_fan_page")
    public String VerVistaRolFanPage() {
        return "rol_fan_page"; 
    }

    //Listar todos los roles de fan page
    @GetMapping("/rol_fan_page_listar")
    public String listarRolFanPage(Model modelo) {
        List<RolFanPage> rolfanpages = rfp.listarRolFanPage();
        modelo.addAttribute("rolfanpages", rolfanpages);
        return "rol_fan_page_listar";
    }

    //Realiza el llamado o la invocacion a la vista de agregar un nuevo rol de fan page, diferente el tipo de tabla que estamos trabjando
    @GetMapping("/rol_fan_page_agregar")
    public String verAgregarRolFanPage(Model modelo) {
        //Crea un objeto vacio de tipo RolFanPage y lo añade al modelo con el nombre "rolfanpage", este objeto se utiliza para hacer un enlace de datos que permita que los campos del formulario de la vista agregar "form th:object="${rolfanpage}" recojan los datos que el usuario escriba o seleccione."
        modelo.addAttribute("rolfanpage", new RolFanPage());

        //Llama al servicio de personapara obtener una lista de todas las personas registradaas en el sistema y las guarda con el nombre de "personas".
        modelo.addAttribute("personas", persona.listarPersonas());

        //Llama  al servicio de fanpage para obtener una lista de todos los fanpages registrados en el sistema y los guarda con el nombre "fanpages".
        modelo.addAttribute("fanpages", fanpage.listarFanPage());

        //Llama al servicio de roles para obtener una lista de todos los roles registrados en el sistema y los guarda con el nombre "roles".
        modelo.addAttribute("roles", rol.listarRoles());
        //Despues de cargar todas las listas, retorna a la vista de agregar
        return "rol_fan_page_agregar";
    }

    //Para enviar la el nuevo rol fan page registrado en la vista de agregar
    //Guardar nuevo rol fan page con limpieza de datos y manejo de errores
    @PostMapping("/rol_fan_page_agregar")
    public String agregarRolFanPage(
            @RequestParam("persona") int codPersona,
            @RequestParam("fan_page") int codFanPage,
            @RequestParam("rol") int codRol,
            @RequestParam("est_rol_fan") String estatus,
            RedirectAttributes redirectAttrs) {
        try{
            RolFanPage rolfanpage = new RolFanPage();
            rolfanpage.setPersona(new Persona(codPersona));
            rolfanpage.setFan_page(new FanPage(codFanPage));
            rolfanpage.setRol(new Rol(codRol));
            rolfanpage.setEst_rol_fan(estatus != null ? estatus.trim().toUpperCase() : "A");
            rfp.agregarRolFanPage(rolfanpage);
            redirectAttrs.addFlashAttribute("exito", "Rol Fan Page creado exitosamente");
        } catch (Exception e) {
            redirectAttrs.addFlashAttribute("error", "Error al crear el Rol Fan Page: " + e.getMessage());
        }
        return "redirect:/rol_fan_page_listar";
    }
    
    @GetMapping("/rol_fan_page_ver")
    public String verDetalleRolFanPage(@RequestParam ("cod_rol_fan") int cod_rol_fan, Model modelo, RedirectAttributes redirectAttrs) {
        RolFanPage rolfanpage = rfp.buscarRolFanPage(cod_rol_fan);
        if (rolfanpage == null){
            redirectAttrs.addFlashAttribute("error", "Rol Fan Page solicitado no existe");
            return "redirect:/rol_fan_page_listar";
        }
        modelo.addAttribute("rolfanpage", rolfanpage);
        return "rol_fan_page_ver";
    }

    @GetMapping("/rol_fan_page_editar")
    public String editarRolFanPage(@RequestParam ("cod_rol_fan") int cod_rol_fan, Model modelo, RedirectAttributes redirectAttrs) {
        RolFanPage rolfanpage = rfp.buscarRolFanPage(cod_rol_fan);
        if(rolfanpage == null){
            redirectAttrs.addFlashAttribute("error", "Rol Fan Page que intentas editar no existe");
            return "redirect:/rol_fan_page_listar";
        }
        modelo.addAttribute("rolfanpage", rolfanpage);
        modelo.addAttribute("personas", persona.listarPersonas());
        modelo.addAttribute("fanpages", fanpage.listarFanPage());
        modelo.addAttribute("roles", rol.listarRoles());
        return "rol_fan_page_editar";
    }

    @PostMapping("/rol_fan_page_editar")
    public String editarRolFanPage(
            @RequestParam("cod_rol_fan") int codRolFanPage,
            @RequestParam("persona") int codPersona,
            @RequestParam("fan_page") int codFanPage,
            @RequestParam("rol") int codRol,
            @RequestParam("est_rol_fan") String estatus,
            RedirectAttributes redirectAttrs) {
        try {
            RolFanPage rolfanpage = new RolFanPage();
            rolfanpage.setCod_rol_fan(codRolFanPage);
            rolfanpage.setPersona(new Persona(codPersona));
            rolfanpage.setFan_page(new FanPage(codFanPage));
            rolfanpage.setRol(new Rol(codRol));
            rolfanpage.setEst_rol_fan(estatus != null ? estatus.trim().toUpperCase() : "A");
            rfp.editarRolFanPage(rolfanpage);
            redirectAttrs.addFlashAttribute("exito", "Rol Fan Page modificado exitosamente");
        } catch (Exception e) {
            redirectAttrs.addFlashAttribute("error", "Error al modificar el Rol Fan Page: " + e.getMessage());
        }
        return "redirect:/rol_fan_page_listar";
    }

    @GetMapping("/rol_fan_page_eliminar")
    public String eliminarRolFanPage(@org.springframework.web.bind.annotation.RequestParam("cod_rol_fan") int cod_rol_fan, RedirectAttributes redirectAttrs) {
        try {
            boolean eliminado = rfp.eliminarRolFanPage(cod_rol_fan);
            if (eliminado) {
                redirectAttrs.addFlashAttribute("exito", "Rol Fan Page eliminado exitosamente");
            } else {
                redirectAttrs.addFlashAttribute("error", "No se pudo eliminar el Rol Fan Page");
            }
        } catch (Exception e) {
            redirectAttrs.addFlashAttribute("error", "Error al eliminar el Rol Fan Page: " + e.getMessage());
        }
        return "redirect:/rol_fan_page_listar";
    }
    

}