package com.seguridad.seguridad.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Entity le dice a Java que la Clase Rol esta relacionada con na Tabla en la BD
//Cada fila de la tabla 'rol' se convertira en un objeto de la Clase Rol

@Table(name="tipoPrivacidad", schema="seguridad")
//Debo indicarle el esquema y la tabla con la cual va a estar enlazada la clase Rol

public class TipoPrivacidad {
    //Atributos. Cada atributo corresponde a una columna de la Tabla Rol
    //Se colocan comoatributos los nombres de cada una de las columnas de la tabla Rol
    
    @Id 
    @Column (name="cod_tip")
    private int cod_tip;

    @Column (name="nom_tip")
    private String nom_tip;

    @Column (name="est_tip")
    private String est_tip;



    //Constructor solo el codigo
    public int getCod_tip() {
        return cod_tip;
    }

    public void setCod_tip(int cod_tip) {
        this.cod_tip = cod_tip;
    }

    public String getNom_tip() {
        return nom_tip;
    }

    public void setNom_tip(String nom_tip) {
        this.nom_tip = nom_tip;
    }

    public String getEst_tip() {
        return est_tip;
    }

    public void setEst_tip(String est_tip) {
        this.est_tip = est_tip;
    }

    //constructor vacio
    public TipoPrivacidad() {
    }
    
    //constructor lleno
    public TipoPrivacidad(int cod_tip, String nom_tip, String est_tip) {
        this.cod_tip = cod_tip;
        this.nom_tip = nom_tip;
        this.est_tip = est_tip;
    }

    //constructor solo el codigo 
    public TipoPrivacidad(int cod_tip) {
        this.cod_tip = cod_tip;
    }
    //constructor todo menos el codigo

    public TipoPrivacidad(String nom_tip, String est_tip) {
        this.nom_tip = nom_tip;
        this.est_tip = est_tip;
    }


}