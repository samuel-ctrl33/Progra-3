package model;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class BinaryRepository implements PersistenceRepository {

    Path ruta = java.nio.file.Paths.get(System.getProperty("user.home"), "Desktop", "datos.bin");

    // NOTA: este enfoque es simple pero no es eficiente para grandes volúmenes de datos.
    // Se reescribe todo el archivo cada vez que se añade, elimina o actualiza un alumno.

    private boolean saveAlumnos(ArrayList<Alumno> alumnos) {
        java.io.ObjectOutputStream oos = null;
        try {
            oos = new java.io.ObjectOutputStream(Files.newOutputStream(ruta));
            oos.writeObject(alumnos);
            return true;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean addAlumno(Alumno alumno) {
        ArrayList<Alumno> alumnos = getAllAlumnos();
        alumnos.add(alumno);
        return saveAlumnos(alumnos);
    }

    @Override
    public boolean removeAlumnoByDNI(String DNI) {
        ArrayList<Alumno> alumnos = getAllAlumnos();
        Alumno alumnoAEliminar = new Alumno(DNI, "", "", "");
        if (alumnos.remove(alumnoAEliminar)) {
            return saveAlumnos(alumnos);
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<Alumno> getAllAlumnos() {
        if (!Files.exists(ruta)) {
            return new ArrayList<>();
        }
        java.io.ObjectInputStream ois = null;
        try {
            ois = new java.io.ObjectInputStream(java.nio.file.Files.newInputStream(ruta));
            return (ArrayList<Alumno>) ois.readObject();
        } catch (java.io.IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Alumno getAlumnoByDNI(String DNI) {
        ArrayList<Alumno> alumnos = getAllAlumnos();
        for (Alumno a : alumnos) {
            if (a.getDNI().equals(DNI)) {
                return a;
            }
        }
        return null;
    }

    @Override
    public boolean updateAlumno(Alumno alumno) {
        ArrayList<Alumno> alumnos = getAllAlumnos();
        int index = alumnos.indexOf(alumno);
        if (index != -1) {
            alumnos.set(index, alumno);
            return saveAlumnos(alumnos);
        }
        return false;
    }
    
}
