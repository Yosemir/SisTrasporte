package interfas;

import java.util.List;
import modelo.rutaM;

public interface rutaimp {

    void registrar(rutaM viaje) throws Exception;

    List<rutaM> listar() throws Exception;

    void actualizar(rutaM viaje) throws Exception;
}
