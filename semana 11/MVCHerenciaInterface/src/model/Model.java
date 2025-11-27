package model;

import java.util.List;

/**
 *
 * @author Loza
 */
public class Model {

    // Va gestionar el estado de los alumnos y el acceso a ellos
    private PersistenceRepository repository;

    public Model(PersistenceRepository repository) {
        this.repository = repository;
    }

    /**
     * *
     *
     * Carga el estado de la aplicación desde el repositorio.
     *
     * @return true si se ha podido cargar, false en caso contrario.
     */
    public boolean cargarEstadoAplicación() {
        // Intentamos obtener los alumnos para verificar que el repositorio es accesible
        try {
            repository.getAllAlumnos();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // NOTA: La logica de negocio (reglas de negocio como evitar añadir duplicados)
    // se implementa en el modelo utilizando el repositorio
    // No en cada uno de los repositorios.

    /**
     * *
     * Utiliza el repositorio para agregar un alumno si este no existe ya.
     *
     * @param alumno
     * @return true si no existía el alumno, false en caso contrario.
     */
    public boolean agregarAlumno(Alumno alumno) {
        // Consulta al repositorio y si no existe lo añade
        if (repository.getAlumnoByDNI(alumno.getDNI()) != null) {
            return false;
        }
        return repository.addAlumno(alumno);
    }

    /**
     * *
     *
     * Utiliza el repositorio para eliminar un alumno por DNI si este existe.
     * 
     * @param DNI
     * @return true si existía el alumno, false en caso contrario.
     */
    public boolean eliminarAlumnoPorDNI(String DNI) {
        if (repository.getAlumnoByDNI(DNI) != null) {
            return repository.removeAlumnoByDNI(DNI);
        }
        return false;
    }

    /**
     * 
     * Modifica un alumno existente en el repositorio.
     * 
     * @param alumno
     * @return true si el alumno fue modificado, false si no existe.
     */
    public boolean modificarAlumno(Alumno alumno) {
        if (repository.getAlumnoByDNI(alumno.getDNI()) != null) {
            return repository.updateAlumno(alumno);
        }
        return false;
    }

    /**
     * *
     *
     * Obtiene la lista de alumnos del repositorio.
     *
     * @return lista de alumnos.
     */
    public List<Alumno> obtenerAlumnosDelModelo() {
        return repository.getAllAlumnos();
    }


}
