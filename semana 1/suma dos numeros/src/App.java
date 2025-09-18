import java.util.Scanner;
    public class App {
    public static void main(String[] args) throws Exception {
        // Pedir dos numeros al usuario con Scanner y mostrar la suma de ambos
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int num1 = sc.nextInt();
        System.out.println("Introduce otro número: ");
        int num2 = sc.nextInt();
        System.out.printf("La suma de ambos números es: %d\n", num1 + num2);
        sc.close();
    }
}

// nuevo proyecto
// --- IGNORE ---  
