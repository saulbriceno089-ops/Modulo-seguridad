package com.seguridad.seguridad.servicio;

import java.util.List;
import org.springframework.stereotype.Service;
import com.seguridad.seguridad.modelo.RolFanPage;
import com.seguridad.seguridad.repositorio.RepositorioRolFanPage;

@Service 
public class ServicioRolFanPage {
    private final RepositorioRolFanPage rolFanPageRepositorio;

    public ServicioRolFanPage(RepositorioRolFanPage rolFanPageRepositorio) {
        this.rolFanPageRepositorio = rolFanPageRepositorio;
    }

    public List<RolFanPage> listarRolFanPage(){
        return rolFanPageRepositorio.rol_fan_page_listar();
    }

    //Metodo para agregar
    public void agregarRolFanPage(RolFanPage rolfanpage){
        //Segun tu Repositorio, el metodo agregar recibe 5 parametros 
        rolFanPageRepositorio.rol_fan_page_agregar(
            rolfanpage.getPersona().getCod_per(),
            rolfanpage.getFan_page().getCod_fan_pag(),
            rolfanpage.getRol().getCod_rol(),
            rolfanpage.getEst_rol_fan()
        );

    }

    public RolFanPage buscarRolFanPage(int cod_rol_fan){
        return rolFanPageRepositorio.rol_fan_page_buscar(cod_rol_fan);
    }

    public void editarRolFanPage(RolFanPage rolfanpage) {
        rolFanPageRepositorio.rol_fan_page_modificar(
            rolfanpage.getCod_rol_fan(),
            rolfanpage.getPersona().getCod_per(),
            rolfanpage.getFan_page().getCod_fan_pag(),
            rolfanpage.getRol().getCod_rol(),
            rolfanpage.getEst_rol_fan()
        );
    }

    public boolean eliminarRolFanPage(int cod_rol_fan) {
        RolFanPage rolfanpage = rolFanPageRepositorio.rol_fan_page_buscar(cod_rol_fan);
        if (rolfanpage != null) {
            rolFanPageRepositorio.rol_fan_page_eliminar(cod_rol_fan);
            return true;
        }
        return false;
    }

}