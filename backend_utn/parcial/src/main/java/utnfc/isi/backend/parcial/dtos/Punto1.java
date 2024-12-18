package utnfc.isi.backend.parcial.dtos;

public class Punto1 {
    private String nombrePlataforma;
    private Long cantidadJuegosPlataforma;

    public Punto1(String nombrePlataforma, Long cantidadJuegosPlataforma) {
        this.nombrePlataforma = nombrePlataforma;
        this.cantidadJuegosPlataforma = cantidadJuegosPlataforma;
    }

    @Override
    public String toString() {
        return "Punto1{" +
                "nombrePlataforma='" + nombrePlataforma + '\'' +
                ", cantidadJuegosPlataforma=" + cantidadJuegosPlataforma +
                '}';
    }
}
