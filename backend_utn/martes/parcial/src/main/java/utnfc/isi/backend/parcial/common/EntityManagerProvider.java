package utnfc.isi.backend.parcial.common;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

// Aplicando el patron Singleton
public class EntityManagerProvider {
    private static EntityManagerProvider emp;
    private final EntityManager em;

    // Iniciar EntityManager
    private EntityManagerProvider() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("parcial-pu");
        em = emf.createEntityManager();
    }

    // Crear la instancia
    public static EntityManager getEntityManager() {
        if (emp == null) {
            emp = new EntityManagerProvider();
        }

        return emp.em;
    }

    // Cerrar conexion
    public static void closeEntityManager() {
        if (emp.em != null) {
            emp.em.close();
            emp = null;
        }
    }
}