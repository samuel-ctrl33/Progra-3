import static com.coti.tools.Esdia.*;
import model.Coche;
import model.concesionario;

//cada ejercicio CRUD tendra un app.java y luego un modelo con add, remove, read e update
//en el app.java no tiene que aparecer ningun system.out

public class App {
public static void main(String[] args) throws Exception {

public static Concesionario concesionario = new concesionario();



int opcion;
do{
System.out.println("\n--- MENU CRUD ---");
System.out.println("1. Agregar coche");
System.out.println("2. Eliminar coche");
System.out.println("3. Modificar coche");
System.out.println("4. Listar coches");
System.out.println("5. Salir");
opcion = Esdia.readInt("Ingrese una opción: ");

switch (opcion) {
case 1:
agregarCoche();
break;
case 2:
eliminarCoche();
break;
case 3:
modificarCoche();
break;
case 4:
listarCoches();
break;
case 5:
System.out.println("¡Hasta luego!");
break;
default:
System.out.println("Opción no válida.");
}
} while (opcion != 5);
}

public static void agregarCoche(Concesionario c) {
String matricula = Esdia.readString("Ingrese la matricula del coche: ");
String modelo = Esdia.readString("Ingrese el modelo del coche: ");
coches.add(new Coche(matricula, modelo));

c
concesionario.addCoche(new Coche(matricula, modelo));

}

public static void eliminarCoche() {

String matricula = Esdia.readString("Ingrese la matricula del coche a eliminar: ");
Coche cocheAEliminar = null;

for (Coche coche : coches) {
if (coches.getMatricula().equals(matricula)) {
cocheAEliminar = coche;
break;
}
}
if (cocheAEliminar != null) {
coches.remove(cocheAEliminar);
System.out.println("Coche eliminada.");
} else {
System.out.println("Coche no encontrada.");
}
}

public static void modificarCoche() {

String matricula = Esdia.readString("Ingrese la matricula a modificar: ");
Coche cocheAModificar = null;
for (Coche coche : coche) {
if(coche.getMatricula().equals(matricula)) {
cocheAModificar = coche;
break;
}
}
if (cocheAModificar != null) {
String nuevoMatricula = Esdia.readString("Ingrese la nueva matricula: ");
int nuevaModelo = Esdia.readInt("Ingrese el nuevo modelo: ");

cocheAModificar.setMatricula(nuevaMatricula);
cocheAModificar.setModelo(nuevoModelo);
} else {
System.out.println("Coche no encontrado.");
}
}

public static void listarCoches(concesionario c) {

ArrayList coche = c.getCoches();
if (coche.isEmpty()) {
System.out.println("No hay personas en la lista.");
return;
}

for (Coche coche : coche) {
System.out.println(coche.comoFilaDeTabla());
}
}

public String getMatricula() {
return matricula;
}

public String getModelo() {
return modelo;
}

public void setMatricula(String matricula) {
this.matricula = matricula;
}

public void setModelo(String modelo) {
this.modelo = modelo;
}
}