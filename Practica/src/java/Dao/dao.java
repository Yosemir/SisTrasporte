
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class dao {
    
    private Connection cn;

    public void conexion(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=Trasporte","root","vallegrande2018");
            System.out.println("Conexión");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error"+e);
        }
    }
    
    
    public void cerrar() throws SQLException{
        if (cn != null) {
            if (cn.isClosed() == false) {
                cn.isClosed();
                
            }
            
        }
    }
    
    public static void main(String[] args) {
        dao Dao = new dao();
        Dao.conexion();
        
    }
    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
}
