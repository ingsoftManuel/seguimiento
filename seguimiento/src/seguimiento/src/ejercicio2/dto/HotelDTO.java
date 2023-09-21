package ejercicio2.dto;
public class HotelDTO {
    public Integer id;
    private String habitacion;
    private String tipHabitacion;
    private String masc;
    private String name;
    private String region;
    private Integer personas;
    private Integer tiempo;
    private Integer cantHab;

    public HotelDTO(Integer id, String habitacion, String tipHabitacion, String masc, String name, String region, Integer personas, Integer tiempo, Integer cantHab) {
        this.id = id;
        this.habitacion = habitacion;
        this.tipHabitacion = tipHabitacion;
        this.masc = masc;
        this.name = name;
        this.region = region;
        this.personas = personas;
        this.tiempo = tiempo;
        this.cantHab = cantHab;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public String getTipHabitacion() {
        return tipHabitacion;
    }

    public void setTipHabitacion(String tipHabitacion) {
        this.tipHabitacion = tipHabitacion;
    }

    public String getMasc() {
        return masc;
    }

    public void setMasc(String masc) {
        this.masc = masc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getPersonas() {
        return personas;
    }

    public void setPersonas(Integer personas) {
        this.personas = personas;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public Integer getCantHab() {
        return cantHab;
    }

    public void setCantHab(Integer cantHab) {
        this.cantHab = cantHab;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", habitacion='" + habitacion + '\'' +
                ", tipHabitacion='" + tipHabitacion + '\'' +
                ", masc='" + masc + '\'' +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", personas=" + personas +
                ", tiempo=" + tiempo +
                ", cantHab=" + cantHab +
                '}';
    }

    public void add(HotelDTO hotel) {

    }
}