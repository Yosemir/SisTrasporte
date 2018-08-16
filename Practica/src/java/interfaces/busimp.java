package interfaces;

import java.util.List;
import Modelo.busM;

public interface busimp {

    void registrar(busM bus) throws Exception;

    List<busM> listar() throws Exception;

    void actualizar(busM bus) throws Exception;
}
