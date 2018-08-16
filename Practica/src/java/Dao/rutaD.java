package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modelo.rutaM;
import interfaces.rutaimp;

public class rutaD extends dao implements rutaimp {
    
    @Override
    public void registrar(rutaM ruta) throws Exception {
        this.conexion();
        try {
            String sql = "insert into Rutas(NomRut,EstRut)values(?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, ruta.getNomrut());
            ps.setString(2, "A");
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
    @Override
    public List<rutaM> listar() throws Exception {
        this.conexion();
        List<rutaM> list;
        ResultSet rs;
        try {
            String sql = "select * from rutas where EstRut='A'";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            rutaM ruta;
            while (rs.next()) {
                ruta = new rutaM();
                ruta.setIdrutas(rs.getString("idrutas"));
                ruta.setNomrut(rs.getString("NomRut"));
                ruta.setEstrut(rs.getString("EstRut"));
                list.add(ruta);
            }
            return list;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    @Override
    public void actualizar(rutaM ruta) throws Exception {
        this.conexion();
        try {
            String sql = "update Rutas set NomRut=? ,EstRut=? where idrutas=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, ruta.getNomrut());
            ps.setString(2, ruta.getEstrut());
            ps.setString(3, ruta.getIdrutas());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    
}
