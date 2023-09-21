package ejercicio5.interfaces;
import ejercicio5.dto.ShopCarDTO;

import java.io.IOException;
import java.util.List;

public interface IShopCar {

    ShopCarDTO findById (int id);

    List<ShopCarDTO> findall() throws IOException, ClassNotFoundException;

    void save (ShopCarDTO item) throws IOException;

    void update (ShopCarDTO item) throws IOException;

    void delete (ShopCarDTO item) throws IOException;

}