package controlador;

import Dao.clienteD;
import Modelo.clienteM;
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
public class clienteC {

    private clienteM cliente = new clienteM();
    private List<clienteM> listclie;
    private clienteM selectcli;

    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void agregar() throws Exception {
        clienteD dao;
        try {
            dao = new clienteD();
            dao.registrar(cliente);
            listar();
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "COMPLETADO", "Correctamente."));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        clienteD dao;
        try {
            dao = new clienteD();
            listclie = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void actualizar() throws Exception {
        clienteD dao;
        try {
            dao = new clienteD();
            dao.actualizar(selectcli);
            listar();
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "COMPLETADO", "Correctamente."));
        } catch (Exception e) {
            throw e;
        }
    }

}
