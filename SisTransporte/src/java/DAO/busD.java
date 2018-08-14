package DAO;

import interfas.busimp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.busM;

public class busD extends Dao implements busimp {

    @Override
    public void registrar(busM bus) throws Exception {
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
    public List<busM> listar() throws Exception {
        this.Conexion();
        List<busM> list;
        ResultSet rs;
        try {
            String sql = "";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            busM viaje;
            while (rs.next()) {
                viaje = new busM();
            }
            return list;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void actualizar(busM bus) throws Exception {
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
