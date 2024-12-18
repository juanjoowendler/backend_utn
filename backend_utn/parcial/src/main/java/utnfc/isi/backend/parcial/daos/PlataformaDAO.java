package utnfc.isi.backend.parcial.daos;

import jakarta.persistence.EntityManager;
import utnfc.isi.backend.parcial.common.EntityManagerProvider;
import utnfc.isi.backend.parcial.dtos.Punto1;
import utnfc.isi.backend.parcial.entities.Plataforma;

import java.util.List;

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

    // CRUD utilizados

    public Plataforma save(Plataforma plataforma) {
        entityManager.getTransaction().begin();
        entityManager.persist(plataforma);
        entityManager.getTransaction().commit();
        return plataforma;
    }

    // Otras consultas

    // Determinar la Cantidad de Juegos cargados por cada Plataforma
    public List<Punto1> punto1() {
        // El new tiene la direccion del dto utilizado, los atributos del SELECT entre ()
        // Corregir los nombres de acuerdo a las entities. No seran en plural
        String query = "SELECT new utnfc.isi.backend.parcial.dtos.Punto1 (p.nombre, SUM(j.juegosFinalizados)) " +
                "FROM Juego j, Plataforma p " +
                "WHERE j.plataforma.id = p.id " +
                "GROUP BY p.id " +
                "ORDER BY 2 DESC";
        return entityManager.createQuery(query, Punto1.class).getResultList();
    }
}
