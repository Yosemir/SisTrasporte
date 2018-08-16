
package Dao;

import interfaces.clienteimp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Modelo.clienteM;


public class clienteD extends dao implements clienteimp{

    @Override
    public void registrar(clienteM cliente) throws Exception {
           this.conexion();
        try {
            String sql = "insert into Cliente(NomCli,ApelliCli,TipoDoc,NumDoc,FecViaje,HoraviaCli,TipoServi,PrecioViaCli)values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, cliente.getNomCli());
            ps.setString(2, cliente.getApelliCli());
            ps.setString(3, cliente.getTipoDoc());
            ps.setString(4, cliente.getNumDoc());
            ps.setString(5, cliente.getFecViaje());
            ps.setString(6, cliente.getHoraviaCli());
            ps.setString(7, cliente.getTipoServi());
            ps.setString(8, cliente.getPrecioViaCli());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<clienteM> listar() throws Exception {
        this.conexion();
        List<clienteM> list;
        ResultSet rs;
        try {
            String sql = "select * from Cliente";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList<>();
            clienteM cliente;
            while (rs.next()) {
                cliente = new clienteM();
                cliente.setIdClie(rs.getString("idClie"));
                cliente.setNomCli(rs.getString("NomCli"));
                cliente.setApelliCli(rs.getString("ApelliCli"));
                cliente.setTipoDoc(rs.getString("TipoDoc"));
                cliente.setNumDoc(rs.getString("NumDoc"));
                cliente.setFecViaje(rs.getString("FecViaje"));
                cliente.setHoraviaCli(rs.getString("HoraviaCli"));
                cliente.setTipoServi(rs.getString("TipoServi"));
                cliente.setPrecioViaCli(rs.getString("PrecioViaCli"));
                list.add(cliente);
            }
            return list;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void actualizar(clienteM cliente) throws Exception {
        this.conexion();
        try {
            String sql = "update Cliente set NomCli=?,ApelliCli=?,TipoDoc=?,NumDoc=?,FecViaje=?,HoraviaCli=?,TipoServi=?,PrecioViaCli=? where idClie=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, cliente.getNomCli());
            ps.setString(2, cliente.getApelliCli());
            ps.setString(3, cliente.getTipoDoc());
            ps.setString(4, cliente.getNumDoc());
            ps.setString(5, cliente.getFecViaje());
            ps.setString(6, cliente.getHoraviaCli());
            ps.setString(7, cliente.getTipoServi());
            ps.setString(8, cliente.getPrecioViaCli());
            ps.setString(9, cliente.getIdClie());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }
    }


   


