package utnfc.isi.backend.parcial.daos;

import jakarta.persistence.EntityManager;
import utnfc.isi.backend.parcial.common.EntityManagerProvider;
import utnfc.isi.backend.parcial.entities.Juego;

public class JuegoDAO {
    private final EntityManager entityManager = EntityManagerProvider.getEntityManager();

    public Juego save(Juego juego) {
        entityManager.getTransaction().begin();
        entityManager.persist(juego);
        entityManager.getTransaction().commit();
        return juego;
    }
}
