import java.io.Console;

public class App {
    public static void main(String[] args) throws Exception {

        Console console = System.console(); //el nombre no hace falta que sea console, puede ser cualquiera
        if (console == null) {
            System.err.println("No hay consola disponible");
            System.exit(1);
        }else {
            System.out.print("Introduzca tu fecha de nacimiento (dd/mm/yyyy):");
            String fechaNacimiento = console.readLine(); //Clases envolotorios
            int anioNacimiento = Integer.parseInt(fechaNacimiento.split("/")[2]);

            System.out.print("Introduzca tu fecha de nacimiento (yyyy):");
            String anioActual = console.readLine(); //Clases envolotorios
            int anioActualInt = Integer.parseInt(anioActual.split("/")[2]);

            int edad = anioActualInt - Integer.valueOf(fechaNacimiento.split("/")[2]);
            System.out.println("Tu edad es " + edad + " años.");
        }

        
    }   
}