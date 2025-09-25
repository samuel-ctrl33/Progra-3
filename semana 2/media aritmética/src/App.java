import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt(); // no consume el salto de línea

        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine(); // se come el salto y devuelve ""

        //sc.nextLine(); // limpiar el salto de línea pendiente
        //System.out.print("Introduce tu nombre: ");
        //String nombre = sc.nextLine();

        System.out.println("Edad: " + edad + ", Nombre: " + nombre);

        sc.close();
    }
}

//el sc.nextLine es para string y el sc.nextInt es para enteros
//Cuando usas nextInt(), el ENTER que pulsas después del número queda pendiente en el buffer.
//Si después llamas a nextLine(), este leerá directamente ese ENTER en lugar de esperar un texto.
