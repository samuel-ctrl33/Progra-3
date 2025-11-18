package controlador;

import vista.Vista;

import java.util.ArrayList;

import model.Coche;
import model.Modelo;

public class Controlador {
    
    Vista vista;
    Modelo modelo;

    public Controlador(Vista vista, Modelo modelo){
        this.vista=vista;
        this.modelo=modelo;

        vista.setControlador(this);

    }
    
    public void inicializarAplicacion(){

        //Inicializamos la aplicacion
        //Todo:

        vista.mostrarMenu();

    }

    public String agregarCoche(Coche coche){

        String resultado = modelo.agregarCoche(coche);
        return resultado;
    }

    public ArrayList<Coche> obtenerTodosLosCoches(){
        return modelo.getCoches();
    }

    public String eliminarCoche(Coche coche){
        String resultado = modelo.eliminarCoche(coche);
        return resultado;
    }

}
