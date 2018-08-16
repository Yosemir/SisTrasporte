package controlador;

import Dao.busD;
import Modelo.busM;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import lombok.Data;

@Data
@ManagedBean
@SessionScoped
public class busC {

    private busM bus = new busM();
    private List<busM> listbus;
    private busM selectbus;

    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void agregar() throws Exception {
        busD dao;
        try {
            dao = new busD();
            dao.registrar(bus);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "COMPLETADO", "Correctamente."));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        busD dao;
        try {
            dao = new busD();
            listbus = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void actualizar() throws Exception {
        busD dao;
        try {
            dao = new busD();
            dao.actualizar(selectbus);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "COMPLETADO", "Correctamente."));
            listar();
        } catch (Exception e) {
            throw e;
        }
    }

}
