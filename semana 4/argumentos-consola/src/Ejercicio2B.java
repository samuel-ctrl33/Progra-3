public class Ejercicio2B {
    public static void main(String[] args) {
        Usuario[] usuarios = new Usuario[3]; //array de 3 usuarios  
        usuarios[0] = Usuario.crearUsuario(new String[]{"Kaká", "40", "1.80"}); //array con los 3 datos
        usuarios[1] = Usuario.crearUsuario(new String[]{"Eusebio", "65", "1.78"});
        usuarios[2] = Usuario.crearUsuario(new String[]{"Luis", "5", "1.5"});

        System.out.println(usuarios[0].obtenerCabeceraTablaUsuario()); //da igual que indice pongas porque todos llaman al mismo
        for(Usuario u : usuarios) {
            if(u != null){
            System.out.println(u.obtenerUsuarioComoFila());    
            }else{
                System.out.println("Usuario no valido");
            }
        }
    }
}