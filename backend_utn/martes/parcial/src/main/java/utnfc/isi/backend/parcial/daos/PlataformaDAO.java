package utnfc.isi.backend.parcial.daos;

import jakarta.persistence.EntityManager;
import utnfc.isi.backend.parcial.common.EntityManagerProvider;
import utnfc.isi.backend.parcial.entities.Plataforma;

public class PlataformaDAO {
    private final EntityManager entityManager = EntityManagerProvider.getEntityManager();

    public Plataforma findByName(String nombre) {
        String query = "SELECT p FROM Plataforma p WHERE p.nombre = :nombre";
        try {
            return entityManager.createQuery(query, Plataforma.class).setParameter("nombre", nombre).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Plataforma save(Plataforma plataforma) {
        entityManager.getTransaction().begin();
        entityManager.persist(plataforma);
        entityManager.getTransaction().commit();
        return plataforma;
    }
}
