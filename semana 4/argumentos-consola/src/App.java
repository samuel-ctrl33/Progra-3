public class App {
    public static void main(String[] args) throws Exception {
        
        if(args.length==2){
            String param1 = args[0];
            String param2 = args[1];
        try {
            float valor1 = Float.parseFloat(param1);
            float valor2 = Float.parseFloat(param2);

            System.out.printf("El resultado de la suma de %.2f + %.2f es %.2f%n", valor1, valor2, (valor1 + valor2));
        } catch (Exception e) {
        System.err.println("ERROR DEBES INTRODUCIR PARÁMETROS NUMÉRICOS");
        }
        }else{
            System.err.println("ERROR DEBES INTRODUCIR 2 ARGUMENTOS PARA EL EJERCICIO");
        }        
    }
}
