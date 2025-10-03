public class Persona {
    
    // Atributos    
    private String nombre;
    private int edad;
    private double altura;

    // Constructor vacío
    public Persona() {} //Al definir un constructor con parametros el vacio no lo generaría java automaticamente con lo cual lo defino por si lo necesitase

    // Constructor con parámetros
    public Persona(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }

    // Método de ejemplo
    public void mostrarInfo() {
        System.out.println(nombre + " tiene " + edad + " años y mide " + altura + "m");
    }
}