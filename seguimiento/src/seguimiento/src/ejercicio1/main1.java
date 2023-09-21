package ejercicio1;
import ejercicio1.dto.UsuariosDTO;
import ejercicio1.interfaces.IUsuarios;
import ejercicio1.servicios.UsuarioServicioImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class main1{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opc ;
        IUsuarios repo = new UsuarioServicioImpl();
        do {
            Scanner s = new Scanner(System.in);
            System.out.println("Menu: \n 1.Registro \n 2.Cuentas \n 3.Depositar Dinero \n 4.Transferencia de Dinero \n 5.Eliminacion cuentas \n 6.Salir");
            opc = s.next();
            switch (opc) {
                case "1" -> {
                    System.out.println(".Registro.");
                    System.out.println("Numero de cuenta: ");
                    Integer EstadoCuenta = Integer.valueOf(s.next());
                    System.out.println("Nombre del usuario: ");
                    String name = s.next();
                    System.out.println("Cedula :");
                    Integer tipoDocumento = Integer.valueOf(s.next());
                    System.out.println("Ingrese su saldo: ");
                    Integer saldo = s.nextInt();
                    repo.save(new UsuariosDTO(EstadoCuenta, name, saldo, tipoDocumento));
                }
                case "2" -> {
                    System.out.println(".Cuentas.");
                    List<UsuariosDTO> EstadoCuenta = repo.findAll();
                    if (!EstadoCuenta.isEmpty()) {
                        EstadoCuenta.forEach(System.out::println);
                    } else {
                        System.out.println("No se encuentra dicha cuenta");
                    }
                }
                case "3" -> {
                    System.out.println(".Depositar Dinero.");
                    System.out.println("Ingrese el numero de la cuenta: ");
                    int ec = Integer.parseInt(s.next());
                    boolean busqueda = repo.findById(ec) == null;
                    if (!busqueda) {
                        System.out.println("cual es la cantidad de dinero para transferir:");
                        int plata = Integer.parseInt(s.next());
                        Integer nuevoSaldo = repo.findById(ec).getSaldo() + plata;
                        String nombre = repo.findById(ec).getUsuario();
                        Integer documento = repo.findById(ec).getCedula();
                        repo.update(new UsuariosDTO(ec, nombre, nuevoSaldo, documento));
                        System.out.println("su transferencia ha sido exitosa $" + plata);
                    } else {
                        System.out.println("Cuenta no registrada");
                    }
                }
                case "4" -> {
                    System.out.println(".Transferencia de Dinero.");
                    System.out.println("Ingrese la cuante de transferencia");
                    int id1 = Integer.parseInt(s.next());
                    String nombre1 = repo.findById(id1).getUsuario();
                    Integer documento1 = repo.findById(id1).getCedula();
                    System.out.println("Ingrese la cuenta de deposito de dinero");
                    int id2 = Integer.parseInt(s.next());
                    String nombre2 = repo.findById(id2).getUsuario();
                    Integer documento2 = repo.findById(id2).getCedula();
                    System.out.println("Ingrese el valor de la transferencia:");
                    int efectivo = Integer.parseInt(s.next());
                    if (repo.findById(id1).getSaldo() >= efectivo) {
                        Integer resta = repo.findById(id1).getSaldo() - efectivo;
                        Integer suma = repo.findById(id2).getSaldo() + efectivo;
                        repo.update(new UsuariosDTO(id1, nombre1, resta, documento1));
                        repo.update(new UsuariosDTO(id2, nombre2, suma, documento2));
                        System.out.println("Se han transferido existosamente $" + efectivo + "desde la cuenta" + id1 + "hacia la cuenta" + id2);
                    } else {
                        System.out.println("La tranferencia no se puede hacer debido al saldo insuficiente de la cuenta");
                    }
                }
                case "5" -> {
                    System.out.println(".Eliminacion de cuenta.");
                    System.out.println("Ingresa el numero de cuenta que quieras eliminar");
                    int co = Integer.parseInt(s.next());
                    boolean encontrar = repo.findById(co) == null;
                    if(!encontrar){
                        int exUsuario = s.nextInt();
                        repo.delete(repo.findById(exUsuario));
                        repo.findAll().forEach(System.out::println);
                        System.out.println("la cuenta" + co+ " ha sido exitozamiente eliminada");
                    }else{
                        System.out.println("la cuenta que usteded desea eliminar no se encuentra registrada");
                    }
                    break;


                }
                case "6" -> {
                    opc = "6";
                }
            }
        }while(!opc.equals("6"));
    }
}