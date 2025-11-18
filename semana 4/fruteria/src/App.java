import java.util.Scanner;
import Fruteria.Fruteria;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moneda: €");

        System.out.print("Introduzca el número de productos diferentes que vende la frutería: ");
        int numeroProductos = Integer.parseInt(sc.nextLine());
        
        // Crear un array de productos
        Fruteria[] productos = new Fruteria[numeroProductos];

        // Pedir al tendero el precio por kg de cada producto
        for (int i = 0; i < numeroProductos; i++) {
            System.out.print("Introduzca el nombre del producto: ");
            String nombreProducto = sc.nextLine();
            System.out.print("Introduzca el precio por kg sin IVA del producto: ");
            double precioSinIVA = Double.parseDouble(sc.nextLine());
            productos[i] = new Fruteria(nombreProducto, precioSinIVA);
        }


        int numeroCliente = 1;
        boolean continuar = true;

        while (continuar) {

            // Pedir cuanto lleva de cada producto
            for (int i = 0; i < productos.length; i++) {
                System.out.print("Introduzca la cantidad de " + productos[i].getNombreFruta() + " en kg: ");
                double cantidad = Double.parseDouble(sc.nextLine());
                productos[i].setCantidad(cantidad);
            }

            // Mostrar ticket
            mostrarFactura(numeroCliente, productos);

            numeroCliente++;
            System.out.print("¿Desea continuar? (s/n): ");
            String resp = sc.nextLine();
            continuar = resp.equalsIgnoreCase("s") || resp.equalsIgnoreCase("si");
        }
    }

    private static void mostrarFactura(int nCliente, Fruteria[] productos){
        System.out.println("\n--- Ticket cliente " + nCliente + " ---");
        for (int i = 0; i < productos.length; i++) {
            System.out.printf("%s: %.2f kg -> %.2f\n", productos[i].getNombreFruta(), productos[i].getCantidad(), productos[i].getPrecioPorKilo() * productos[i].getCantidad());
        }
        System.out.println("---------------------------\n");
    }
}

