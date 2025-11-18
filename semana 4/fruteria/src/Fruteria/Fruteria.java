package Fruteria;
public class Fruteria {
    private String nombreFruta;
    private double precioPorKilo;
    private double cantidad;
    private final double IVA = 0.21;

    public Fruteria(String nombreFruta, double precioPorKilo){
        this.nombreFruta=nombreFruta;
        this.precioPorKilo=precioPorKilo;
    }

    public String getNombreFruta() {
        return nombreFruta;
    }

    public void setNombreFruta(String nombreFruta) {
        this.nombreFruta = nombreFruta;
    }

    public double getPrecioPorKilo() {
        return precioPorKilo;
    }

    public void setPrecioPorKilo(double precioPorKilo) {
       this.precioPorKilo = precioPorKilo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioConIVA() {
        final double IVA = 0.21;
        return precioPorKilo * (1 + IVA);
    }

    public double getPrecioTotal() {
        return getPrecioConIVA() * cantidad;
    }

    public double getPrecioTotalConIVA() {
        return (precioPorKilo * cantidad * (1 + IVA));
    }
}
