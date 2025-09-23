import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca tu fecha de nacimiento (dd/mm/yyyy):");
        String fechaNacimiento = scanner.nextLine();

        System.out.print("El año actual es (yyyy): ");
        int anio = scanner.nextInt();

        int edad = anio - Integer.parseInt(fechaNacimiento.split("/")[2]);
        System.out.println("Tu edad es " + edad + " años.");
        scanner.close();

    }   
}
