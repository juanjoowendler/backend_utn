package utnfc.isi.backend.parcial.daos;

import jakarta.persistence.EntityManager;
import utnfc.isi.backend.parcial.common.EntityManagerProvider;
import utnfc.isi.backend.parcial.dtos.Punto2;

import java.util.List;

public class JuegoPlataformaDAO {
    private final EntityManager entityManager = EntityManagerProvider.getEntityManager();

    public JuegoPlataformaDAO() {
    }

    public List<Punto2> punto2() {
        String query = "SELECT new utnfc.isi.backend.parcial.dtos.Punto2 (SUM(j.juegosFinalizados)) " +
                "FROM Juego j, Plataforma p, JuegoPlataforma jp " +
                "WHERE jp.id.juegoId = j.id AND jp.id.plataformasId = p.id " +
                "GROUP BY p.id " +
                "ORDER BY 1 DESC";
        return entityManager.createQuery(query, Punto2.class).getResultList();
    }
}
