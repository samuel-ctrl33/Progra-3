package model;

import java.util.ArrayList;

/**
 *
 * Esta interfaz representa un contrato para la persistencia de los datos de la aplicación.
 * 
 *  Reading: https://www.baeldung.com/java-dao-vs-repository
 * 
 * @author Loza
 */
public interface PersistenceRepository {
    
    // Operaciones CRUD básicas
    // De momento con tipos de retorno simples
    // Más adelante se podrían definir excepciones propias para los errores
    // de persistencia, etc.

    public boolean addAlumno(Alumno alumno);

    public boolean removeAlumnoByDNI(String DNI);

    public ArrayList<Alumno> getAllAlumnos();

    public Alumno getAlumnoByDNI(String DNI);

    public boolean updateAlumno(Alumno alumno);
    
    
}
