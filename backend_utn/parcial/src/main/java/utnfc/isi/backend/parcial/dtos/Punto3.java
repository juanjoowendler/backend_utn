package utnfc.isi.backend.parcial.dtos;

public class Punto3 {
    private String nombreDesarrollador;
    private Double ratingPromedio;

    public Punto3(String nombreDesarrollador, Double ratingPromedio) {
        this.nombreDesarrollador = nombreDesarrollador;
        this.ratingPromedio = ratingPromedio;
    }

    @Override
    public String toString() {
        return "Punto3{" +
                "nombreDesarrollador='" + nombreDesarrollador + '\'' +
                ", ratingPromedio=" + ratingPromedio +
                '}';
    }
}
