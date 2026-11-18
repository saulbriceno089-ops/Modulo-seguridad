package com.seguridad.seguridad.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Entity le dice a Java que la Clase Rol esta relacionada con na Tabla en la BD
//Cada fila de la tabla 'rol' se convertira en un objeto de la Clase Rol

@Table(name="usuario", schema="seguridad")
//Debo indicarle el esquema y la tabla con la cual va a estar enlazada la clase Rol

public class Usuario {
    //Atributos. Cada atributo corresponde a una columna de la Tabla Rol
    //Se colocan comoatributos los nombres de cada una de las columnas de la tabla Rol
    
    @Id 
    @Column (name="cod_usu")
    private int cod_usu;

    @Column (name="ali_usu")
    private String ali_usu;

    @Column (name="ema_usu")
    private String ema_usu;

    @Column (name="cla_usu")
    private String cla_usu;

    @Column (name="est_usu")
    private String est_usu;



    //Constructor solo el codigo
    public int getCod_usu() {
        return cod_usu;
    }

    public void setCod_usu(int cod_usu) {
        this.cod_usu = cod_usu;
    }

    public String getAli_usu() {
        return ali_usu;
    }

    public void setAli_usu(String ali_usu) {
        this.ali_usu = ali_usu;
    }

    public String getEma_usu() {
        return ema_usu;
    }

    public void setEma_usu(String ema_usu) {
        this.ema_usu = ema_usu;
    }

    public String getCla_usu() {
        return cla_usu;
    }

    public void setCla_usu(String cla_usu) {
        this.cla_usu = cla_usu;
    }

    public String getEst_usu() {
        return est_usu;
    }

    public void setEst_usu(String est_usu) {
        this.est_usu = est_usu;
    }

    //constructor vacio
    public Usuario() {
    }

    //constructor lleno
    public Usuario(int cod_usu, String ali_usu, String ema_usu, String cla_usu, String est_usu) {
        this.cod_usu = cod_usu;
        this.ali_usu = ali_usu;
        this.ema_usu = ema_usu;
        this.cla_usu = cla_usu;
        this.est_usu = est_usu;
    }

    //constructor solo el codigo 
    public Usuario(int cod_usu) {
        this.cod_usu = cod_usu;
    }

    //constructor todo menos el codigo
    public Usuario(String ali_usu, String ema_usu, String cla_usu, String est_usu) {
        this.ali_usu = ali_usu;
        this.ema_usu = ema_usu;
        this.cla_usu = cla_usu;
        this.est_usu = est_usu;
    }
    public String getClasuMascara(){
        if (this.cla_usu == null) return "";
        return "*".repeat(this.cla_usu.length());
    }
    
}