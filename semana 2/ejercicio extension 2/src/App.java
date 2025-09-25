import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir datos
        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce tus apellidos: ");
        String apellidos = sc.nextLine();

        // Calcular longitudes
        int lenNombre = nombre.length();
        int lenApellidos = apellidos.length();

        // Cabecera
        String cabecera = "*********************************";
        System.out.println(cabecera);
        System.out.printf("* %-15s * %-15s *%n", "Nombre", "Apellidos");
        System.out.println(cabecera);

        // Datos
        System.out.printf("* %-15s * %-15s *%n", nombre, apellidos);
        System.out.println(cabecera);

        // Información adicional (opcional)
        System.out.println("Longitud del nombre: " + lenNombre);
        System.out.println("Longitud de los apellidos: " + lenApellidos);

        sc.close();
    }
}
