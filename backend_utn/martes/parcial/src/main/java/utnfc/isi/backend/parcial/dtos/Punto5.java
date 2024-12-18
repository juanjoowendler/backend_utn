package utnfc.isi.backend.parcial.dtos;

public class Punto5 {
    private Long cantidadJuegosPorGenero;

    public Punto5(Long cantidadJuegosPorGenero) {
        this.cantidadJuegosPorGenero = cantidadJuegosPorGenero;
    }

    @Override
    public String toString() {
        return "Punto5{" +
                "cantidadJuegosPorGenero=" + cantidadJuegosPorGenero +
                '}';
    }
}
