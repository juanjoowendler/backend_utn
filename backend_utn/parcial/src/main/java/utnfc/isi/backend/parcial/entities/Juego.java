package utnfc.isi.backend.parcial.entities;

import jakarta.persistence.*;

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

    @Column(name = "jugando")
    private Integer jugando;

    @ManyToOne
    private ClasificacionESRB clasificacionESRB;

    @ManyToOne
    private Genero genero;

    @ManyToOne
    private Desarrollador desarrollador;

    @ManyToOne
    private Plataforma plataforma;

    public Juego() {
    }

    public Juego(Long id, String titulo, Long fechaLanzamiento, Float rating, Integer juegosFinalizados, String resumen, Integer jugando, ClasificacionESRB clasificacionESRB, Genero genero, Desarrollador desarrollador, Plataforma plataforma) {
        this.id = id;
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.rating = rating;
        this.juegosFinalizados = juegosFinalizados;
        this.resumen = resumen;
        this.jugando = jugando;
        this.clasificacionESRB = clasificacionESRB;
        this.genero = genero;
        this.desarrollador = desarrollador;
        this.plataforma = plataforma;
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

    public Integer getJugando() {
        return jugando;
    }

    public void setJugando(Integer jugando) {
        this.jugando = jugando;
    }

    public ClasificacionESRB getClasificacionESRB() {
        return clasificacionESRB;
    }

    public void setClasificacionESRB(ClasificacionESRB clasificacionESRB) {
        this.clasificacionESRB = clasificacionESRB;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Desarrollador getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(Desarrollador desarrollador) {
        this.desarrollador = desarrollador;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
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
                ", jugando=" + jugando +
                ", clasificacionESRB=" + clasificacionESRB +
                ", genero=" + genero +
                ", desarrollador=" + desarrollador +
                ", plataforma=" + plataforma +
                '}';
    }
}
