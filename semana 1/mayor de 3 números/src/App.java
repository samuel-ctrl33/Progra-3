import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); // Crear el objeto Scanner
        
        System.out.print("Ingrese el primer número: ");
        int num1 = sc.nextInt();

        System.out.print("Ingrese el segundo número: ");
        int num2 = sc.nextInt();

        System.out.print("Ingrese el tercer número: ");
        int num3 = sc.nextInt();

        // Comparar los números
        if (num1 == num2 && num2 == num3) {
            System.out.println("Los tres números son iguales: " + num1);
        } else {
            int mayor = num1;
            String posicion = "1º";

            if (num2 > mayor) {
                mayor = num2;
                posicion = "2º";
            }
            if (num3 > mayor) {
                mayor = num3;
                posicion = "3º";
            }

            // Verificar empates
            //Al no ser mayor estricto cuando comparas el mayor lo haces con los numeros y no importa que no se vaya actualizando en los ifs             
            if (mayor == num1 && mayor == num2 && mayor != num3) {
                System.out.println("El mayor es el 1º y 2º número: " + mayor);
            } else if (mayor == num1 && mayor == num3 && mayor != num2) {
                System.out.println("El mayor es el 1º y 3º número: " + mayor);
            } else if (mayor == num2 && mayor == num3 && mayor != num1) {
                System.out.println("El mayor es el 2º y 3º número: " + mayor);
            } else {
                System.out.println("El mayor es el " + posicion + " número: " + mayor);
            }
        }

        sc.close();
    }
}
