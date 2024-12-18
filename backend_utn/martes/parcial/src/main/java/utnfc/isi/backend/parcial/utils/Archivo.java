package utnfc.isi.backend.parcial.utils;

import utnfc.isi.backend.parcial.daos.*;
import utnfc.isi.backend.parcial.entities.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Archivo {

    // Lectura del archivo CSV y persistencia en la BD

    public static void guardarDatosEnBD(
            String ruta,
            ClasificacionESRBDAO clasificacionESRBDAO, DesarrolladorDAO desarrolladorDAO,
            GeneroDAO generoDAO, JuegoDAO juegoDAO, PlataformaDAO plataformaDAO
    ) throws IOException, ParseException {
        List<String> lineas = Files.readAllLines(Path.of(ruta));
        for (String linea : lineas) {
            if (!linea.startsWith("Title")) {
                String[] campos = linea.split(";");

                // Atributos simples
                String juegoTitulo = campos[0];

                SimpleDateFormat formato = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
                Date juegoFechaLanzamiento = null;
                if (!campos[1].equals("TBD")) {
                    juegoFechaLanzamiento = formato.parse(campos[1]);
                }

                Long juegoFechaLanzamientoEnLong = (juegoFechaLanzamiento != null) ? juegoFechaLanzamiento.getTime() : -1; // Usar -1 o null si la fecha es "TBD"

                String[] juegoDesarrolladoresNombres = campos[2].split(",");
                if (juegoDesarrolladoresNombres[0].equals("[]")) {
                    continue;
                }

                String juegoResumen = campos[3];

                String[] juegoPlataformasNombres = campos[4].split(",");
                if (juegoPlataformasNombres[0].equals("[]")) {
                    continue;
                }

                String[] juegoGenerosNombres = campos[5].split(",");
                String juegoRating = campos[6];
                String juegoPlays = campos[7];

                String juegoClasificacionESRBNombre = "";
                if (campos.length < 9) {
                    juegoClasificacionESRBNombre = "";
                } else {
                    juegoClasificacionESRBNombre = campos[8];
                }


                // Otros Atributos

                // Desarrolladores
                List<Desarrollador> desarrolladores = new ArrayList<>();

                juegoDesarrolladoresNombres = Arrays.stream(juegoDesarrolladoresNombres)
                        .map(nombre -> nombre.replace("[", "").replace("]", "").replace("'", "").trim())
                        .filter(nombre -> !nombre.isEmpty())
                        .toArray(String[]::new);

                for (String desarrolladorNombre : juegoDesarrolladoresNombres) {
                    Desarrollador desarrollador = desarrolladorDAO.findByName(desarrolladorNombre);

                    if (desarrollador == null) {
                        Desarrollador nuevoDesarrollador = new Desarrollador();
                        nuevoDesarrollador.setDetalle("");
                        nuevoDesarrollador.setMultivalor(false);
                        nuevoDesarrollador.setNombre(desarrolladorNombre);
                        desarrollador = desarrolladorDAO.save(nuevoDesarrollador);
                    }

                    desarrolladores.add(desarrollador);
                }

                // Plataformas
                List<Plataforma> plataformas = new ArrayList<>();

                juegoPlataformasNombres = Arrays.stream(juegoPlataformasNombres)
                        .map(nombre -> nombre.replace("[", "").replace("]", "").replace("'", "").trim())
                        .filter(nombre -> !nombre.isEmpty())
                        .toArray(String[]::new);

                for (String plataformaNombre : juegoPlataformasNombres) {
                    Plataforma plataforma = plataformaDAO.findByName(plataformaNombre);

                    if (plataforma == null) {
                        Plataforma nuevaPlataforma = new Plataforma();
                        nuevaPlataforma.setDetalle("");
                        nuevaPlataforma.setMultivalor(false);
                        nuevaPlataforma.setNombre(plataformaNombre);
                        plataforma = plataformaDAO.save(nuevaPlataforma);
                    }

                    plataformas.add(plataforma);
                }

                // Generos
                List<Genero> generos = new ArrayList<>();

                juegoGenerosNombres = Arrays.stream(juegoGenerosNombres)
                        .map(nombre -> nombre.replace("[", "").replace("]", "").replace("'", "").trim())
                        .filter(nombre -> !nombre.isEmpty())
                        .toArray(String[]::new);

                for (String generoNombre : juegoGenerosNombres) {
                    Genero genero = generoDAO.findByName(generoNombre);

                    if (genero == null) {
                        Genero nuevoGenero = new Genero();
                        nuevoGenero.setDetalle("");
                        nuevoGenero.setMultivalor(false);
                        nuevoGenero.setNombre(generoNombre);
                        genero = generoDAO.save(nuevoGenero);
                    }

                    generos.add(genero);
                }

                // ClasificacionesESRB
                if (juegoClasificacionESRBNombre.isEmpty()) {
                    juegoClasificacionESRBNombre = "Unrated";
                }

                ClasificacionESRB clasificacionESRB = clasificacionESRBDAO.findByName(juegoClasificacionESRBNombre);
                if (clasificacionESRB == null) {
                    ClasificacionESRB nuevaClasificacionESRB = new ClasificacionESRB();

                    switch (juegoClasificacionESRBNombre) {
                        case "Everyone":
                            nuevaClasificacionESRB.setCodigo("E");
                            break;
                        case "Everyone 10+":
                            nuevaClasificacionESRB.setCodigo("E10+");
                            break;
                        case "Teen":
                            nuevaClasificacionESRB.setCodigo("T");
                            break;
                        case "Mature":
                            nuevaClasificacionESRB.setCodigo("M");
                            break;
                        case "Adults Only":
                            nuevaClasificacionESRB.setCodigo("AO");
                            break;
                        case "Rating Pending":
                            nuevaClasificacionESRB.setCodigo("RP");
                            break;
                        default:
                            nuevaClasificacionESRB.setCodigo("UR");
                            break;
                    }
                    nuevaClasificacionESRB.setRating(juegoClasificacionESRBNombre);
                    clasificacionESRB = clasificacionESRBDAO.save(nuevaClasificacionESRB);
                }

                // Instancia de Juego
                Juego juego = new Juego();

                juego.setTitulo(juegoTitulo);
                juego.setFechaLanzamiento(juegoFechaLanzamientoEnLong);
                juego.setGeneros(generos);
                juego.setDesarrolladores(desarrolladores);
                juego.setClasificacionESRB(clasificacionESRB);
                juego.setPlataformas(plataformas);

                if (juegoRating.equals("N/A")) {
                    juegoRating = "0";
                }
                juego.setRating(Float.parseFloat(juegoRating));

                if (juegoPlays.contains("K")) {
                    String juegoPlaysSinK = juegoPlays.substring(0, juegoPlays.length() - 1);
                    juego.setJuegosFinalizados((int) (Double.parseDouble(juegoPlaysSinK) * 1000));
                } else {
                    juego.setJuegosFinalizados(Integer.parseInt(juegoPlays));
                }

                juego.setResumen(juegoResumen);

                // Instancia Juego guardada en la BD
                juegoDAO.save(juego);


            }
        }
    }

    // Generacion de archivo

    public static void generarArchivo(String ruta, String informacion) throws IOException {
        Files.writeString(Path.of(ruta), informacion);
    }

}

