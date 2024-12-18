package utnfc.isi.backend.parcial.dtos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Punto5 {
    private String nombreJuego;
    private Long fechaLanzamiento;

    public Punto5(String nombreJuego, Long fechaLanzamiento) {
        this.nombreJuego = nombreJuego;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    // Formateo de fecha a MMM dd, yyyy
    public String getFormattedFechaLanzamiento() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
        Date date = new Date(fechaLanzamiento);
        return sdf.format(date);
    }

    @Override
    public String toString() {
        return "Punto5{" +
                "nombreJuego='" + nombreJuego + '\'' +
                ", fechaLanzamiento=" + getFormattedFechaLanzamiento() +
                '}';
    }
}
