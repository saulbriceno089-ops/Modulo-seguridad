package com.seguridad.seguridad.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Entity le dice a Java que la Clase Rol esta relacionada con na Tabla en la BD
//Cada fila de la tabla 'rol' se convertira en un objeto de la Clase Rol

@Table(name="fan_page", schema="perfil_empresarial")
//Debo indicarle el esquema y la tabla con la cual va a estar enlazada la clase Rol

public class FanPage {
    //Atributos. Cada atributo corresponde a una columna de la Tabla Rol
    //Se colocan comoatributos los nombres de cada una de las columnas de la tabla Rol
    
    @Id 
    @Column (name="cod_fan_pag")
    private int cod_fan_pag;

    @Column (name="nom_fan_pag") //Antes decia fky_per
    String nom_fan_pag;

    @Column (name="des_fan_pag") //Antes decia fky_fan_page    
    String des_fan_pag;

    @Column(name="per_fan_pag") //Antes decia fky_rol 
    String per_fan_pag;

    @Column(name = "fec_fan_pag")
    String fec_fan_pag; 

    @Column(name = "est_fan_pag")
    String est_fan_pag; 



    //Constructor solo el codigo
    public int getCod_fan_pag() {
        return cod_fan_pag;
    }

    public void setCod_fan_pag(int cod_fan_pag) {
        this.cod_fan_pag = cod_fan_pag;
    }

    public String getNom_fan_pag() {
        return nom_fan_pag;
    }

    public void setNom_fan_pag(String nom_fan_pag) {
        this.nom_fan_pag = nom_fan_pag;
    }

    public String getDes_fan_pag() {
        return des_fan_pag;
    }

    public void setDes_fan_pag(String des_fan_pag) {
        this.des_fan_pag = des_fan_pag;
    }

    public String getPer_fan_pag() {
        return per_fan_pag;
    }

    public void setPer_fan_pag(String per_fan_pag) {
        this.per_fan_pag = per_fan_pag;

    }

    public String getFec_fan_pag() {
        return fec_fan_pag;
    }

    public void setFec_fan_pag(String fec_fan_pag) {
        this.fec_fan_pag = fec_fan_pag;

    }

    public String getEst_fan_pag() {
        return est_fan_pag;
    }

    public void setEst_fan_pag(String est_fan_pag) {
        this.est_fan_pag = est_fan_pag;
    }


    
    //constructor vacio
    public FanPage() {
    }

    //constructor lleno
        public FanPage(int cod_fan_pag, String nom_fan_pag, String des_fan_pag, String per_fan_pag, String fec_fan_pag,
            String est_fan_pag) {
        this.cod_fan_pag = cod_fan_pag;
        this.nom_fan_pag = nom_fan_pag;
        this.des_fan_pag = des_fan_pag;
        this.per_fan_pag = per_fan_pag;
        this.fec_fan_pag = fec_fan_pag;
        this.est_fan_pag = est_fan_pag;
    }
    

    //constructor solo el codigo 
    public FanPage(int cod_fan_pag) {
        this.cod_fan_pag = cod_fan_pag;
    }

    
    //constructor todo menos el codigo
    public FanPage(String nom_fan_pag, String des_fan_pag, String per_fan_pag, String fec_fan_pag,
            String est_fan_pag) {
        this.nom_fan_pag = nom_fan_pag;
        this.des_fan_pag = des_fan_pag;
        this.per_fan_pag = per_fan_pag;
        this.fec_fan_pag = fec_fan_pag;
        this.est_fan_pag = est_fan_pag;
    }

    
    

}