package ejercicio1.servicios;
import ejercicio1.dto.UsuariosDTO;
import ejercicio1.interfaces.IUsuarios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioServicioImpl implements IUsuarios {
    private List<UsuariosDTO> cliente;

    public UsuarioServicioImpl() throws IOException, ClassNotFoundException {
        cliente = new ArrayList<>();
    }

    @Override
    public UsuariosDTO findById(int id) {
        return cliente.stream()
                .filter(cliente -> cliente.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<UsuariosDTO> findAll() throws IOException, ClassNotFoundException {
        cliente = (List<UsuariosDTO>) ObjSerializable.readObjectFromFile("usuario.ax.txt");
        return cliente;
    }

    @Override
    public void save(UsuariosDTO cliente) throws IOException {
        cliente.add(cliente);
        ObjSerializable.writeObjectToFile(cliente,"usuario.ax.txt");
    }

    @Override
    public void update(UsuariosDTO cliente) throws IOException {
        UsuariosDTO clienteViejo = findById(cliente.getId());
        if (clienteViejo != null) {
            cliente.remove(clienteViejo);
            cliente.add(cliente);
            ObjSerializable.writeObjectToFile(cliente, "usuario.ax.txt");
        }
    }
    @Override
    public void delete(UsuariosDTO cliente) throws IOException {
        cliente.remove(cliente);
        ObjSerializable.writeObjectToFile(cliente,"usuario.ax.txt");

    }
}