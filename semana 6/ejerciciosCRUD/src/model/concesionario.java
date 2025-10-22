package model;

import java.awt.geom.CubicCurve2D;
import java.util.ArrayList;

public class concesionario{

private ArrayList coches = new ArrayList<>();

public concesionario() {

coches = new ArrayList<>();

}

public ArrayList getCoches() {
return coches;
}

public void setCoches(ArrayList coches) {
this.coches = coches;
}

//CRUD

public void addCoche(Coche c) {
coches.add(c);
}
}

