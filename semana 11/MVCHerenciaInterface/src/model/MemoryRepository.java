package model;

import java.util.ArrayList;

/**
 *
 * 
 * Repositorio en memoria que sirve para simular un numero de alumnos que se carguen
 * o se guarden en una fuente externa que se implemente PersistenceRepository.
 * 
 * El constructor permite crear varios alumnos genéricos.
 * 
 * @author Loza
 */
public class MemoryRepository implements PersistenceRepository {

    ArrayList<Alumno> alumnos;

    public MemoryRepository(int numeroAlumnosACrear) {

        alumnos = new ArrayList<>();
        // Fake repository
        for (int i = 0; i < numeroAlumnosACrear; i++) {
            alumnos.add(new Alumno("" + i, "Nombre" + i, "Apellido" + i, "Apellido" + i));
        }
    }

    // NOTA: se ha aprovechado la implementación de equals y hashcode en Alumno
    // para simplificar las operaciones sobre la colección
    // Fíjate en las diferentes operaciones de CRUD implementadas más abajo.

    @Override
    public boolean addAlumno(Alumno alumno) {
        return alumnos.add(alumno);
    }

    @Override
    public boolean removeAlumnoByDNI(String DNI) {
        Alumno alumnoAEliminar = new Alumno(DNI, "", "", "");
        if (alumnos.remove(alumnoAEliminar)) {
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Alumno> getAllAlumnos() {
        return new ArrayList<>(alumnos);
    }

    @Override
    public Alumno getAlumnoByDNI(String DNI) {
        Alumno alumnoABuscar = new Alumno(DNI, "", "", "");
        int index = alumnos.indexOf(alumnoABuscar);
        if (index != -1) {
            return alumnos.get(index);
        }
        return null;
    }

    @Override
    public boolean updateAlumno(Alumno alumno) {
        int index = alumnos.indexOf(alumno);
        if (index != -1) {
            alumnos.set(index, alumno);
            return true;
        }
        return false;
    }

}
