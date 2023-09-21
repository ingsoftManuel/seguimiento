package Centralejercicio3;
import UniversidadAtencionejercicio3.DTO;
import Interfazejercicio3.InterfazAtencion;
import Serviciosejercicio3.SerializerAtencion;

import java.util.List;
import java.util.Scanner;
public class Atencion {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        String opc = "1";
        InterfazAtencion repo = new SerializerAtencion();
        do {
            Scanner s = new Scanner(System.in);
            System.out.print("Menu \n 1. Agregar  \n 2. Listar \n 3. Editar " +
                    "\n 4. Eliminar  \n 5. Salir \n =>");
            opc = s.next();
            switch (opc) {
                case "1": {
                    System.out.println("Id producto: ");
                    Integer id = s.nextInt();
                    System.out.println("Nombre producto: ");
                    String nom = s.next();
                    System.out.println("categoria: ");
                    String cat = s.next();
                    System.out.println("cantidad: ");
                    double ca = s.nextDouble();
                    repo.save(new DTO(id,nom, cat, ca ));
                    break;
                }
                case "2": {
                    List<DTO> productos = repo.findAll();
                    if(!productos.isEmpty()){
                        productos.forEach(System.out::println);
                    }else{
                        System.out.println("No hay registros");
                    }
                    break;
                }
                case "3": {
                    System.out.println("===== editar ====");
                    System.out.print("id  producto: ");
                    Integer idp = s.nextInt();
                    System.out.print("ingrese nombre: ");
                    String nom = s.next();
                    System.out.print("ingrese categoria: ");
                    String cat = s.next();
                    System.out.print("ingrese cantidad: ");
                    double ca = s.nextDouble();
                    DTO beaActualizar = new DTO(idp, nom, cat, ca);
                    repo.update(beaActualizar);
                    break;
                }
                case "4": {
                    System.out.println("===== eliminar ======");
                    System.out.print("ingrese id del registro: ");
                    Integer id = s.nextInt();
                    repo.delete(repo.findById(id));
                    repo.findAll().forEach(System.out::println);
                    break;
                }
                case "5": {
                    opc = "5";
                    break;
                }
            }
        } while (opc != "5");
    }
}
