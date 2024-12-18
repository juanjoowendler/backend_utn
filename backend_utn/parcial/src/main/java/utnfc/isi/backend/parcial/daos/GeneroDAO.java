package utnfc.isi.backend.parcial.daos;

import jakarta.persistence.EntityManager;
import utnfc.isi.backend.parcial.common.EntityManagerProvider;
import utnfc.isi.backend.parcial.dtos.Punto4;
import utnfc.isi.backend.parcial.entities.Genero;

import java.util.List;

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

    // CRUD utilizados

    public Genero save(Genero genero) {
        entityManager.getTransaction().begin();
        entityManager.persist(genero);
        entityManager.getTransaction().commit();
        return genero;
    }

    // Otras consultas
    public List<Punto4> punto4() {
        String query = "SELECT new utnfc.isi.backend.parcial.dtos.Punto4 (g.nombre, SUM(j.juegosFinalizados)) " +
                "FROM Juego j, Genero g " +
                "WHERE j.genero.id = g.id " +
                "GROUP BY g.id " +
                "ORDER BY 2 DESC";
        return entityManager.createQuery(query, Punto4.class).getResultList();
    }
}
