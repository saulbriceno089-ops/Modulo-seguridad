package com.seguridad.seguridad.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Entity le dice a Java que la Clase Rol esta relacionada con na Tabla en la BD
//Cada fila de la tabla 'rol' se convertira en un objeto de la Clase Rol

@Table(name="rol", schema="seguridad")
//Debo indicarle el esquema y la tabla con la cual va a estar enlazada la clase Rol

public class Rol {
    //Atributos. Cada atributo corresponde a una columna de la Tabla Rol
    //Se colocan comoatributos los nombres de cada una de las columnas de la tabla Rol
    
    @Id 
    @Column (name="cod_rol")
    private int cod_rol;

    @Column (name="nom_rol")
    private String nom_rol;

    @Column (name="des_rol")
    private String des_rol;

    @Column (name="est_rol")
    private String est_rol;

    public Rol() {
    }

    public Rol(int cod_rol, String nom_rol, String des_rol, String est_rol) {
        this.cod_rol = cod_rol;
        this.nom_rol = nom_rol;
        this.des_rol = des_rol;
        this.est_rol = est_rol;
    }

    public Rol(String nom_rol, String des_rol, String est_rol) {
        this.nom_rol = nom_rol;
        this.des_rol = des_rol;
        this.est_rol = est_rol;
    }

    public Rol(int cod_rol) {
        this.cod_rol = cod_rol;
    }

    public int getCod_rol() {
        return cod_rol;
    }

    public void setCod_rol(int cod_rol) {
        this.cod_rol = cod_rol;
    }

    public String getNom_rol() {
        return nom_rol;
    }

    public void setNom_rol(String nom_rol) {
        this.nom_rol = nom_rol;
    }

    public String getDes_rol() {
        return des_rol;
    }

    public void setDes_rol(String des_rol) {
        this.des_rol = des_rol;
    }

    public String getEst_rol() {
        return est_rol;
    }

    public void setEst_rol(String est_rol) {
        this.est_rol = est_rol;
    }
    
}