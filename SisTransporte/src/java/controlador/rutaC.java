package controlador;

import DAO.rutaD;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lombok.Data;
import modelo.rutaM;

@Data
@SessionScoped
@ManagedBean
public class rutaC {

    rutaM ruta = new rutaM();
    private List<rutaM> listrut;

    public void registrar() throws Exception {
        rutaD dao;
        try {
            dao = new rutaD();
            dao.registrar(ruta);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listar()throws Exception{
        rutaD dao;
        try {
            dao = new rutaD();
            listrut = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
}

