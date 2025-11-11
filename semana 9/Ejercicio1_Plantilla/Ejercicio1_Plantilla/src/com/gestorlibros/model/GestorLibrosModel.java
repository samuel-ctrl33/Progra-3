package com.gestorlibros.model;

import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.coti.tools.Rutas;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GestorLibrosModel {

    ArrayList<Libro> libros;

    // Path to export and import data
    Path pathToXML = Rutas.pathToFileOnDesktop("libros.xml");
    Path pathToJSON = Rutas.pathToFileOnDesktop("libros.json");
    Path pathToCSV = Rutas.pathToFileOnDesktop("libros.csv");
    Path pathToBinary = Rutas.pathToFileOnDesktop("libros.bin");

    public GestorLibrosModel() {
        libros = new ArrayList<Libro>();
    }

    // CRUD OPERATIONS
    public void addLibro(Libro l) {
        libros.add(l);
    }

    public void removeLibro(Libro l) {
        libros.remove(l);
    }

    public void updateLibro(Libro l) {
        libros.set(libros.indexOf(l), l);
    }

    public ArrayList<Libro> getLibros() {
        // Devolvemos copia para no modificar el original desde la vista.
        return new ArrayList<Libro>(this.libros);
    }

    // Export and Import data ------------------------------------------
    public int exportBooksToCSV() {
        throw new UnsupportedOperationException("Unimplemented method 'importBooksFromCSV'");
    }

    public int importBooksFromCSV() {
        
    }

    public int exportBooksToJSON() {
        //¿como, json libros?
        //¿donde?
        try{
            Gson gson = new Gson();
            String json = gson.toJson(libros);
            Files.write(pathToJSON, json.getBytes(StandardCharsets.UTF_8));
            return 0;
        }catch(exception e){
            return -1;
        }
        
    }

    public int importBooksFromJSON() {
       try {
        Gson gson = new Gson();
        // Lee todo el archivo en un String
        String json = new String(Files.readAllBytes(pathToJSON), StandardCharsets.UTF_8);
        // Obtiene el tipo de la lista
        Type tipoDeLista = new TypeToken<ArrayList<Libro>>() {}.getType();
        ArrayList<Libro> libros = gson.fromJson(json, tipoDeLista);

        //this.libros = libros;
        //this.libros=addAll(libros);
        //Solo se añaden los que no estan en la coleccion
        for(Libro libro : libros){
            if(!this.libros.contains(libro)){
                this.libros.add(libro);
            }
        }

        return 0;
        
        } catch (Exception e) {
        return -1;
       }
    }

    public int importBooksFromXML() {
        throw new UnsupportedOperationException("Unimplemented method 'importBooksFromCSV'");  
    }

    public int exportBooksToXML() {
        throw new UnsupportedOperationException("Unimplemented method 'importBooksFromCSV'");
    }

    // Serialization and Deserialization ------------------------------------------
    public int saveStateOfTheApp(){
        throw new UnsupportedOperationException("Unimplemented method 'importBooksFromCSV'");
    }

    public int loadStateOfTheApp(){
        throw new UnsupportedOperationException("Unimplemented method 'importBooksFromCSV'");
    }



}
