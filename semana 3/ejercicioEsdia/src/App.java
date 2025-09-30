import com.coti.tools.Esdia;

public class App {
    public static void main(String[] args) throws Exception {

        Person personita1 = new Person();
        Person personita2 = new Person("Paco", 86.3f , 1.70f);

        showPersonInfo(personita1);

        
            
        extracted(personita1);
        
        

    }

    private static void showPersonInfo(Person personita1) {
        throw new UnsupportedOperationException("Unimplemented method 'showPersonInfo'");
    }

    private static void extracted(Person personita1) {
        System.out.println("INFORMACIÓN DE LA PERSONA");
        System.out.printf("La persona se llama %s, mide %.2f y pesa %.2f\n", personita1.getName(),personita1.getHeightInMeters(),personita1.getWeightInKg());
    }
}