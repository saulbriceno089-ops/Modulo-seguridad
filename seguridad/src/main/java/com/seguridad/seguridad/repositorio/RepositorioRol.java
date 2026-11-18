package com.seguridad.seguridad.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.seguridad.seguridad.modelo.Rol;

import jakarta.transaction.Transactional;

public interface RepositorioRol extends JpaRepository <Rol, Integer>{ //contiene todos los SQL
    //Metodo para listar con nuestros procedimientos almacenados es la forma mas segura, en vez de implementar el FindAll por defecto
    @Query (value = "SELECT * FROM seguridad.rol_listar()", nativeQuery = true)
    List <Rol> rol_listar();

    //Método par añadir un nuevo rol con nuestro procedimiento alamacenado (es la forma más segura):
    @Transactional 
    @Query(value = "SELECT seguridad.rol_agregar(:nom_rol, :des_rol, :est_rol)",
    nativeQuery = true)
    Integer rol_agregar(@Param("nom_rol")String nom_rol, @Param("des_rol")String des_rol, @Param("est_rol")String est_rol);

    //Metodo para consultar o buscar un rol con nuestro procedimiento de almacenado ya que es la forma mas segura
    @Query(value = "SELECT * FROM seguridad.rol_buscar(:cod_rol)", nativeQuery = true)
    Rol rol_buscar(@Param("cod_rol")int cod_rol);

    //Metodo para modificar un rol con nuestro procedimiento almacenado (es la forma mas segura):
    @Query(value = "SELECT seguridad.rol_modificar(:cod_rol, :nom_rol, :des_rol, :est_rol)", nativeQuery = true)
    void rol_editar(@Param("cod_rol")int cod_rol, @Param("nom_rol")String nom_rol, @Param("des_rol")String des_rol, @Param
    ("est_rol")String est_rol);
//metodo para eliminar un rol con nuestro procedimiento almacenado (es la forma mas segura):
    @Transactional
    @Query(value = "SELECT seguridad.rol_eliminar(:cod_rol)", nativeQuery = true)
    Integer rol_eliminar(@Param("cod_rol")int cod_rol);
}
