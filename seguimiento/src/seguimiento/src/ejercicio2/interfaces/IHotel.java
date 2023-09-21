package ejercicio2.interfaces;
import ejercicio2.dto.HotelDTO;

import java.io.IOException;
import java.util.List;

public interface IHotel {
    HotelDTO findById(int id);
    List<HotelDTO> findAll() throws IOException, ClassNotFoundException;
    void save(HotelDTO hotel) throws IOException;
    void update(HotelDTO hotel) throws IOException;
    void delete(HotelDTO hotel) throws IOException;
}