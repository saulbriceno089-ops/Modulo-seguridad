package com.seguridad.seguridad.servicio;

import java.util.List;
import org.springframework.stereotype.Service;
import com.seguridad.seguridad.modelo.Persona;
import com.seguridad.seguridad.repositorio.RepositorioPersona;

@Service
public class ServicioPersona {
    
    private final RepositorioPersona personaRepositorio;

    public ServicioPersona(RepositorioPersona personaRepositorio) {
        this.personaRepositorio = personaRepositorio;
    }

    public List<Persona> listarPersonas() {
        return personaRepositorio.findAll();
    }
}