package com.seguridad.seguridad.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seguridad.seguridad.modelo.TipoPrivacidad;
import com.seguridad.seguridad.repositorio.RepositorioTipoPrivacidad;

@Service 
public class ServicioTipoPrivacidad {

    private final RepositorioTipoPrivacidad tipoRepositorio;

    public ServicioTipoPrivacidad(RepositorioTipoPrivacidad tipoRepositorio) {
        this.tipoRepositorio = tipoRepositorio;
    }

    public List<TipoPrivacidad> listarTipos(){
        return  tipoRepositorio.tipo_privacidad_listar_listar();
    }

    public void agregarTipoPrivacidad(TipoPrivacidad tipopriv) {
        //Usamos getters para obtener los valores
        tipoRepositorio.tipo_privacidad_agregar(
            tipopriv.getNom_tip(),
            tipopriv.getEst_tip()
        );
    }

    public TipoPrivacidad buscarTipoPrivacidad(int codTip) {
        return tipoRepositorio.tipo_privacidad_buscar(codTip);
    }

    public void editarTipoPrivacidad(TipoPrivacidad tipopriv) {
        tipoRepositorio.tipo_privacidad_editar(
            tipopriv.getCod_tip(),
            tipopriv.getNom_tip(),
            tipopriv.getEst_tip()
        );
    }

    public boolean eliminarTipoPrivacidad(int codTip) {
        if (tipoRepositorio.tipo_privacidad_buscar(codTip) != null) {
            tipoRepositorio.tipo_privacidad_eliminar(codTip);
            return true;
        }
        return false;
    }
}