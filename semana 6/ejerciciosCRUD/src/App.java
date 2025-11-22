import static com.coti.tools.Esdia;
import model.Coche;
import model.concesionario;
import java.util.ArrayList;

//cada ejercicio CRUD tendra un app.java y luego un modelo con add, remove, read e update
//en el app.java no tiene que aparecer ningun system.out

public class App {
    public static void main(String[] args) throws Exception {

        concesionario Concesionario = new concesionario();

        int opcion;
        do {
            System.out.println("\n--- MENU CRUD ---");
            System.out.println("1. Agregar coche");
            System.out.println("2. Eliminar coche");
            System.out.println("3. Modificar coche");
            System.out.println("4. Listar coches");
            System.out.println("5. Salir");
            opcion = Esdia.readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    agregarCoche(Concesionario);
                    break;
                case 2:
                    eliminarCoche(Concesionario);
                    break;
                case 3:
                    modificarCoche(Concesionario);
                    break;
                case 4:
                    listarCoches(Concesionario);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    public static void agregarCoche(concesionario c) {
        String matricula = Esdia.readString("Ingrese la matricula del coche: ");
        String modelo = Esdia.readString("Ingrese el modelo del coche: ");
        c.addCoche(new Coche(matricula, modelo));
    }

    public static void eliminarCoche(concesionario c) {

        String matricula = Esdia.readString("Ingrese la matricula del coche a eliminar: ");
        Coche cocheAEliminar = null;

        for (Coche coche : c.getCoches()) {
            if (coche.getMatricula().equals(matricula)) {
                cocheAEliminar = coche;
                break;
            }
        }
        if (cocheAEliminar != null) {
            c.removeCoche(matricula);
            System.out.println("Coche eliminada.");
        } else {
            System.out.println("Coche no encontrada.");
        }
    }

    public static void modificarCoche(concesionario c) {

        String matricula = Esdia.readString("Ingrese la matricula a modificar: ");
        Coche cocheAModificar = null;
        for (Coche coche : c.getCoches()) {
            if (coche.getMatricula().equals(matricula)) {
                cocheAModificar = coche;
                break;
            }
        }
        if (cocheAModificar != null) {
            String nuevoMatricula = Esdia.readString("Ingrese la nueva matricula: ");
            String nuevoModelo = Esdia.readString("Ingrese el nuevo modelo: ");

            cocheAModificar.setMatricula(nuevoMatricula);
            cocheAModificar.setModelo(nuevoModelo);
        } else {
            System.out.println("Coche no encontrado.");
        }
    }

    public static void listarCoches(concesionario c) {

        ArrayList<Coche> coches = c.getCoches();
        if (coches.isEmpty()) {
            System.out.println("No hay coches en la lista.");
            return;
        }

        for (Coche coche : coches) {
            System.out.println(coche.comoFilaDeTabla());
        }
    }
}