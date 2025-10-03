import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Persona tom = new Persona();
        System.out.print("Introduce nombre de la persona 1: ");
        tom.setNombre(sc.nextLine());
        System.out.print("Introduce edad: ");
        tom.setEdad(sc.nextInt());
        System.out.print("Introduce altura: ");
        tom.setAltura(sc.nextDouble());
        sc.nextLine(); // limpiar buffer

        Persona dick = new Persona();
        System.out.print("Introduce nombre de la persona 2: ");
        dick.setNombre(sc.nextLine());
        System.out.print("Introduce edad: ");
        dick.setEdad(sc.nextInt());
        System.out.print("Introduce altura: ");
        dick.setAltura(sc.nextDouble());
        sc.nextLine();

        Persona harry = new Persona();
        System.out.print("Introduce nombre de la persona 3: ");
        harry.setNombre(sc.nextLine());
        System.out.print("Introduce edad: ");
        harry.setEdad(sc.nextInt());
        System.out.print("Introduce altura: ");
        harry.setAltura(sc.nextDouble());

        // Mostrar información
        tom.mostrarInfo();
        dick.mostrarInfo();
        harry.mostrarInfo();

        sc.close();
    }
}
