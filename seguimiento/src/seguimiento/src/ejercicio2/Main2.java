package ejercicio2;
import ejercicio2.dto.HotelDTO;
import ejercicio2.interfaces.IHotel;
import ejercicio2.servicios.HotelServiceImpl;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opc = "1";
        IHotel habitacion = new HotelServiceImpl();

        do {
            Scanner s = new Scanner(System.in);
            System.out.println("""
                    Menu:\s
                     1.Reservar una habitacion\s
                     2.Consultar reservas disponibles\s
                     3.Actualizar reserva
                     4.Cancelar reserva\s
                     5.Consultar la cantidad de habitaciones ocupadas\s
                     6.Salir""");
            opc = s.next();
            switch (opc) {
                case "1" -> {
                    System.out.println(".Reservar.");
                    System.out.println("Ingresa el numero de documento");
                    int documento = Integer.parseInt(s.next());
                    System.out.println("ingresa tu nombre");
                    String nombre = s.next();
                    System.out.println("En que pais resides:");
                    String pais = s.next();
                    System.out.println("Numero de personas");
                    int numeroPersonas = Integer.parseInt(s.next());
                    System.out.println("Cuantos dias va a solicitar la habitacion");
                    Integer diasHospedados = Integer.valueOf(s.next());
                    System.out.println("¿Vienes con mascotas?\n" +
                            "Si es asi, ten en cuenta que solo se permiten en habitaciones familiares");
                    String pet = s.next();
                    System.out.println("Consumes cigarrillos?");
                    String cigarrillos = s.next();
                    System.out.println("Tipo de habitacion: \n 1.Individual (2 personas) \n 2.Doble (4 personas) \n 3.Familiar (6 personas & mascota)");
                    int hab = Integer.parseInt(s.next());

                    if (hab == 1 && numeroPersonas <= 2 && Objects.equals(pet, "No")) {
                        String tipHab = "Individual";
                        repo.save(new HotelDTO(id, tipHab, nombre, pais, numeroPersonasPersonas, diasHospedados, pet, cigarrillos));
                        System.out.println("Reserva lograda: " + repo.findById(id));
                    } else if ((hab == 2) && (numeroPersonasPersonas <= 4) && Objects.equals(pet, "No")) {
                        String tipHab = "Doble";
                        repo.save(new HotelDTO(id, tipHab, nombre, pais, numeroPersonasPersonas, diasHospedados, pet, cigarrillos));
                        System.out.println("Reserva lograda: " + repo.findById(id));
                    } else if (hab == 3 && numeroPersonasPersonas <= 6) {
                        String tipHab = "Familiar";
                        repo.save(new HotelDTO(id, tipHab, nombre, pais, numeroPersonasPersonas, diasHospedados, pet, cigarrillos));
                        System.out.println("Reserva lograda: " + repo.findById(id));
                    } else {
                        System.out.println("No se puede hacer la reserva, ingresa los datos nuevamente");
                    }
                }
                case "2" -> {
                    System.out.println(".Mostrar reservas.");
                    List<HotelDTO> reservar = repo.findAll();
                    if (!reservar.isEmpty()) {
                        reservar.forEach(System.out::println);
                    } else {
                        System.out.println("Reservas no disponibles");
                    }
                }
                case "3" -> {
                    System.out.println(".Editar las reservas.");
                    System.out.println("Ingrese el numedo de documento");
                    int id = Integer.parseInt(s.next());
                    boolean busqueda = repo.findById(id) == null;
                    if (!busqueda) {
                        System.out.println("Ingresa tu nombre");
                        String nombre = s.next();
                        System.out.println("En que pais resides:");
                        String pais = s.next();
                        System.out.println("Numero de personas");
                        int numPersonas = Integer.parseInt(s.next());
                        System.out.println("Cuantos dias va a solicitar la habitacion");
                        Integer dias = Integer.valueOf(s.next());
                        System.out.println("¿vienes con mascotas?");
                        String pet = s.next();
                        System.out.println("Consumes cigarrillos");
                        String cigarrillos = s.next();
                        System.out.println("Tipo de habitacion: \n 1.Individual(2 personas) \n 2.Doble(4 personas) \n 3.Familiar(6 personas & mascota)");
                        int hab = Integer.parseInt(s.next());

                        if (hab == 1 && numPersonas <= 2 && Objects.equals(pet, "no")) {
                            String tipHab = "Individual";
                            repo.update(new HotelDTO(id, tipHab, nombre, pais, numPersonas, dias, pet, cigarrillos));
                            System.out.println("Reserva lograda: " + repo.findById(id));
                        } else if ((hab == 2) && (numPersonas <= 4) && Objects.equals(pet, "no")) {
                            String tipHab = "Doble";
                            repo.update(new HotelDTO(id, tipHab, nombre, pais, numPersonas, dias, pet, cigarrillos));
                            System.out.println("Reserva lograda: " + repo.findById(id));
                        } else if (hab == 3 && numPersonas <= 6) {
                            String tipHab = "Familiar";
                            repo.update(new HotelDTO(id, tipHab, nombre, pais, numPersonas, dias, pet, cigarrillos));
                            System.out.println("Reserva lograda: " + repo.findById(id));
                        } else {
                            System.out.println("No se puede hacer la reserva, ingresa los datos nuevamente");
                        }
                    } else {
                        System.out.println("No se ha encontrado el registro con los datos que nos has dado");
                    }
                }
                case "4" -> {
                    System.out.println(".Eliminar reservas.");
                    System.out.println("Ingresa el numero de documento: ");
                    int id = Integer.parseInt(s.next());
                    boolean explorar = repo.findById(id) == null;
                    if (!explorar) {
                        System.out.println("Se eliminará la reserva:\n "+ repo.findById(id));
                        repo.delete(repo.findById(id));
                        System.out.println("se ha eliminado de manera exitosa la reserva");
                    } else {
                        System.out.println("Lo sentimos, no se encuentra la reserva");
                    }
                }
                case "5" -> {
                    int huespedestot = repo.findAll().stream().mapToInt(HotelDTO::getNumberOfPerson).sum();
                    int totreservas = repo.findAll().size();
                    System.out.println("En el hotel hay esta cantidad de : "+ huespedestot+" personas \n En el hotel hay ocupadas: "+totreservas+" habitaciones" );
                }
                case "6"->{
                    opc = "6";
                }
            }
        }while (!opc.equals("6")) ;
    }
}