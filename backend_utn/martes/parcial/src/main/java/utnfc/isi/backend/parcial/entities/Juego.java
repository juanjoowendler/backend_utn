package utnfc.isi.backend.parcial.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Juegos")
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "fecha_lanzamiento")
    private Long fechaLanzamiento;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "juegos_finalizados")
    private Integer juegosFinalizados;

    @Column(name = "resumen")
    private String resumen;

    @ManyToOne
    private ClasificacionESRB clasificacionESRB;

    @ManyToMany
    private List<Genero> generos;

    @ManyToMany
    private List<Desarrollador> desarrolladores;

    @ManyToMany
    private List<Plataforma> plataformas;

    public Juego() {
    }

    public Juego(Long id, String titulo, Long fechaLanzamiento, Float rating, Integer juegosFinalizados, String resumen, ClasificacionESRB clasificacionESRB, List<Genero> generos, List<Desarrollador> desarrolladores, List<Plataforma> plataformas) {
        this.id = id;
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.rating = rating;
        this.juegosFinalizados = juegosFinalizados;
        this.resumen = resumen;
        this.clasificacionESRB = clasificacionESRB;
        this.generos = generos;
        this.desarrolladores = desarrolladores;
        this.plataformas = plataformas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Long fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getJuegosFinalizados() {
        return juegosFinalizados;
    }

    public void setJuegosFinalizados(Integer juegosFinalizados) {
        this.juegosFinalizados = juegosFinalizados;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public ClasificacionESRB getClasificacionESRB() {
        return clasificacionESRB;
    }

    public void setClasificacionESRB(ClasificacionESRB clasificacionESRB) {
        this.clasificacionESRB = clasificacionESRB;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public List<Desarrollador> getDesarrolladores() {
        return desarrolladores;
    }

    public void setDesarrolladores(List<Desarrollador> desarrolladores) {
        this.desarrolladores = desarrolladores;
    }

    public List<Plataforma> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(List<Plataforma> plataformas) {
        this.plataformas = plataformas;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fechaLanzamiento=" + fechaLanzamiento +
                ", rating=" + rating +
                ", juegosFinalizados=" + juegosFinalizados +
                ", resumen='" + resumen + '\'' +
                ", clasificacionESRB=" + clasificacionESRB +
                ", generos=" + generos +
                ", desarrolladores=" + desarrolladores +
                ", plataformas=" + plataformas +
                '}';
    }
}
