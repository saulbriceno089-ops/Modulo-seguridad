package com.seguridad.seguridad.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.seguridad.seguridad.modelo.Usuario;
import jakarta.transaction.Transactional;

public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT * FROM seguridad.usuario_listar()", nativeQuery = true)
    List<Usuario> usuario_listar();

    @Transactional 
    @Query(value = "SELECT seguridad.usuario_agregar(:ali_usu, :ema_usu, :cla_usu, :est_usu)", nativeQuery = true)
    Integer usuario_agregar(
        @Param("ali_usu") String ali_usu, 
        @Param("ema_usu") String ema_usu, 
        @Param("cla_usu") String cla_usu, 
        @Param("est_usu") String est_usu
    );

    @Query(value = "SELECT * FROM seguridad.usuario_buscar(:cod_usu)", nativeQuery = true)
    Usuario usuario_buscar(@Param("cod_usu") int cod_usu);

    @Transactional
    @Query(value = "SELECT seguridad.usuario_modificar(:cod_usu, :ali_usu, :ema_usu, :cla_usu, :est_usu)", nativeQuery = true)
    void usuario_editar(
        @Param("cod_usu") int cod_usu, 
        @Param("ali_usu") String ali_usu, 
        @Param("ema_usu") String ema_usu, 
        @Param("cla_usu") String cla_usu, 
        @Param("est_usu") String est_usu
    );

    @Transactional
    @Query(value = "SELECT seguridad.usuario_eliminar(:cod_usu)", nativeQuery = true)
    Integer usuario_eliminar(@Param("cod_usu") int cod_usu);

}