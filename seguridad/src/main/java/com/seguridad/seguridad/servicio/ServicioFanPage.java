package com.seguridad.seguridad.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seguridad.seguridad.modelo.FanPage;
import com.seguridad.seguridad.repositorio.RepositorioFanPage;

@Service 
public class ServicioFanPage {

    private RepositorioFanPage fanPageRepositorio;
    public ServicioFanPage(RepositorioFanPage fanPageRepositorio){
        this.fanPageRepositorio = fanPageRepositorio;
    }

    public List<FanPage> listarFanPage() {
        return fanPageRepositorio.fan_page_listar();
    }
}