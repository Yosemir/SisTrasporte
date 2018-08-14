
package DAO;

import interfas.clienteimp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.clienteM;


public class clienteD extends Dao implements clienteimp{

    @Override
    public void registrar(clienteM cliente) throws Exception {
           this.Conexion();
        try {
            String sql = "";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<clienteM> listar() throws Exception {
             this.Conexion();
        List<clienteM> list;
        ResultSet rs;
        try {
            String sql = "";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            clienteM cliente;
            while (rs.next()) {
                cliente = new clienteM();
            }
            return list;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void actualizar(clienteM cliente) throws Exception {
        this.Conexion();
        try {
            String sql = "";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    
    
}
