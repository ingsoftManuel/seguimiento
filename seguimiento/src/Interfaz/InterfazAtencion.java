package Interfaz;
import UniversidadAtencion.DTO;

import java.io.IOException;
import java.util.List;

public interface InterfazAtencion {
    DTO findById(int id);
    List<DTO> findAll() throws IOException, ClassNotFoundException;
    void save(DTO Atencion) throws IOException;
    void update( DTO Atencion) throws IOException;
    void delete(DTO Atencion) throws IOException;
}
