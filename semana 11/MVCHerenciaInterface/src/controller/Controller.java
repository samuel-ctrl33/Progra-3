package controller;

import java.util.List;
import model.Alumno;
import model.Model;
import view.AppView;

/**
 *
 * @author Loza
 */
public class Controller {
    
    Model model;
    AppView view;

    public Controller(Model model, AppView view) {
        this.model = model;
        this.view = view;
        view.setController(this);
    }
     
    
    public void initApplication(){
        
        // Carga inicial programa (cargar el repository si fuera necesario)
        if(model.cargarEstadoAplicación()){
            view.mostrarInicio("Cargado estado anterior con exito");
        }else{
            view.mostrarInicio("No se encontró fichero para carga del programa");
        }
        
        // Menú principal
        view.mostrarMenuPrincipal();
        
        
    }
    
    
    public boolean agregarAlumno(Alumno alumno) {
        return model.agregarAlumno(alumno);
    }

    public boolean eliminarAlumnoPorDNI(String DNI) {
        return model.eliminarAlumnoPorDNI(DNI);
    }

    public boolean modificarAlumno(Alumno alumno) {
        return model.modificarAlumno(alumno);
    }

    public List<Alumno> obtenerAlumnosDelModelo() {
        return model.obtenerAlumnosDelModelo();
    }
    
}
