package utnfc.isi.backend.parcial.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Plataformas")
public class Plataforma {
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

    public Plataforma() {
    }

    public Plataforma(Long id, String detalle, boolean multivalor, String nombre) {
        this.id = id;
        this.detalle = detalle;
        this.multivalor = multivalor;
        this.nombre = nombre;
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
        return "Plataforma{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", multivalor=" + multivalor +
                ", detalle='" + detalle + '\'' +
                '}';
    }
}
