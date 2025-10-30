package model;

import java.util.ArrayList;

public class concesionario {

    private ArrayList<Coche> coches = new ArrayList<>();

    public concesionario() {

        coches = new ArrayList<>();

    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }

    public void setCoches(ArrayList<Coche> coches) {
        this.coches = coches;
    }

    // CRUD

    public void addCoche(Coche c) {
        coches.add(c);
    }
}
