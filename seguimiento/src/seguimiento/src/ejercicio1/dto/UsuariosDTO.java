package ejercicio1.dto;
import java.io.Serializable;

public class UsuariosDTO implements Serializable {
    public Integer Id;
    private String usuario;
    private Integer saldo;
    private Integer cedula;

    public UsuariosDTO(Integer id, String usuario, Integer saldo, Integer cedula) {
        Id = id;
        this.usuario = usuario;
        this.saldo = saldo;
        this.cedula = cedula;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "UsuariosDTO{" +
                "Id=" + Id +
                ", usuario='" + usuario + '\'' +
                ", saldo=" + saldo +
                ", cedula=" + cedula +
                '}';



    }

    public void add(UsuariosDTO cliente) {

    }

    public void remove(UsuariosDTO clienteViejo) {

    }
}
