package com.seguridad.seguridad.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.seguridad.seguridad.modelo.Persona;

public interface RepositorioPersona extends JpaRepository<Persona, Integer>{
    // Método para invocar el procedimiento almacenado (mapea a la entidad Rol)
    @Query(value = "SELECT * FROM seguridad.persona_listar()", nativeQuery = true)
    List<Persona> persona_listar();
}