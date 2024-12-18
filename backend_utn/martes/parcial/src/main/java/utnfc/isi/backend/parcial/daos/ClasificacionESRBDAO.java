package utnfc.isi.backend.parcial.daos;

import jakarta.persistence.EntityManager;
import utnfc.isi.backend.parcial.common.EntityManagerProvider;
import utnfc.isi.backend.parcial.entities.ClasificacionESRB;

public class ClasificacionESRBDAO {
    private final EntityManager entityManager = EntityManagerProvider.getEntityManager();

    public ClasificacionESRB findByName(String nombre) {
        String query = "SELECT c FROM ClasificacionESRB c WHERE c.rating = :nombre";
        try {
            return entityManager.createQuery(query, ClasificacionESRB.class).setParameter("nombre", nombre).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public ClasificacionESRB save(ClasificacionESRB clasificacionESRB) {
        entityManager.getTransaction().begin();
        entityManager.persist(clasificacionESRB);
        entityManager.getTransaction().commit();
        return clasificacionESRB;
    }
}
