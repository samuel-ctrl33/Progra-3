package com.gestorlibros.view;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.coti.tools.DiaUtil;
import com.coti.tools.Esdia;
import com.gestorlibros.controller.Controller;
import com.gestorlibros.model.Libro;

public class View {

    Controller c;

    public void startMenu(){

        // Bucle infinito con Esdia

        boolean exit = false;

        while (!exit) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Mostrar el listado de libros en formato tabla.");
            System.out.println("2. Añadir nuevo libro al modelo.");
            System.out.println("3. Eliminar libro de una lista de libros disponibles.");
            System.out.println("4. Modificar libro de una lista de libros disponibles.");
            System.out.println("5. Exportar libros en formato delimitado por comas CSV.");
            System.out.println("6. Exportar libros en formato JSON.");
            System.out.println("7. Exportar libros en formato XML.");
            System.out.println("8. Importar libros de un fichero JSON.");
            System.out.println("9. Importar libros de un fichero XML.");
            System.out.println("10. Importar libros de un fichero en formato delimitado por comas CSV.");
            System.out.println("11. Salir del programa.");

            int option = Esdia.readInt("Ingrese una opción: ", 1, 11);

            switch (option) {
                case 1:
                    mostrarLibrosModelo(false);
                    break;
                case 2:
                    anadirLibroAlModelo();
                    break;
                case 3:
                    borrarLibroDelModelo();
                    break;
                case 4:
                    editarLibroDelModelo();
                    break;
                case 5:
                    exportarBooksCSV();
                    break;
                case 6:
                    exportarBooksJSON();
                    break;
                case 7:
                    exportBooksToXML();
                    break;
                case 8:
                    importarBooksJSON();
                    break;
                case 9:
                    importarBooksXML();
                    break;
                case 10:
                    importBooksFromCSV();
                    break;
                case 11:
                    exit = true;
                    //c.saveBooks();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }


    }

    private void importBooksFromCSV() {
        int resultado = c.importBooksFromCSV();
        if(resultado==0){
            System.out.println("Importado correctamente CSV");
        }else{
            System.out.println("Ha habido un problema en la importacion CSV");
        }
    }

    private void importarBooksXML() {
        int resultado = c.importBooksFromXML();
        if(resultado==0){
            System.out.println("Importado correctamente XML");
        }else{
            System.out.println("Ha habido un problema en la importacion XML");
        }
    }

    private void importarBooksJSON() {
        int resultado = c.importBooksFromJSON();
        if(resultado==0){
            System.out.println("Importado correctamente json");
        }else{
            System.out.println("Ha habido un problema en la importacion");
        }
    
    }

    private void exportBooksToXML() {
        int resultado = c.exportBooksToXML();
        if(resultado==0){
            System.out.println("Exportado correctamente XML");
        }else{
            System.out.println("Ha habido un problema en la exportación XML");
        }
    }


    private void exportarBooksJSON() {
        int resultado = c.exportBooksToJSON();
        if(resultado==0){
            System.out.println("Exportado correctamente json");
        }else{
            System.out.println("Ha habido un problema en la exportación a JSON.");
        }
    }

    private void exportarBooksCSV() {
        int resultado = c.exportBooksToCSV(); 
    
        if (resultado == 0) {
        System.out.println("Exportado correctamente a CSV.");
         } else {
        System.out.println("Ha habido un problema en la exportación a CSV.");
        }
    }


    private void editarLibroDelModelo() {
        // Mostrar libros disponibles para editar
        ArrayList<Libro> books = c.getLibros();
        if(books.size() == 0){
            System.out.println("No hay libros disponibles para editar.");
            return;
        }
        mostrarLibrosModelo(true);
        
        // Pedir índice del libro a editar
        int indice = Esdia.readInt("Seleccione el índice del libro a editar: ", 1, books.size());
        Libro libroAEditar = books.get(indice - 1);
        
        // Pedir nuevos datos
        System.out.println("Introduzca los nuevos datos (deje en blanco para no cambiar):");
        String nuevoTitulo = Esdia.readString("Nuevo título ["+libroAEditar.getTitulo()+ "]: ");
        if(!nuevoTitulo.isEmpty()) libroAEditar.setTitulo(nuevoTitulo);
        
        String nuevoAutor = Esdia.readString("Nuevo autor ["+libroAEditar.getAutor()+ "]: ");
        if(!nuevoAutor.isEmpty()) libroAEditar.setAutor(nuevoAutor);
        
        String nuevoISBN = Esdia.readString("Nuevo ISBN ["+libroAEditar.getISBN()+ "]: ");
        if(!nuevoISBN.isEmpty()) libroAEditar.setISBN(nuevoISBN);
        
        String nuevoEditorial = Esdia.readString("Nuevo editorial ["+libroAEditar.getEditorial()+ "]: ");
        if(!nuevoEditorial.isEmpty()) libroAEditar.setEditorial(nuevoEditorial);
        
        // Actualizar el libro
        c.updateLibro(libroAEditar);
        System.out.println("Libro actualizado correctamente.");
    }

    private void borrarLibroDelModelo() {
        // Mostrar libros disponibles para borrar
        ArrayList<Libro> books = c.getLibros();
        if(books.size() == 0){
            System.out.println("No hay libros disponibles para borrar.");
            return;
        }
        mostrarLibrosModelo(true);
        
        // Pedir índice del libro a borrar
        int indice = Esdia.readInt("Seleccione el índice del libro a borrar: ", 1, books.size());
        Libro libroABorrar = books.get(indice - 1);
        
        // Confirmar borrado
        String confirmar = Esdia.readString("¿Está seguro de que desea borrar el libro? (s/n): ");
        if(confirmar.equalsIgnoreCase("s")){
            c.removeLibro(libroABorrar);
            System.out.println("Libro eliminado correctamente.");
        }else{
            System.out.println("Operación cancelada.");
        }
    }

    private void anadirLibroAlModelo() {
        // Pedir información al usuario sobre el libro:
        String titulo = Esdia.readString_ne("Introduzca el título del libro: ");
        String autor = Esdia.readString_ne("Introduzca el autor del libro: ");
        String isbn = Esdia.readString_ne("Introduzca el ISBN del libro: ");
        String editorial = Esdia.readString_ne("Introduzca la editorial del libro: ");
        int anyoPublicacion = Esdia.readInt("Introduzca el año de publicación del libro: ");
        int numPaginas = Esdia.readInt("Introduzca el número de páginas del libro: ");
        float precio = Esdia.readFloat("Introduzca el precio del libro: ");

        // Crear el libro
        Libro l = new Libro(isbn, titulo, autor, editorial, anyoPublicacion, numPaginas, precio);

        // Comprobar si el libro existe en el modelo
        if (c.getLibros().contains(l)) {
            System.out.println("El libro ya existía en el modelo.");
        } else {
            // Añadir el libro al modelo
            c.addLibro(l);
            System.out.println("Libro añadido correctamente.");
        }
    }

    private void mostrarLibrosModelo(boolean showIndex) {
        // Obtener los libros del modelo
        ArrayList<Libro> books = c.getLibros();
        // Comprobar cuantos libros hay y mostrar mensjae
        if (books.size() == 0) {
            System.out.println("No hay libros disponibles.");
        } else {
            // Mostrar los libros
            // Cabecera
            if(showIndex) {
                System.out.println(String.format("| %6s ","Indice") + Libro.tableHeader());
            } else {
                System.out.println(Libro.tableHeader());
            }
            // Cuerpo
            for (Libro l : books) {
                if(showIndex) {
                    System.out.println(String.format("| %6d.", books.indexOf(l)+1) + l.asTableRow());
                } else {
                    System.out.println(l.asTableRow());
                }
            }
        }
    }

    public Controller getC() {
    return c;
    }

    public void setC(Controller c) {
        this.c = c;
    }

    public void showInfoMessage(String string) {
        System.out.println(string);
    }

    public void showErrorMessage(String string) {
        System.err.println(string);
    }
    
}
