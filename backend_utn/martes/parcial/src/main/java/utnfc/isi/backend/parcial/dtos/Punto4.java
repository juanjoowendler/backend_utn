package utnfc.isi.backend.parcial.dtos;

public class Punto4 {
    private String mejorDesarrollador;
    private Double promedio;

    public Punto4(String mejorDesarrollador, Double promedio) {
        this.mejorDesarrollador = mejorDesarrollador;
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Punto4{" +
                "mejorDesarrollador='" + mejorDesarrollador + '\'' +
                ", promedio=" + promedio +
                '}';
    }
}
