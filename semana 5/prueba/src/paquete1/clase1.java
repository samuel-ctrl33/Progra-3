package paquete1;

public class clase1 {
    public String nombre;
    int edad; //Este es default y con lo cual tampoco se puede acceder
    protected String color; //No hay herencia por eso da error al acceder a el
    private int talla; //Este es privado con lo cual no se puede acceder

    public String nombrePublic(){
        return nombre;
    };

    void suEdad() {};
    protected  String suColor(){
        return color;
    };

    private int suTalla(){
        return edad;};


}