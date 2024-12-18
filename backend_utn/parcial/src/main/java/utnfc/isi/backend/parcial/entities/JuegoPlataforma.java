package utnfc.isi.backend.parcial.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Juegos_Plataformas")
public class JuegoPlataforma {

    @EmbeddedId
    private JuegoPlataformaId id;

    @Embeddable
    public static class JuegoPlataformaId {
        @Column(name = "Juego_id")
        private Long juegoId;

        @Column(name = "plataformas_id")
        private Long plataformasId;
    }
}
