import java.util.Scanner;
public class App{
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        int numero1 = sc.nextInt();
        
        System.out.print("Introduce otro numero: ");
        int numero2 = sc.nextInt();

        System.out.println("Elige que operacion llevar a cabo (1-suma, 2-resta, 3-multiplicacion, 4-division): ");
        int operacion = sc.nextInt();

        if(operacion==1){
            System.out.println("El resultado de la suma es: " + (numero1+numero2));
        }else if(operacion==2){
            System.out.println("El resultado de la resta es: " + (numero1-numero2));
        }else if(operacion==3){
            System.out.println("El resultado de la multiplicacion es: " + (numero1*numero2));
        }else if(operacion==4){
            System.out.println("El resultado de la division es: " + (numero1/numero2));
        }

        sc.close();
    }
}