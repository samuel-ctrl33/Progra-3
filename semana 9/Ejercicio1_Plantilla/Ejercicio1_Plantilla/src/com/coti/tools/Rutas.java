package com.coti.tools;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Clase utilitaria para gestionar rutas de archivos
 */
public class Rutas {
    
    /**
     * Obtiene la ruta de un archivo en el escritorio del usuario
     * @param nombreArchivo Nombre del archivo
     * @return Path con la ruta completa del archivo en el escritorio
     */
    
    public static Path pathToFileOnDesktop(String nombreArchivo) {
        String desktopPath = System.getProperty("user.home") + "\\Desktop";
        return Paths.get(desktopPath, nombreArchivo);
    }
}
