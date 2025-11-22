import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String[] palabras = new String[5];
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < palabras.length; i++){
            System.out.print("Introduce una palabra: ");
            palabras[i] = sc.nextLine();
        }

        Arrays.sort(palabras);
        System.out.println("Palabras ordenadas:");

        for(String p : palabras){
            System.out.println(p);
        }

        sc.close();
    }
}
