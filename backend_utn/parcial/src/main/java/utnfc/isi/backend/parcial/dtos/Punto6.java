package utnfc.isi.backend.parcial.dtos;

public class Punto6 {
    private String nombreJuego;
    private String nombreGenero;

    public Punto6(String nombreJuego, String nombreGenero) {
        this.nombreJuego = nombreJuego;
        this.nombreGenero = nombreGenero;
    }

    @Override
    public String toString() {
        return "Punto6{" +
                "nombreJuego='" + nombreJuego + '\'' +
                ", nombreGenero='" + nombreGenero + '\'' +
                '}';
    }
}
