package utnfc.isi.backend.parcial.dtos;

public class Punto2 {
    private Long totalJuegosFinalizados;

    public Punto2(Long totalJuegosFinalizados) {
        this.totalJuegosFinalizados = totalJuegosFinalizados;
    }

    @Override
    public String toString() {
        return "Punto2{" +
                "totalJuegosFinalizados=" + totalJuegosFinalizados +
                '}';
    }
}
