package com.seguridad.seguridad.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.seguridad.seguridad.modelo.RolFanPage;


public interface RepositorioRolFanPage extends JpaRepository<RolFanPage, Integer> {
    @Query(value = "SELECT * FROM seguridad.rol_fan_page_listar()", nativeQuery = true)
    List<RolFanPage> rol_fan_page_listar();

    @Query(value ="SELECT * FROM seguridad.rol_fan_page_agregar(:fky_per, :fky_fan_pag, :fky_rol, :est_rol_fan)", nativeQuery = true)
    Integer rol_fan_page_agregar(
        @Param ("fky_per") int fky_per,
        @Param("fky_fan_pag") int fky_fan_pag,
        @Param("fky_rol") int fky_rol,
        @Param("est_rol_fan") String est_rol_fan
    );

    @Transactional
    @Query(value = "SELECT seguridad.rol_fan_page_modificar(:cod_rol_fan, :fky_per, :fky_fan_pag, :fky_rol, :est_rol_fan)", nativeQuery= true)
    Integer rol_fan_page_modificar(
        @Param("cod_rol_fan") int cod_rol_fan,
        @Param("fky_per") int fky_per,
        @Param("fky_fan_pag") int fky_fan_pag,
        @Param("fky_rol") int fky_rol,
        @Param("est_rol_fan") String est_rol_fan
    );

    //ELIMINAR
    @Transactional 
    @Query(value = "SELECT seguridad.rol_fan_page_eliminar(:cod_rol_fan)", nativeQuery = true)
    Integer rol_fan_page_eliminar(@Param ("cod_rol_fan")int cod_rol_fan);
    
    //BUSCAR
    @Query(value = "SELECT * FROM seguridad.rol_fan_page_buscar(:cod_rol_fan)", nativeQuery = true)
    RolFanPage rol_fan_page_buscar(@Param("cod_rol_fan") int cod_rol_fan);
    
}