package utnfc.isi.backend.parcial.dtos;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PuntoPrueba {
    private String nombreJuego;

    public PuntoPrueba(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public String primerasLetrasPalabrasMayuscula() {
        String resultado = Arrays.stream(nombreJuego.split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
        return resultado;
    }

    @Override
    public String toString() {
        return "PuntoPrueba{" +
                "nombreJuego='" + primerasLetrasPalabrasMayuscula() + '\'' +
                '}';
    }
}
