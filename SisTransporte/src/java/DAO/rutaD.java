package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.rutaM;
import interfas.rutaimp;

public class rutaD extends Dao implements rutaimp {

    @Override
    public void registrar(rutaM viaje) throws Exception {
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
    public List<rutaM> listar() throws Exception {
        this.Conexion();
        List<rutaM> list;
        ResultSet rs;
        try {
            String sql = "";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            rutaM viaje;
            while (rs.next()) {
                viaje = new rutaM();
            }
            return list;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void actualizar(rutaM viaje) throws Exception {
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
