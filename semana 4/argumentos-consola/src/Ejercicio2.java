public class Ejercicio2 {
    public static void main(String[] args) {
        
        Usuario user1 = Usuario.crearUsuario(args);
        
        if(user1 != null) {
            System.out.println(user1.obtenerCabeceraTablaUsuario());
            System.out.printf(user1.obtenerUsuarioComoFila());
        }else{
            System.out.println("No se pudo crear el usuario debido a errores en los argumentos.");
        }
    }
}
