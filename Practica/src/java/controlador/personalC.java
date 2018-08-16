package controlador;

import Dao.personalD;
import Modelo.personalM;
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
public class personalC {

    private personalM personal = new personalM();
    private List<personalM> listPer;
    private personalM selectPer;

    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void agregar() throws Exception {
        personalD dao;
        try {
            dao = new personalD();
            dao.registrar(personal);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "COMPLETADO", "Correctamente."));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        personalD dao;
        try {
            dao = new personalD();
            listPer = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void actualizar() throws Exception {
        personalD dao;
        try {
            dao = new personalD();
            dao.actualizar(selectPer);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "COMPLETADO", "Correctamente."));
        } catch (Exception e) {
            throw e;
        }
    }

}
