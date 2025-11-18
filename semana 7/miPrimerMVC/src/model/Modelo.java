package model;

import java.util.ArrayList;

public class Modelo {
    
    private ArrayList<Coche> coches;


    public Modelo (){
        coches = new ArrayList<>();
    }

    public String agregarCoche (Coche coche){

        for(Coche c : coches){
            if(c.getNumBastidor().equals(coche.getNumBastidor())){
                return "YA HAY UN COCHE CON ESE NUMERO DE BASTIDOR";
            }
        }

        coches.add(coche);
        return "Añadido correctamente";
    }

    public ArrayList<Coche> getCoches(){
        return coches;
    }

    public String eliminarCoche(Coche coche) {
        if (coches.remove(coche)) { //aqui es donde se elimina realmente
            return "Coche eliminado correctamente";
        } else {
            return "El coche no existe en la lista";
        }
    }
}

