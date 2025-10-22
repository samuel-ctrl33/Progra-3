package model;

public class Coche {
String matricula;
String modelo;

public Coche(String matricula, String modelo) {
this.matricula = matricula;
this.modelo = modelo;
}

public String getMatricula() {
return matricula;
}

public void setMatricula(String matricula) {
this.matricula = matricula;
}

public String getModelo() {
return modelo;
}

public void setModelo(String modelo) {
this.modelo = modelo;
}

public String comoFilaDeTabla() {
return String.format("| %-10s | %-10s |", matricula, modelo);
}

}
