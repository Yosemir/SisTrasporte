package Dao;

import interfaces.personalimp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modelo.personalM;

public class personalD extends dao implements personalimp {

    @Override
    public void registrar(personalM personal) throws Exception {
         this.conexion();
        try {
            String sql = "insert into Personal(NomPer,ApePer,NumDoc,SexPer,FecNacPer,CelularPer,DirecPer,TipDoc,TipoPer,EstaPer)values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, personal.getNomPer());
            ps.setString(2, personal.getApePer());
            ps.setString(3, personal.getNumDoc());
            ps.setString(4, personal.getSexPer());
            ps.setString(5, personal.getFecNacPer());
            ps.setString(6, personal.getCelularPer());
            ps.setString(7, personal.getDirecPer());
            ps.setString(8, personal.getTipDoc());
            ps.setString(9, personal.getTipoPer());
            ps.setString(10, "A");
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<personalM> listar() throws Exception {
       this.conexion();
        List<personalM> list;
        ResultSet rs;
        try {
            String sql = "select * from Personal where EstaPer='A'";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            personalM personal;
            while (rs.next()) {
                personal = new personalM();
                personal.setIdper(rs.getString("idper"));
                personal.setNomPer(rs.getString("NomPer"));
                personal.setApePer(rs.getString("ApePer"));
                personal.setTipDoc(rs.getString("TipDoc"));
                personal.setNumDoc(rs.getString("NumDoc"));
                personal.setSexPer(rs.getString("SexPer"));
                personal.setFecNacPer(rs.getString("FecNacPer"));
                personal.setCelularPer(rs.getString("CelularPer"));
                personal.setDirecPer(rs.getString("DirecPer"));
                personal.setTipoPer(rs.getString("TipoPer"));
                personal.setEstaPer(rs.getString("EstaPer"));
                list.add(personal);
            }
            return list;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void actualizar(personalM personal) throws Exception {
        this.conexion();
        try {
            String sql = "update Personal set NomPer=? ,ApePer=?, NumDoc=?, SexPer=?, FecNacPer=?, CelularPer=?,DirecPer=?,TipDoc=?, TipoPer=?,EstaPer=? where idper=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, personal.getNomPer());
            ps.setString(2, personal.getApePer());
            ps.setString(3, personal.getNumDoc());
            ps.setString(4, personal.getSexPer());
            ps.setString(5, personal.getFecNacPer());
            ps.setString(6, personal.getCelularPer());
            ps.setString(7, personal.getDirecPer());
            ps.setString(8, personal.getTipDoc());
            ps.setString(9, personal.getTipoPer());
            ps.setString(10, personal.getEstaPer());
            ps.setString(11, personal.getIdper());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
}
