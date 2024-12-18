package utnfc.isi.backend.parcial.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Juegos_Generos")
public class JuegoGenero {
    @EmbeddedId
    private JuegoGeneroId id;

    @Embeddable
    public static class JuegoGeneroId {
        @Column(name = "Juego_id")
        private Long juegoId;

        @Column(name = "generos_id")
        private Long generosId;
    }
}
