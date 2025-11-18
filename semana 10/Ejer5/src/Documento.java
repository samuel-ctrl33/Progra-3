public class Documento extends Archivo implements Imprimible , Compartible {
    
    public Documento(String nombre, int tamanio){
        super(nombre,tamanio);
    
    
    }

    @Override
    public void imprimir() {

    }

    @Override
    public void compartir(String plataforma) {
    
    }
    
    


}
