public class Usuario {
 
    private String nombre;
    private float peso;
    private float altura;

    //Constructor qu epermite crear un objeto Usuario
    public Usuario(String nombre, float peso, float altura) {
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
    }

    /**
     * Metodo estatico para la creacion de instancia Usuario
     *         
     * @param datos de array de string con Nombre, Peso y Altura
     * @return una instancion de Usuario o null en caso contrario
    */

    public static Usuario crearUsuario(String[] datos) {
        
       if(datos.length != 3) {
           System.out.println("Error: Se requieren 3 argumentos: Nombre, Peso y Altura");
           return null;
       }

       try{
        String nombre = datos[0];
        float peso = Float.parseFloat(datos[1]);
        float altura = Float.parseFloat(datos[2]);

        return new Usuario(nombre, peso, altura);
        } catch(NumberFormatException e) {
            System.out.println("Error: Peso y Altura deben ser numeros validos");
            return null;
        }
        
    }

    //metodo instancia ya que se necesita rellenar datos
    public float obtenerIMC() {
        return peso / (altura * altura);
    }


    /**
     * Metodo que devuelve los datos del usuario en formato CSV
     * @return 
     */
    public String obtenerUsuarioComoFila() {
        return  String.format("|%10s||%10.2f||%10.2f||%10.2f|", nombre, peso, altura, obtenerIMC());
    }

    
    /**
     * Metodo que devuelve la cabecera de una tabla con la informacion del Usuario
     * Los datos son: Nombre, Peso, Altura, IMC
     * @return 
     */
    public String obtenerCabeceraTablaUsuario() {
        return  String.format("|%10s||%10s||%10s||%10s|", "nombre", "peso", "altura", "IMC");
    }

    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }
    public int getAltura() {
        return (int) altura;
    }
}
