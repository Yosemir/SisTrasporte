
package interfaces;

import java.util.List;
import Modelo.personalM;


public interface personalimp {
    
    void registrar(personalM personal) throws Exception;

    List<personalM> listar() throws Exception;

    void actualizar(personalM personal) throws Exception;
}
