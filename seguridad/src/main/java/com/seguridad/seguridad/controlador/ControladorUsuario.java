package com.seguridad.seguridad.controlador;

import com.seguridad.seguridad.modelo.Usuario;
import com.seguridad.seguridad.servicio.ServicioUsuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ControladorUsuario {

    private final ServicioUsuario servicioUsuario;

    public ControladorUsuario(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    // 1. Ruta principal: ahora al poner solo /usuario carga el listado directamente
    @GetMapping("/usuario")
    public String listarUsuarios(Model modelo) {
        List<Usuario> usuarios = servicioUsuario.listarUsuarios();
        modelo.addAttribute("usuarios", usuarios);
        return "usuario_listar";
    }

    // También dejamos esta por si alguna redirección interna la llega a usar
    @GetMapping("/usuario_listar")
    public String listarUsuariosAlternativa(Model modelo) {
        return listarUsuarios(modelo);
    }

    // 2. Ruta para mostrar el formulario de nuevo usuario
    @GetMapping("/usuario_nuevo")
    public String mostrarFormularioNuevo(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        return "usuario_agregar";
    }

    // 3. Ruta para procesar el guardado del usuario
    @PostMapping("/usuario_guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario, RedirectAttributes redirectAttributes) {
        servicioUsuario.agregarUsuario(
            usuario.getAli_usu(),
            usuario.getEma_usu(),
            usuario.getCla_usu(),
            usuario.getEst_usu()
        );
        redirectAttributes.addFlashAttribute("mensaje", "¡Usuario guardado con éxito!");
        return "redirect:/usuario";
    }

    // 4. Ruta para ver los detalles de un usuario
    @GetMapping("/usuario_ver/{cod_usu}")
    public String verUsuario(@PathVariable("cod_usu") int codUsu, Model modelo) {
        Usuario usuario = servicioUsuario.buscarUsuarioPorId(codUsu);
        modelo.addAttribute("usuario", usuario);
        return "usuario_ver";
    }

    // 5. Ruta para mostrar el formulario de edición con los datos del usuario
    @GetMapping("/usuario_editar/{cod_usu}")
    public String mostrarFormularioEditar(@PathVariable("cod_usu") int codUsu, Model modelo) {
        Usuario usuario = servicioUsuario.buscarUsuarioPorId(codUsu);
        modelo.addAttribute("usuario", usuario);
        return "usuario_editar";
    }

    // 6. Ruta para procesar la actualización del usuario
    @PostMapping("/usuario_actualizar")
    public String actualizarUsuario(@ModelAttribute Usuario usuario, RedirectAttributes redirectAttributes) {
        servicioUsuario.editarUsuario(
            usuario.getCod_usu(),
            usuario.getAli_usu(),
            usuario.getEma_usu(),
            usuario.getCla_usu(),
            usuario.getEst_usu()
        );
        redirectAttributes.addFlashAttribute("mensaje", "¡Usuario modificado con éxito!");
        return "redirect:/usuario";
    }

    // 7. Ruta para eliminar un usuario
    @GetMapping("/usuario_eliminar/{cod_usu}")
    public String eliminarUsuario(@PathVariable("cod_usu") int codUsu, RedirectAttributes redirectAttributes) {
        servicioUsuario.eliminarUsuario(codUsu);
        redirectAttributes.addFlashAttribute("mensaje", "¡Usuario eliminado con éxito!");
        return "redirect:/usuario";
    }
}