package utnfc.isi.backend.parcial.dtos;

public class Punto3 {
    private String nombreDesarrollador;
    private Long cantidadJuegosDesarrollador;

    public Punto3(String nombreDesarrollador, Long cantidadJuegosDesarrollador) {
        this.cantidadJuegosDesarrollador = cantidadJuegosDesarrollador;
        this.nombreDesarrollador = nombreDesarrollador;
    }

    @Override
    public String toString() {
        return "Punto3{" +
                "nombreDesarrollador='" + nombreDesarrollador + '\'' +
                ", cantidadJuegosDesarrollador=" + cantidadJuegosDesarrollador +
                '}';
    }
}
