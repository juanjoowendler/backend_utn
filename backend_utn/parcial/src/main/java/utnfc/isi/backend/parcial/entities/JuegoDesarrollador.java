package utnfc.isi.backend.parcial.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Juegos_Desarrolladores")
public class JuegoDesarrollador {
    @EmbeddedId
    private JuegoDesarrolladorId id;

    @Embeddable
    public static class JuegoDesarrolladorId {
        @Column(name = "Juego_id")
        private Long juegoId;

        @Column(name = "desarrolladores_id")
        private Long desarrolladoresId;
    }
}
