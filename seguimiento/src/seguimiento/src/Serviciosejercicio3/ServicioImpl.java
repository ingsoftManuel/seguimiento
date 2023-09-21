package Serviciosejercicio3;
import UniversidadAtencionejercicio3.DTO;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class ServicioImpl implements Serializable {
    private List<DTO> Producto;

    public ServicioImpl() throws IOException, ClassNotFoundException {
        Producto = new ArrayList<>();
    }


    public DTO findById(int id) {
        return Producto.stream()
                .filter(Producto -> Producto.getId() == id)
                .findFirst()
                .orElse(null);
    }


    public List<DTO> findAll() throws IOException, ClassNotFoundException {
        Producto = (List<DTO>) SerializerAtencion.readObjectFromFile("Productos.ax");
        return Producto;
    }


    public void save(DTO atencion) throws IOException {
        Producto.add(atencion);
        SerializerAtencion.writeObjectToFile(Producto, "productos.ax");
    }


    public void update(DTO Atencion) throws IOException {
        DTO oLdProducto = findById(Atencion.getId());
        if (oLdProducto != null) {
            Producto.remove(oLdProducto);
            Producto.add(Atencion);
            SerializerAtencion.writeObjectToFile(Atencion, "productos.ax");
        }
    }


    public void delete(DTO Producto) throws IOException {
        Producto.remove(Producto);
        SerializerAtencion.writeObjectToFile(Producto, "productos.ax");
    }
}