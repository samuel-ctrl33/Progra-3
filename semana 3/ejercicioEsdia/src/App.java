import com.coti.tools.Esdia;

public class App {
    public static void main(String[] args) throws Exception {

        Person personita1 = new Person();
        Person personita2 = new Person("Paco", 86.3f , 1.70f);
        

        double a = Esdia.readDouble("Dame un double ");
        double b = Esdia.readDouble("Dame un double ");
        System.out.printf("La suma de %f y %f es %f\n", a, b, a + b);
    }
}