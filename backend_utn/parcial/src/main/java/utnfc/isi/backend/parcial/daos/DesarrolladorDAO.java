package utnfc.isi.backend.parcial.daos;

import jakarta.persistence.EntityManager;
import utnfc.isi.backend.parcial.common.EntityManagerProvider;
import utnfc.isi.backend.parcial.dtos.Punto2;
import utnfc.isi.backend.parcial.dtos.Punto3;
import utnfc.isi.backend.parcial.entities.Desarrollador;

import java.util.List;

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

    // CRUD utilizados

    public Desarrollador save(Desarrollador desarrollador) {
        entityManager.getTransaction().begin();
        entityManager.persist(desarrollador);
        entityManager.getTransaction().commit();
        return desarrollador;
    }

    // Otras consultas

    // Determinar la Cantidad de Juegos cargados por cada Desarrollador
    public List<Punto2> punto2() {
        String query = "SELECT new utnfc.isi.backend.parcial.dtos.Punto2 (d.nombre, COUNT(j.id)) " +
                "FROM Desarrollador d, Juego j " +
                "WHERE d.id = j.desarrollador.id " +
                "GROUP BY d.id " +
                "HAVING COUNT(j.id) > 30";
        return entityManager.createQuery(query, Punto2.class).getResultList();
    }

    // Determinar cual es el mejor desarrollador
    public List<Punto3> punto3() {
        String query = "SELECT new utnfc.isi.backend.parcial.dtos.Punto3 (d.nombre, AVG(j.rating)) " +
                "FROM Desarrollador d, Juego j " +
                "WHERE d.id = j.desarrollador.id " +
                "GROUP BY d.id " +
                "ORDER BY 2 DESC " +
                "LIMIT 1";
        return entityManager.createQuery(query, Punto3.class).getResultList();
    }
}
