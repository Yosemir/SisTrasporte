
package interfas;

import java.util.List;
import modelo.clienteM;


public interface clienteimp {
    
    
      void registrar(clienteM cliente) throws Exception;

    List<clienteM> listar() throws Exception;

    void actualizar(clienteM cliente) throws Exception;
}
