package utnfc.isi.backend.parcial.utils;

import utnfc.isi.backend.parcial.daos.*;
import utnfc.isi.backend.parcial.entities.*;

import java.io.IOException;
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

                // Obtenemos los atributos y realizamos los parseos necesarios

                // Atributo titulo
                String juegoTitulo = campos[0];

                // Atributo fecha de lanzamiento
                SimpleDateFormat formato = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
                Date juegoFechaLanzamiento = null;
                if (!campos[1].equals("TBD")) {
                    juegoFechaLanzamiento = formato.parse(campos[1]);
                }
                Long juegoFechaLanzamientoEnLong = (juegoFechaLanzamiento != null) ? juegoFechaLanzamiento.getTime() : -1;

                // Atributo desarrolladores
                String juegoDesarrolladoresNombres = campos[2];

                // Atributo resumen
                String juegoResumen = campos[3];

                // Atributo plataformas
                String juegoPlataformasNombres = campos[4];

                // Atributo generos
                String juegoGenerosNombres = campos[5];

                // Atributo rating
                String juegoRating = campos[6];

                // Atributo juegos finalizados
                String juegoPlays = campos[7];

                // Atributo jugando
                String juegoJugando = campos[8];

                // Atributo clasificacion ESRB
                String juegoClasificacionESRBNombre = "";
                if (campos.length < 10) {
                    juegoClasificacionESRBNombre = "";
                } else {
                    juegoClasificacionESRBNombre = campos[9];
                }


                // Se instancian los demas objetos

                // Desarrolladores
                juegoDesarrolladoresNombres = juegoDesarrolladoresNombres.replace("[", "").replace("]", "").replace("'", "").trim();

                if (juegoDesarrolladoresNombres.isEmpty()) {
                    juegoDesarrolladoresNombres = null;
                }

                Desarrollador desarrollador = null;
                if (juegoDesarrolladoresNombres != null) {
                    desarrollador = desarrolladorDAO.findByName(juegoDesarrolladoresNombres);
                    if (desarrollador == null) {
                        Desarrollador nuevoDesarrollador = new Desarrollador();
                        nuevoDesarrollador.setDetalle("");
                        nuevoDesarrollador.setMultivalor(false);
                        nuevoDesarrollador.setNombre(juegoDesarrolladoresNombres);
                        desarrollador = desarrolladorDAO.save(nuevoDesarrollador);
                    }
                }


                // Plataformas
                juegoPlataformasNombres = juegoPlataformasNombres.replace("[", "").replace("]", "").replace("'", "").trim();

                if (juegoPlataformasNombres.isEmpty()) {
                    juegoPlataformasNombres = null;
                }

                Plataforma plataforma = null;
                if (juegoPlataformasNombres != null) {
                    plataforma = plataformaDAO.findByName(juegoPlataformasNombres);
                    if (plataforma == null) {
                        Plataforma nuevaPlataforma = new Plataforma();
                        nuevaPlataforma.setDetalle("");
                        nuevaPlataforma.setMultivalor(false);
                        nuevaPlataforma.setNombre(juegoPlataformasNombres);
                        plataforma = plataformaDAO.save(nuevaPlataforma);
                    }
                }

                // Generos
                juegoGenerosNombres = juegoGenerosNombres.replace("[", "").replace("]", "").replace("'", "").trim();

                if (juegoGenerosNombres.isEmpty()) {
                    juegoGenerosNombres = null;
                }

                Genero genero = null;
                if (juegoGenerosNombres != null) {
                    genero = generoDAO.findByName(juegoGenerosNombres);
                    if (genero == null) {
                        Genero nuevoGenero = new Genero();
                        nuevoGenero.setDetalle("");
                        nuevoGenero.setMultivalor(false);
                        nuevoGenero.setNombre(juegoGenerosNombres);
                        genero = generoDAO.save(nuevoGenero);
                    }
                }

                // ClasificacionESRB
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

                // Seteo atributos sin parseo
                juego.setTitulo(juegoTitulo);
                juego.setFechaLanzamiento(juegoFechaLanzamientoEnLong);
                juego.setGenero(genero);
                juego.setDesarrollador(desarrollador);
                juego.setClasificacionESRB(clasificacionESRB);
                juego.setPlataforma(plataforma);
                juego.setResumen(juegoResumen);

                // Seteo atributos con parseo

                // Atributo jugando
                if (juegoJugando.contains("K")) {
                    String juegoJugandoSinK = juegoJugando.substring(0, juegoJugando.length() - 1);
                    juego.setJugando((int) (Double.parseDouble(juegoJugandoSinK) * 1000));
                } else {
                    juego.setJugando(Integer.parseInt(juegoJugando));
                }

                // Atributo rating
                if (juegoRating.equals("N/A")) {
                    juegoRating = "0";
                }
                juego.setRating(Float.parseFloat(juegoRating));

                // Atributo juegos finalizados
                if (juegoPlays.contains("K")) {
                    String juegoPlaysSinK = juegoPlays.substring(0, juegoPlays.length() - 1);
                    juego.setJuegosFinalizados((int) (Double.parseDouble(juegoPlaysSinK) * 1000));
                } else {
                    juego.setJuegosFinalizados(Integer.parseInt(juegoPlays));
                }

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

