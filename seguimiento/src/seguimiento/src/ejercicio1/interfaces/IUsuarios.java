package ejercicio1.interfaces;
import ejercicio1.dto.UsuariosDTO;
import java.io.IOException;
import java.util.List;

public interface IUsuarios {
    UsuariosDTO findById(int id);
    List<UsuariosDTO> findAll() throws IOException, ClassNotFoundException;
    void save(UsuariosDTO cliente) throws IOException;
    void update(UsuariosDTO cliente) throws IOException;
    void delete(UsuariosDTO cliente) throws IOException;

}