
package clases;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;


public class VerRegistros {
    String usuario;
    String password;
    
    public VerRegistros(){
        this.usuario="root";
        this.password="";
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

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "VerRegistros{" + "usuario=" + usuario + ", password=" + password + '}';
    }
    //Implementamos el método accesoDB que muestra el contenido en una atabla JTable
    //Por cada línea se mostrará el número de tupla fila) y la info en las columnas
    //Además vamos a mostrar el número de registros
    
    public DefaultTableModel accesoBD(JTable jt_Modulos){
        String sDriver="com.mysql.cj.jdbc.Driver";
        String rURL="jdbc:mysql://";
        String db_name="modulosinf";
        String db_host="localhost";
        String time_zone="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String db_user=getUsuario();
        String db_pw=getPassword();
        String sURL=rURL+db_host+"/"+db_name+time_zone;
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        
        ResultSet devolverResultado=null;
        ArrayList<Modulo> arrayModulos=null;
        DefaultTableModel model=null;
        Modulo modulo;
        try{
            conn=DriverManager.getConnection(sURL,db_user,db_pw);
            String query = "SELECT * FROM modulos";
            try{
                stmt=conn.createStatement();
                rs=stmt.executeQuery(query);
                devolverResultado=rs;
                if(devolverResultado!=null){
                    arrayModulos=new ArrayList();
                    try{
                        while(rs.next()){
                            modulo=new Modulo(rs.getString("siglasciclo"),
                            rs.getString("siglasmodulo"),rs.getString("nombremodulo"),
                            rs.getInt("horassemanales"));
                            arrayModulos.add(modulo);
                        }
                        rs.close();
                    }catch(SQLException ex){
                        System.out.println(ex.getMessage());
                    }
                    rs=null;
                }
                model=(DefaultTableModel) jt_Modulos.getModel();
                int rowCount =model.getRowCount();
                for (int i=rowCount-1;i>=0;i--){
                    model.removeRow(i);
                }
                int contador=1;
                for(Modulo m:arrayModulos){
                    model.addRow(new Object[]{contador,
                        m.getSiglasCiclo(),
                        m.getSiglasModulo(),
                        m.getNombreModulo(),
                        m.getHorasSemanales()
                    });
                    contador++;
                    
                }
                
            }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getErrorCode());
        }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getSQLState());
            System.out.println(ex.getErrorCode());
        }
        
        
        return model;
    }
            
}
