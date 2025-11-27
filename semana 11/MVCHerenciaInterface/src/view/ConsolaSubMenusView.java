package view;

import static com.coti.tools.Esdia.readInt;
import static com.coti.tools.Esdia.readString;
import static com.coti.tools.Esdia.readString_ne;
import java.util.List;
import model.Alumno;

/**
 *
 * @author Loza
 */
public class ConsolaSubMenusView extends AppView {

    @Override
    public void mostrarInicio(String msgBienvenida) {
        System.out.println(msgBienvenida);
    }

    @Override
    public void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n--- MENU ALUMNOS SUBMENUS ---");
            System.out.println("1. Submenú CRUD");
            System.out.println("2. Listados");
            System.out.println("3. Salir");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    subMenuCRUD();
                    break;
                case 2:
                    subMenuListados();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    @Override
    public void mostrarFinPrograma(String msgDespedida) {
        System.out.println(msgDespedida);
    }

    private void subMenuCRUD() {
        int opcion;
        do {
            System.out.println("\n--- SUBMENU ALTAS Y BAJAS ---");
            System.out.println("1. Alta alumno");
            System.out.println("2. Baja alumno por DNI");
            System.out.println("3. Modificar alumno");
            System.out.println("4. Volver");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    agregarAlumno();
                    break;
                case 2:
                    eliminarAlumnoPorDNI();
                    break;
                case 3:
                    modificarAlumno();
                    break;
                case 4:
                    break;
                
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private void subMenuListados() {
        int opcion;
        do {
            System.out.println("\n--- SUBMENU LISTADOS ---");
            System.out.println("1. Listar todos los alumnos");
            System.out.println("2. Volver");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    listarAlumnos();
                    break;
                case 2:
                    break;
                
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 2);
    }
    private void agregarAlumno() {

        System.out.println("Introduzca los datos del nuevo alumno:");
        String DNI = readString_ne("DNI:");
        String nombre = readString("Nombre:");
        String apellido1 = readString("Primer apellido:");
        String apellido2 = readString("Segundo apellido:");
        if (c.agregarAlumno(new Alumno(DNI, nombre, apellido1, apellido2))) {
            System.out.println("Alumno agregado con exito");
        } else {
            // Veremos alternativas para dar más información de como modificar esto para ser
            // más informativos.
            System.out.println("No se pudo agregar el alumno con esos datos.");
        }

    }

    private void eliminarAlumnoPorDNI() {
        System.out.println("Introduzca el DNI que quiere eliminar:");
        String DNI = readString_ne("DNI:");
        if (c.eliminarAlumnoPorDNI(DNI)) {
            System.out.println("Alumno eliminado con exito");
        } else {
            // Veremos alternativas para dar más información de como modificar esto para ser
            // más informativos.
            System.out.println("No se pudo eliminar el alumno con ese DNI.");
        }
    }

    private void modificarAlumno() {
        System.out.println("Introduzca el DNI del alumno a modificar:");
        String DNI = readString_ne("DNI:");
        System.out.println("Introduzca los nuevos datos:");
        String nombre = readString("Nombre:");
        String apellido1 = readString("Primer apellido:");
        String apellido2 = readString("Segundo apellido:");
        
        if (c.modificarAlumno(new Alumno(DNI, nombre, apellido1, apellido2))) {
            System.out.println("Alumno modificado con exito");
        } else {
            System.out.println("No se pudo modificar el alumno (probablemente no existe el DNI).");
        }
    }

    private void listarAlumnos() {
        List<Alumno> alumnos = c.obtenerAlumnosDelModelo();
        System.out.println(Alumno.getHeaderTableStringForAlumno());
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.getAsRowString());
        }
    }

}
