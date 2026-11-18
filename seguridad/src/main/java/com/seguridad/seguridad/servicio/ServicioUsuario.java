package com.seguridad.seguridad.servicio;

import com.seguridad.seguridad.modelo.Usuario;
import com.seguridad.seguridad.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicioUsuario {

    private final RepositorioUsuario repositorioUsuario;

    public ServicioUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    // Listar usuarios
    public List<Usuario> listarUsuarios() {
        return repositorioUsuario.usuario_listar();
    }

    // Agregar usuario
    public Integer agregarUsuario(String aliUsu, String emaUsu, String claUsu, String estUsu) {
        return repositorioUsuario.usuario_agregar(aliUsu, emaUsu, claUsu, estUsu);
    }

    // Buscar usuario por ID
    public Usuario buscarUsuarioPorId(int codUsu) {
        return repositorioUsuario.usuario_buscar(codUsu);
    }

    // Editar usuario
    public void editarUsuario(int codUsu, String aliUsu, String emaUsu, String claUsu, String estUsu) {
        repositorioUsuario.usuario_editar(codUsu, aliUsu, emaUsu, claUsu, estUsu);
    }

    // Eliminar usuario
    public void eliminarUsuario(int codUsu) {
        repositorioUsuario.usuario_eliminar(codUsu);
    }
}