package model;

import java.util.ArrayList;

public class concesionario {

    private ArrayList<Coche> coches = new ArrayList<>();

    public concesionario() {
        coches = new ArrayList<>();
    }

    public boolean isEmpty() {
        return coches.isEmpty();
    }

    // CRUD

    public void addCoche(Coche c) {
        coches.add(c);
    }

    public void removeCoche(Coche c){
        coches.remove(c);
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }

    public void setCoches(ArrayList<Coche> coches) {
        this.coches = coches;
    }

}
