package DAO;

import interfas.personalimp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.personalM;
import modelo.rutaM;

public class personalD extends Dao implements personalimp {

    @Override
    public void registrar(personalM personal) throws Exception {
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
    public List<personalM> listar() throws Exception {
         this.Conexion();
        List<personalM> list;
        ResultSet rs;
        try {
            String sql = "";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            personalM personal;
            while (rs.next()) {
                personal = new personalM();
            }
            return list;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void actualizar(personalM personal) throws Exception {
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
