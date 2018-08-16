package interfaces;

import java.util.List;
import Modelo.rutaM;

public interface rutaimp {

    void registrar(rutaM ruta) throws Exception;

    List<rutaM> listar() throws Exception;

    void actualizar(rutaM ruta) throws Exception;
}
