package paquete1;

//Sin modificador solo se puede acceder desde el propio paquete, no desde paquetes externos
class clase2 {
    public String nombre;
    int edad;
    protected String color;
    private int talla;

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