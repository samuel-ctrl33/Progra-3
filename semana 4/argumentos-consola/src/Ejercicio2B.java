public class Ejercicio2B {
    public static void main(String[] args) {
        Usuario[] usuarios = new Usuario[3];
        usuarios[0] = Usuario.crearUsuario(new String[]{"Kaká", "40", "1.80"});
        usuarios[1] = Usuario.crearUsuario(new String[]{"Eusebio", "65", "1.78"});
        usuarios[2] = Usuario.crearUsuario(new String[]{"Luis", "5", "1.5"});
        usuarios[3] = Usuario.crearUsuario(new String[]{"Samuel", "19", "1.81"});

        System.out.println(usuarios[0].obtenerCabeceraTablaUsuario());
        for(Usuario u : usuarios) {
            if(u != null){
            System.out.println(u.obtenerUsuarioComoFila());    
            }else{
                System.out.println("Usuario no valido");
            }
        }
    }
}