package utnfc.isi.backend.parcial.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Desarrolladores")
public class Desarrollador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "multivalor")
    private boolean multivalor;

    @Column(name = "detalle")
    private String detalle;

    public Desarrollador() {
    }

    public Desarrollador(Long id, String nombre, boolean multivalor, String detalle) {
        this.id = id;
        this.nombre = nombre;
        this.multivalor = multivalor;
        this.detalle = detalle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isMultivalor() {
        return multivalor;
    }

    public void setMultivalor(boolean multivalor) {
        this.multivalor = multivalor;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Desarrollador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", multivalor=" + multivalor +
                ", detalle='" + detalle + '\'' +
                '}';
    }
}
