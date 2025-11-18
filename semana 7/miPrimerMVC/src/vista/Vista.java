package vista;

import com.coti.tools.Esdia;
import java.util.ArrayList;
import controlador.Controlador;
import model.Coche;



public class Vista {

    Controlador controlador;

    public Controlador getControlador(){
        return controlador;
    }

    public void setControlador(Controlador controlador){
        this.controlador=controlador;
    }

    //se crea el getter y setter para conectarse con el controlador

    public void mostrarMenu(){
        boolean continuar = true;

        while(continuar){
            System.out.println("\n--- MENU MVC ---");
            System.out.println("1. Agregar coche");
            System.out.println("2. Listar coches");
            System.out.println("3. Borrar coche");
            System.out.println("4. Salir");

            int opcion =Esdia.readInt("Introduzca una opcion");

            switch(opcion){
                case 1:
                    agregarCoche();
                    break;
                
                case 2:
                    listarCoche();
                    break;
                case 3:
                    borrarCoche();
                    break;
                case 4:
                    System.out.println("Gracias por usar la aplicacion");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida");
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
                System.out.println(c.comoFilaDeTabla());
            }

        }

    }

    public void borrarCoche(){
        String numBastidor = Esdia.readString("Introduzca el número de bastidor del coche a borrar: ");
        
        ArrayList<Coche> coches = controlador.obtenerTodosLosCoches();
        Coche cocheBorrar = null;
        
        for(Coche c : coches){
            if(c.getNumBastidor().equals(numBastidor)){
                cocheBorrar = c;
                break;
            }
        }
        
        if(cocheBorrar != null){
            String resultado = controlador.eliminarCoche(cocheBorrar);
            System.out.println(resultado);
        }else{
            System.err.println("Coche no encontrado");
        }
    }
}
