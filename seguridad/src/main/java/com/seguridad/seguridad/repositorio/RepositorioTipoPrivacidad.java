package com.seguridad.seguridad.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.seguridad.seguridad.modelo.TipoPrivacidad;


public interface RepositorioTipoPrivacidad extends JpaRepository<TipoPrivacidad, Integer>{


    @Query(value = "SELECT * FROM seguridad.tipo_privacidad_listar()", nativeQuery = true)
    List <TipoPrivacidad> tipo_privacidad_listar_listar();

    @Transactional 
    @Query (value = "SELECT seguridad.tipo_privacidad_agregar(:nom_tip,  :est_tip)", nativeQuery = true )
    Integer tipo_privacidad_agregar(@Param ("nom_tip") String nom_tip, @Param ("est_tip") String est_tip);

    @Query(value = "SELECT * FROM seguridad.tipo_privacidad_buscar(:cod_tip)", nativeQuery = true)
    TipoPrivacidad tipo_privacidad_buscar(@Param("cod_tip") int codTip);

    @Transactional
    @Query(value = "SELECT seguridad.tipo_privacidad_modificar(:cod_tip, :nom_tip, :est_tip)", nativeQuery = true)
    Integer tipo_privacidad_editar(@Param("cod_tip") int codTip,
            @Param("nom_tip") String nomTip,
            @Param("est_tip") String estTip);

    @Transactional
    @Query(value = "SELECT seguridad.tipo_privacidad_eliminar(:cod_tip)", nativeQuery = true)
    Integer tipo_privacidad_eliminar(@Param("cod_tip") int codTip);
}