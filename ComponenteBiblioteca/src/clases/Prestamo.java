/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Prestamo {
    int id_prestamo;
    int id_libro;
    Date fecha_prestamo;
    Date fecha_devolucion;

    public Prestamo(int id_prestamo, int id_libro, Date fecha_prestamo, Date fecha_devolucion) {
        this.id_prestamo = id_prestamo;
        this.id_libro = id_libro;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id_prestamo=" + id_prestamo + ", id_libro=" + id_libro + ", fecha_prestamo=" + fecha_prestamo + ", fecha_devolucion=" + fecha_devolucion + '}';
    }
    
}
