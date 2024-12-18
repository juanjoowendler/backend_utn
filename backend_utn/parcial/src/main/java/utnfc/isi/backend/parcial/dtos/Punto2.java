package utnfc.isi.backend.parcial.dtos;

public class Punto2 {
    private String nombreDesarrollador;
    private Long cantidadJuegosDesarrollador;

    public Punto2(String nombreDesarrollador, Long cantidadJuegosDesarrollador) {
        this.nombreDesarrollador = nombreDesarrollador;
        this.cantidadJuegosDesarrollador = cantidadJuegosDesarrollador;
    }

    @Override
    public String toString() {
        return "Punto2{" +
                "nombreDesarrollador='" + nombreDesarrollador + '\'' +
                ", cantidadJuegosDesarrollador=" + cantidadJuegosDesarrollador +
                '}';
    }
}
