package model;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 *
 * @author Loza
 */
public class JSONRepository implements PersistenceRepository {

    Path ruta = Paths.get(System.getProperty("user.home"), "Desktop", "datos.json");


    // NOTA: este enfoque es simple pero no es eficiente para grandes volúmenes de datos.
    // Se reescribe todo el archivo cada vez que se añade, elimina o actualiza un alumno.
    
    private boolean saveAlumnos(List<Alumno> alumnos) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(alumnos);
            Files.write(ruta, json.getBytes(StandardCharsets.UTF_8));
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
            //Leer de JSON
            Gson gson = new Gson();
            // Lee todo el archivo en un String
            String json = new String(Files.readAllBytes(ruta), StandardCharsets.UTF_8);
            // Obtiene el tipo de la lista
            Type tipoDeLista = new TypeToken<ArrayList<Alumno>>() {}.getType();
            alumnos = gson.fromJson(json, tipoDeLista);

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
        return false;
    }

}