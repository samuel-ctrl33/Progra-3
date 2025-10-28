import vista.Vista;
import model.Modelo;
import controlador.Controlador;

public class App {
    public static void main(String[] args) {
        
        //PARTES DEL MVC
        //OBJETO VISTA
        //OBJETO MODELO
        //OBJETO CONTROLADOR

        Vista vista=new Vista();
        Modelo modelo=new Modelo();
        Controlador controlador=new Controlador(vista,modelo);

    }

}
