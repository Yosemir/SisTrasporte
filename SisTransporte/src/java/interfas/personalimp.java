
package interfas;

import java.util.List;
import modelo.personalM;


public interface personalimp {
    
    void registrar(personalM personal) throws Exception;

    List<personalM> listar() throws Exception;

    void actualizar(personalM personal) throws Exception;
}
