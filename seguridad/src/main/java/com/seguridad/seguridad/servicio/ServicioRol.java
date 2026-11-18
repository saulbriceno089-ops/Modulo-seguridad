package com.seguridad.seguridad.servicio;

import org.springframework.stereotype.Service;
import com.seguridad.seguridad.repositorio.RepositorioRol;
import com.seguridad.seguridad.modelo.Rol;
import java.util.List;


@Service
public class ServicioRol {

    //Declaramos una variable dentro del servicio para poder comunicarnos con la base de datos.
    //private: significa que solo se puede usar dentro de esta misma clase, nadie de afuera puede modificarlo por error.
    //final: indica que una vez que se le asigna el repositorio al iniciar la aplicacion, nunca mas va a cambia ni ser reemplazado. Esto garantiza mayor seguridad y estabilidad en tu codigo.
    //RepositorioRol: es el tipo de dato, la interfaz que creamos para hablar con la base de datos la que tiene el @Query para ejecutar el procedimiento de alamcenado.
    //rolRepositorio: es el nombre que le dimos a esta variable para usarla cada vez que necesitemos consultar, guardar o eliminar datos.

    private final RepositorioRol rolRepositorio;

    //Constructor Único
    //El constructor se ejecuta una sola vez cuando Spring Boot arranca y crea el servicio. Al poner RepositorioRol rolRepositorio entre los paréntesis, le decimos a Spring que cuando cree el servicio, busque el repositorio de roles que ya tiene guardado en la memoria y lo pase aquí.
    //La Asignación: toma ese repositorio que Spring le entregó y lo guardar en la variable private final RepositorioRol rolRepositorio que definimos arriba, para que podamos usarla en cualquier momento dentro de los diferentes métodos. 
    
    public ServicioRol(RepositorioRol rolRepositorio) {
        this.rolRepositorio = rolRepositorio;
    }   

    //Este método es público porque puede ser llamdo desde otras clases, como nuestro controlador y que va a devolver una lista de objetos de tipo Rol.
    //listarRoles(): es el nombre del método que creamos.
    //return rolRepositorio (rolRepositorio) que guardamos en el paso anterior y ejecuta el método rol_listar() que esta conectado al procedimiento alamacenado en la base de datos mediante la anotacion @Query. Todo lo que devuelva la base de datos se empaque y se regresa hacia el controlador.

    public List<Rol> listarRoles() {
        return rolRepositorio.rol_listar();
    }

    //Método para agregar un rol usando nuestro procedimiento de SQL
    public void agregarRol(Rol rol){
        //Usamos getters para obtener los valores
            rolRepositorio.rol_agregar(
            rol.getNom_rol(),
            rol.getDes_rol(),
            rol.getEst_rol()

        );
    }

    //Metodo para buscar un Rol por su codigo
    public Rol buscarRol(int cod_rol){
        return rolRepositorio.rol_buscar(cod_rol);
    }
//metodo para buscar un rol por su id 
public void editarRol(Rol rol){
    //usamos los getter para obtener los valores actuales 
    rolRepositorio.rol_editar(
        rol.getCod_rol(),
        rol.getNom_rol(),
        rol.getDes_rol(),
        rol.getEst_rol()
    );
}

//metodo para eliminar un rol por su id
public boolean eliminarRol(int cod_rol){
   Rol rol = rolRepositorio.rol_buscar(cod_rol);
   if(rol != null){
    rolRepositorio.rol_eliminar(cod_rol);
    return true ;
   }
   return false;
   }
}