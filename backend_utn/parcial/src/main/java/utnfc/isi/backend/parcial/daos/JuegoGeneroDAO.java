package utnfc.isi.backend.parcial.daos;

import jakarta.persistence.EntityManager;
import utnfc.isi.backend.parcial.common.EntityManagerProvider;
import utnfc.isi.backend.parcial.dtos.Punto5;

import java.util.List;

public class JuegoGeneroDAO {
    private final EntityManager entityManager = EntityManagerProvider.getEntityManager();

    public List<Punto5> punto5() {
        String query = "SELECT new utnfc.isi.backend.parcial.dtos.Punto5 (SUM(j.juegosFinalizados)) " +
                "FROM Juego j, Genero g, JuegoGenero jg " +
                "WHERE jg.id.juegoId = j.id AND jg.id.generosId = g.id " +
                "GROUP BY g.id " +
                "ORDER BY 1 DESC";
        return entityManager.createQuery(query, Punto5.class).getResultList();
    }
}
