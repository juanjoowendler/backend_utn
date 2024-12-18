package utnfc.isi.backend.parcial.daos;

import jakarta.persistence.EntityManager;
import utnfc.isi.backend.parcial.common.EntityManagerProvider;
import utnfc.isi.backend.parcial.entities.Desarrollador;

public class DesarrolladorDAO {
    private final EntityManager entityManager = EntityManagerProvider.getEntityManager();

    public Desarrollador findByName(String nombre) {
        String query = "SELECT d FROM Desarrollador d WHERE d.nombre = :nombre";
        try {
            return entityManager.createQuery(query, Desarrollador.class).setParameter("nombre", nombre).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Desarrollador save(Desarrollador desarrollador) {
        entityManager.getTransaction().begin();
        entityManager.persist(desarrollador);
        entityManager.getTransaction().commit();
        return desarrollador;
    }
}
