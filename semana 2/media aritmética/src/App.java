import biblioteca.*;

public class App {
    public static void main(String[] args) throws Exception {
        int n = 0;
                
         // Solicitar N hasta que sea válido (>0)
        do {
            n = ES.leerEntero("Introduce un número entero mayor que cero: ");
            if (n <= 0) {
                System.err.println("Error: El número debe ser mayor que cero.");
            }
        } while (n <= 0);

        double suma = 0;
        // Solicitar N números reales
        for (int i = 1; i <= n; i++) {
            double num = ES.leerReal("Introduce el número " + i + ": ");
            suma += num;
        }

        double media = suma / n;
        ES.escribir("La media aritmética es: " + media);


        
    }
}
