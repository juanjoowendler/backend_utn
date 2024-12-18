package utnfc.isi.backend.parcial.daos;

import jakarta.persistence.EntityManager;
import utnfc.isi.backend.parcial.common.EntityManagerProvider;
import utnfc.isi.backend.parcial.dtos.Punto5;
import utnfc.isi.backend.parcial.dtos.Punto6;
import utnfc.isi.backend.parcial.dtos.PuntoPrueba;
import utnfc.isi.backend.parcial.entities.Juego;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class JuegoDAO {
    private final EntityManager entityManager = EntityManagerProvider.getEntityManager();

    // CRUD utilizados

    public Juego save(Juego juego) {
        entityManager.getTransaction().begin();
        entityManager.persist(juego);
        entityManager.getTransaction().commit();
        return juego;
    }

    // Otras consultas

    // Punto 5 (ejemplo con fecha)

    public List<Punto5> punto5() {
        // Fechas en formato String
        String fechaInicio = "1997-10-01";
        String fechaFin = "1997-10-10";

        // Convertir fechas a milisegundos
        long fechaInicioMillis = convertirFechaAMilisegundos(fechaInicio);
        long fechaFinMillis = convertirFechaAMilisegundos(fechaFin);

        String query = "SELECT new utnfc.isi.backend.parcial.dtos.Punto5(j.titulo, j.fechaLanzamiento) " +
                "FROM Juego j " +
                "WHERE j.fechaLanzamiento BETWEEN :fechaInicio AND :fechaFin";

        return entityManager.createQuery(query, Punto5.class)
                .setParameter("fechaInicio", fechaInicioMillis)
                .setParameter("fechaFin", fechaFinMillis)
                .getResultList();
    }

    // Fecha a milisegundos para realizar la consulta SQL
    public static long convertirFechaAMilisegundos(String fecha) {
        return LocalDate.parse(fecha)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }

    // Punto 6
    public List<Punto6> punto6() {
        String query = "SELECT j.titulo, g.nombre " +
                "FROM Juego j, Genero g " +
                "WHERE j.genero.id = g.id " +
                "AND j.titulo LIKE \"Mario%\" " +
                "AND g.nombre IN (\"Racing\", \"Sport\")";
        return  entityManager.createQuery(query, Punto6.class).getResultList();
    }

    // Punto prueba
    public List<PuntoPrueba> puntoPrueba() {
        String query = "SELECT new utnfc.isi.backend.parcial.dtos.PuntoPrueba (j.titulo) " +
                "FROM Juego j";
        return  entityManager.createQuery(query, PuntoPrueba.class).getResultList();
    }
}
