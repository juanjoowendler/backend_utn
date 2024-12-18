package utnfc.isi.backend.parcial.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Clasificaciones_ESRB")
public class ClasificacionESRB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rating")
    private String rating;

    @Column(name = "codigo")
    private String codigo;

    public ClasificacionESRB() {
    }

    public ClasificacionESRB(Long id, String rating, String codigo) {
        this.id = id;
        this.rating = rating;
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "ClasificacionESRB{" +
                "id=" + id +
                ", rating='" + rating + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}



