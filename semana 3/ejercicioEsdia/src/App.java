import com.coti.tools.Esdia;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        double a = Esdia.readDouble("Dame un double ");
        double b = Esdia.readDouble("Dame un double ");
        System.out.printf("La suma de %f y %f es %f\n", a, b, a + b);
    }
}