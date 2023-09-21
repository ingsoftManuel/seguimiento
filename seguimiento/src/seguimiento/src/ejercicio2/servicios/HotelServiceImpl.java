package ejercicio2.servicios;
import ejercicio2.dto.HotelDTO;
import ejercicio2.interfaces.IHotel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HotelServiceImpl implements IHotel {
    private List<HotelDTO> hotel;

    public HotelServiceImpl() {
        hotel = new ArrayList<>();
    }

    @Override
    public HotelDTO findById(int id) {
        return hotel.stream()
                .filter(HotelDTO -> HotelDTO.getId()==id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<HotelDTO> findAll() throws IOException, ClassNotFoundException {
        hotel = (List<HotelDTO>) ObjSerializable.readObjectFromFile("hotel.ax");
        return hotel;
    }

    @Override
    public void save(HotelDTO hotel) throws IOException {
        hotel.add(hotel);
        ObjSerializable.writeObjectToFile(hotel,"hotel.ax");

    }

    @Override
    public void update(HotelDTO hotel) throws IOException {

    }

    @Override
    public void delete(HotelDTO hotel) throws IOException {

    }
}