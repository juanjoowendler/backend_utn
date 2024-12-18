package utnfc.isi.backend.parcial.daos;

import jakarta.persistence.EntityManager;
import utnfc.isi.backend.parcial.common.EntityManagerProvider;
import utnfc.isi.backend.parcial.dtos.Punto3;
import utnfc.isi.backend.parcial.dtos.Punto4;

import java.util.List;

public class JuegoDesarrolladorDAO {
    private final EntityManager entityManager = EntityManagerProvider.getEntityManager();

    public List<Punto3> punto3() {
        String query = "SELECT new utnfc.isi.backend.parcial.dtos.Punto3 (d.nombre, COUNT(j.id)) " +
                "FROM Desarrollador d, Juego j, JuegoDesarrollador jd " +
                "WHERE d.id = jd.id.desarrolladoresId AND jd.id.juegoId = j.id " +
                "GROUP BY d.id " +
                "HAVING COUNT(j.id) > 30";
        return entityManager.createQuery(query, Punto3.class).getResultList();
    }

    public List<Punto4> punto4() {
        String query = "SELECT new utnfc.isi.backend.parcial.dtos.Punto4 (d.nombre, AVG(j.rating)) " +
                "FROM Desarrollador d, Juego j, JuegoDesarrollador jd " +
                "WHERE d.id = jd.id.desarrolladoresId AND jd.id.juegoId = j.id " +
                "GROUP BY d.id " +
                "ORDER BY 2 DESC " +
                "LIMIT 1";
        return entityManager.createQuery(query, Punto4.class).getResultList();
    }
}
