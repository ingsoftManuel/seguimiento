package ejercicio5.dto;
import java.io.Serializable;

public class ShopCarDTO implements Serializable {
    public Integer id;
    private String productName;
    private double price;
    private double quantity;

    public ShopCarDTO(Integer id, String productName, double price, double quantity) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ShopCarDTO{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}