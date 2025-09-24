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

            System.out.print("Introduzca el año actual (yyyy):");
            String anioActual = console.readLine(); //Clases envolotorios
            int anioActualInt = Integer.valueOf(anioActual);            

            int edad = anioActualInt - anioNacimiento;
            //int edad =anioActualInt - Integer.valueOf(fechaNacimiento.split("/")[2]); tambien es válida
            System.out.println("Tu edad es " + edad + " años.");
        }

        
    }   
}