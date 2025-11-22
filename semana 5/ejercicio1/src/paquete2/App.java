package paquete2;
import paquete1.*;

public class App {
    public static void main(String[] args) throws Exception {

        clase1 objClase1 = new clase1() ;
        //los demas no podran ser accedidos, bien porque son default, porque son privados o no tienen herencia
        objClase1.nombre="Samuel";

    }
}
