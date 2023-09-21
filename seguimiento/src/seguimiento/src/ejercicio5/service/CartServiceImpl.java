package ejercicio5.service;
import ejercicio5.dto.ShopCarDTO;
import ejercicio5.interfaces.IShopCar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements IShopCar {

    private List<ShopCarDTO> carrito;

    public CartServiceImpl () throws IOException, ClassNotFoundException {
        carrito = new ArrayList<>();
    }


    @Override
    public CartDTO findById(int id) {
        return carrito.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);

    }

    @Override
    public List<ShopCarDTO> findall() throws IOException, ClassNotFoundException {
        carrito = (List<ShopCarDTO>) ObjSerializer.readObjetFromFile("Carrito.ax");
        return carrito;
    }

    @Override
    public void save(ShopCarDTO producto) throws IOException {
        carrito.add(producto);
        ObjSerializer.writeObjectToFile(carrito, "Carrito.ax");
    }

    @Override
    public void update(ShopCarDTO producto) throws IOException {
        ShopCarDTO oldProducto = findById(producto.getId());
        if (oldProducto != null) {
            carrito.remove(oldProducto);
            carrito.add(product);
            ObjSerializer.writeObjectToFile(carrito, "Carrito.ax");
        }
    }

    @Override
    public void delete(CarritoDTO producto) throws IOException {
        carrito.remove(producto);
        ObjectSerializer.writeObjectToFile(carrito, "Carrito.ax");
    }
}