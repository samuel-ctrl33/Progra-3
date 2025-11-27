package model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Loza
 */
public class TSVRepository implements PersistenceRepository {

    Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "datos.tsv");
    String delimitador = "\t";


    // NOTA: este enfoque es simple pero no es eficiente para grandes volúmenes de datos.
    // Se reescribe todo el archivo cada vez que se añade, elimina o actualiza un alumno.
    
    private boolean saveAlumnos(List<Alumno> alumnos) {
        List<String> lines = new ArrayList<>();
        for (Alumno a : alumnos) {
            lines.add(a.getInstanceAsDelimitedString(delimitador));
        }
        try {
            Files.write(ruta, lines, StandardCharsets.UTF_8);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // NOTA: se ha aprovechado la implementación de equals y hashcode en Alumno
    // para simplificar las operaciones sobre la colección

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

    @Override
    public ArrayList<Alumno> getAllAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        if (!Files.exists(ruta)) {
            return alumnos;
        }
        try {
            List<String> lines = Files.readAllLines(ruta, StandardCharsets.UTF_8);
            for (String line : lines) {
                Alumno a = Alumno.getPersonFromDelimitedString(line, delimitador);
                if (a != null) {
                    alumnos.add(a);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return alumnos;
    }

    @Override
    public Alumno getAlumnoByDNI(String DNI) {
        ArrayList<Alumno> alumnos = getAllAlumnos();
        Alumno alumnoABuscar = new Alumno(DNI, "", "", "");
        int index = alumnos.indexOf(alumnoABuscar);
        if (index != -1) {
            return alumnos.get(index);
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
