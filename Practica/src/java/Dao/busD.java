package Dao;

import interfaces.busimp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modelo.busM;

public class busD extends dao implements busimp {

    @Override
    public void registrar(busM bus) throws Exception {
         this.conexion();
        try {
            String sql = "insert into Bus(PlacaBus,AsientBus,MarcaBus,EstaBus)values(?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, bus.getPlacabus());
            ps.setString(2, bus.getAsientobus());
            ps.setString(3, bus.getMarcabus());
            ps.setString(4, "A");
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<busM> listar() throws Exception {
        this.conexion();
        List<busM> list;
        ResultSet rs;
        try {
            String sql = "select * from Bus where EstaBus='A'";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            busM ruta;
            while (rs.next()) {
                ruta = new busM();
                ruta.setIdbus(rs.getString("idbus"));
                ruta.setPlacabus(rs.getString("PlacaBus"));
                ruta.setAsientobus(rs.getString("AsientBus"));
                ruta.setMarcabus(rs.getString("MarcaBus"));
                ruta.setEstbus(rs.getString("EstaBus"));
                list.add(ruta);
            }
            return list;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void actualizar(busM bus) throws Exception {
       this.conexion();
        try {
            String sql = "update Bus set PlacaBus=? ,AsientBus=?, MarcaBus=?, EstaBus=? where idbus=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, bus.getPlacabus());
            ps.setString(2, bus.getAsientobus());
            ps.setString(3, bus.getMarcabus());
            ps.setString(4, bus.getEstbus());
            ps.setString(5, bus.getIdbus());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
}
