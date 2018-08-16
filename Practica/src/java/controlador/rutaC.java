package controlador;

import Dao.rutaD;
import Modelo.rutaM;
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
public class rutaC {

    private rutaM rut = new rutaM();
    private List<rutaM> lisrut;
    private rutaM selectrut;

    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void agregar() throws Exception {
        rutaD dao;
        try {
            dao = new rutaD();
            dao.registrar(rut);
            listar();
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "COMPLETADO", "Correctamente."));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        rutaD dao;
        try {
            dao = new rutaD();
            lisrut = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

     public void actualizar() throws Exception {
        rutaD dao;
        try {
            dao = new rutaD();
           dao.actualizar(selectrut);
            listar();
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "COMPLETADO", "Correctamente."));
        } catch (Exception e) {
            throw e;
        }
    }

}
