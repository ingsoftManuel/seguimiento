package ejercicio5;
import ejercicio5.dto.ShopCarDTO;
import ejercicio5.interfaces.IShopCar;
import ejercicio5.service.CartServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opc= "1";
        IShopCar product =new CartServiceImpl();


        do {
            Scanner s = new Scanner(System.in);
            System.out.println("Menu \n 1. Agregar \n 2. Listar \n 3. Total de compra \n 4. Eliminar \n 5. Salir");

            opc = s.next();
            switch (opc) {

                case "1": {
                    System.out.println("Id producto: ");
                    Integer id = s.nextInt();
                    System.out.println("Nombre producto: ");
                    String ProName = s.next();
                    System.out.println("Precio ");
                    Integer pric = s.nextInt();
                    System.out.println("cantidad: ");
                    double quant = s.nextDouble();
                    product.save(new ShopCarDTO(id, ProName, pric, quant ));
                    break;

                }
                case "2": {
                    List<ShopCarDTO> cart = product.findall();
                    if (!cart.isEmpty()) {
                        cart.forEach(System.out::println);
                    } else {
                        System.out.println("No hay productos en el carrito");
                    }
                    break;
                }
                case "3": {

                    double total = product.findall().stream().mapToDouble(ShopCarDTO::getPrice).sum();
                    System.out.println("Total de compra:" + total);

                    break;
                }
                case "4": {
                    System.out.println("Eliminar producto del carrito");
                    System.out.println("Ingrese el id del producto a eliminar");
                    Integer id = s.nextInt();
                    product.delete(product.findById(id));
                    product.findall().forEach(System.out::println);
                    break;
                }
                case "5": {
                    opc = "5";
                    break;
                }
            }
        } while (opc != "5");

    } }