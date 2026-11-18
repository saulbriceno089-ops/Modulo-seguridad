package com.seguridad.seguridad.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity


@Table(name="rol_fan_page", schema="seguridad")


public class RolFanPage {
    
    
    @Id 
    @Column (name="cod_rol_fan")
    private int cod_rol_fan;

    @ManyToOne //Muchos a uno
    @JoinColumn (name="cod_per") 
    private Persona persona;

    @ManyToOne
    @JoinColumn (name="cod_fan_pag") 
    private FanPage fan_page;

    @ManyToOne
    @JoinColumn (name="cod_rol") 
    private Rol rol;

    @Column(name = "est_rol_fan")
    private String est_rol_fan;


    
    public int getCod_rol_fan() {
        return cod_rol_fan;
    }

    public void setCod_rol_fan(int cod_rol_fan) {
        this.cod_rol_fan = cod_rol_fan;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public FanPage getFan_page() {
        return fan_page;
    }

    public void setFan_page(FanPage fan_page) {
        this.fan_page = fan_page;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getEst_rol_fan() {
        return est_rol_fan;
    }

    public void setEst_rol_fan(String est_rol_fan) {
        this.est_rol_fan = est_rol_fan;
    }
    
  
    public RolFanPage() {
    }

    
    public RolFanPage(int cod_rol_fan, Persona persona, FanPage fan_page, Rol rol, String est_rol_fan) {
        this.cod_rol_fan = cod_rol_fan;
        this.persona = persona;
        this.fan_page = fan_page;
        this.rol = rol;
        this.est_rol_fan = est_rol_fan;
    }


    public RolFanPage(int cod_rol_fan) {
        this.cod_rol_fan = cod_rol_fan;
    } 

   
    public RolFanPage(Persona persona, FanPage fan_page, Rol rol, String est_rol_fan) {
        this.persona = persona;
        this.fan_page = fan_page;
        this.rol = rol;
        this.est_rol_fan = est_rol_fan;
    }


}