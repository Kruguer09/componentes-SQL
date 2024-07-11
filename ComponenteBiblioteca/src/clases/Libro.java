/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Usuario
 */
public class Libro {
    int id_libro;
    String titulo;
    int anyo_publicacion;
    String Autor;

    public Libro(int id_libro, String titulo, int anyo_publicacion, String Autor) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.anyo_publicacion = anyo_publicacion;
        this.Autor = Autor;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnyo_publicacion() {
        return anyo_publicacion;
    }

    public void setAnyo_publicacion(int anyo_publicacion) {
        this.anyo_publicacion = anyo_publicacion;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    @Override
    public String toString() {
        return "Libro{" + "id_libro=" + id_libro + ", titulo=" + titulo + ", anyo_publicacion=" + anyo_publicacion + ", Autor=" + Autor + '}';
    }
    
}
