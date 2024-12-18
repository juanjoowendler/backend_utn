package utnfc.isi.backend.parcial.daos;

import jakarta.persistence.EntityManager;
import utnfc.isi.backend.parcial.common.EntityManagerProvider;
import utnfc.isi.backend.parcial.entities.Genero;

public class GeneroDAO {
    private final EntityManager entityManager = EntityManagerProvider.getEntityManager();

    public Genero findByName(String nombre) {
        String query = "SELECT g FROM Genero g WHERE g.nombre = :nombre";
        try {
            return entityManager.createQuery(query, Genero.class).setParameter("nombre", nombre).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Genero save(Genero genero) {
        entityManager.getTransaction().begin();
        entityManager.persist(genero);
        entityManager.getTransaction().commit();
        return genero;
    }
}
