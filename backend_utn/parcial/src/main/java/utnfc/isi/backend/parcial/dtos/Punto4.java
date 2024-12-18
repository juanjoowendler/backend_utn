package utnfc.isi.backend.parcial.dtos;

public class Punto4 {
    private String nombreGenero;
    private Long cantidadJuegosGenero;

    public Punto4(String nombreGenero, Long cantidadJuegosGenero) {
        this.nombreGenero = nombreGenero;
        this.cantidadJuegosGenero = cantidadJuegosGenero;
    }

    @Override
    public String toString() {
        return "Punto4{" +
                "nombreGenero='" + nombreGenero + '\'' +
                ", cantidadJuegosGenero=" + cantidadJuegosGenero +
                '}';
    }
}
