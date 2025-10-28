package model;

import java.util.ArrayList;
import controlador.Controlador;

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
        return "";
    }

    

}

