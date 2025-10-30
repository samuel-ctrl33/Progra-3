package vista;

import java.util.ArrayList;
import controlador.Controlador;
import model.Coche;

import com.coti.tools.Esdia;

public class Vista {

    Controlador controlador;

    public Controlador geControlador(){
        return controlador;
    }

    public void setControlador(Controlador controlador){
        this.controlador=controlador;
    }

    public void mostrarMenu(){
        boolean continuar = true;

        while(continuar){
            System.out.println("Menu Mvc");
            System.out.println("Agregar coche");
            System.out.println("Listar coches");
            System.out.println("Borrar");

            int opcion =Esdia.readInt("Introduzca una opcion");

            switch(opcion){
                case 1:
                    agregarCoche();
                    break;
                
                case 2:
                    listarCoche();
                    break;
                case 3:
                    System.out.println("Gracias por usar la aplicacion");
                    continuar = false;
                    break;
                case 4:

                


            }

        }
    }

    private void agregarCoche(){

        String marca= Esdia.readString("Marca:");
        String modelo= Esdia.readString("Modelo:");
        String numBastidor= Esdia.readString("Número de Bastidor:");

        Coche coche = new Coche(marca,modelo,numBastidor);

        String resultado = controlador.agregarCoche(coche);

        if(resultado.isBlank()){
            System.out.println("Coche añadido con exito");
        }else{
            System.err.println("Error");
        }
    };

    private void listarCoche(){

        ArrayList<Coche> coche = controlador.obtenerTodosLosCoches();

        if(coche.isEmpty()){
            System.out.println("NO HAY COCHES EN EL CONCESIONARIO");
        }else{
            System.out.println(Coche.ObtenerCabeceroTabla());

            for(Coche c : coche){

            }

        }

    }

    public void getCoches(){

    }

    public void borrarCoche(){

    }
}
