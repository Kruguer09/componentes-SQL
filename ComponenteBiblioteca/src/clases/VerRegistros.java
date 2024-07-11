/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class VerRegistros {

    String usuario;
    String password;
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    boolean conectado = false;
  

   

    public VerRegistros() {
        this.usuario = "root";
        this.password = "";

    }

    public VerRegistros(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public boolean isConectado() {
        return conectado;
    }

    

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "VerRegistros{" + "usuario=" + usuario + ", password=" + password + '}';
    }

    // TODO UNA CLASE QUE SOLO CONECTA Y DOS, UNO PARA CADA TABLA
    public boolean ConectaDB() {
        String sDriver = "com.mysql.cj.jdbc.Driver";
        String rURL = "jdbc:mysql://";
        String db_name = "biblioteca2";
        String db_host = "localhost";
        String time_zone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String db_user = getUsuario();
        String db_pw = getPassword();
        String sURL = rURL + db_host + "/" + db_name + time_zone;
        //conn=null;
        try {
            conn = DriverManager.getConnection(sURL, db_user, db_pw);
            conectado = true;
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    public boolean DesconectaDB() {
        conn = null;
        conectado = false;
        return true;
    }

    public DefaultTableModel CargatablaLibros(JTable jt_libros) {
        if (!conectado) {
            conectado = ConectaDB();

        }
        ResultSet devolverResultado = null;
        ArrayList<Libro> arrayLibros = null;
        DefaultTableModel model = null;
        Libro libro;
        String query = "SELECT * FROM libros";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            devolverResultado = rs;
            if (devolverResultado != null) {
                arrayLibros = new ArrayList();
                try {
                    while (rs.next()) {
                        libro = new Libro(rs.getInt("id_libro"),
                                rs.getString("titulo"), rs.getInt("anyo_publicacion"),
                                rs.getString("autor"));
                        arrayLibros.add(libro);
                    }
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                rs = null;
            }
            model = (DefaultTableModel) jt_libros.getModel();
            int rowCount = model.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            int contador = 1;
            for (Libro m : arrayLibros) {
                model.addRow(new Object[]{contador,
                    m.getId_libro(),
                    m.getTitulo(),
                    m.getAnyo_publicacion(),
                    m.getAutor()

                });
                contador++;

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getErrorCode());
        }
        return model;
    }

    public DefaultTableModel CargatablaPrestamos(JTable jt_prestamos) {
        if (!conectado) {
            conectado = ConectaDB();

        }
        ResultSet devolverResultado = null;
        ArrayList<Prestamo> arrayPrestamos = null;
        DefaultTableModel model = null;
        Prestamo prestamo;
        String query = "SELECT * FROM prestamos";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            devolverResultado = rs;
            if (devolverResultado != null) {
                arrayPrestamos = new ArrayList();
                try {
                    while (rs.next()) {
                        prestamo = new Prestamo(rs.getInt("id_prestamo"),
                                rs.getInt("id_libro"), rs.getDate("fecha_prestamo"),
                                rs.getDate("fecha_devolucion"));
                        arrayPrestamos.add(prestamo);
                    }
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                rs = null;
            }
            model = (DefaultTableModel) jt_prestamos.getModel();
            int rowCount = model.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            int contador = 1;
            for (Prestamo m : arrayPrestamos) {
                model.addRow(new Object[]{contador,
                    m.getId_prestamo(),
                    m.getId_libro(),
                    m.getFecha_prestamo(),
                    m.getFecha_devolucion()
                });
                contador++;

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getErrorCode());
        }
        return model;
    }
}
