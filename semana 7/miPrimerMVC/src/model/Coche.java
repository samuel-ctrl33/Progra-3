package model;

public class Coche {

    private String marca;
    private String modelo;
    private String numBastidor;

    public  Coche(String marca, String modelo, String numBastidor){
        this.marca=marca;
        this.modelo=modelo;
        this.numBastidor=numBastidor;
    }
    
    public static String ObtenerCabeceroTabla(){
        return String.format("|%15s||%15s||%15s|","Marca","Modelo","Num.Bastidor");
    }
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumBastidor() {
        return numBastidor;
    }

    public void setNumBastidor(String numBastidor) {
        this.numBastidor = numBastidor;
    }

    
    
    
}
