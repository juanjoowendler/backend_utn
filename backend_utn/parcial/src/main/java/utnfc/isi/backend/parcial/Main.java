package utnfc.isi.backend.parcial;

import utnfc.isi.backend.parcial.daos.*;
import utnfc.isi.backend.parcial.dtos.*;
import utnfc.isi.backend.parcial.utils.Archivo;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        ClasificacionESRBDAO clasificacionESRBDAO = new ClasificacionESRBDAO();
        DesarrolladorDAO desarrolladorDAO = new DesarrolladorDAO();
        GeneroDAO generoDAO = new GeneroDAO();
        JuegoDAO juegoDAO = new JuegoDAO();
        PlataformaDAO plataformaDAO = new PlataformaDAO();

        // Punto BD

        // Borrar target y cambiar ruta a /data/games_data.csv antes de entregar
        Archivo.guardarDatosEnBD("C:/Users/juanj/OneDrive/Desktop/parcial/data/games_data_recortado.csv", clasificacionESRBDAO, desarrolladorDAO, generoDAO, juegoDAO, plataformaDAO);

        // Punto 1
        List<Punto1> punto1 = plataformaDAO.punto1();
        punto1.forEach(System.out::println);

        // Punto 2
        List<Punto2> punto2 = desarrolladorDAO.punto2();
        punto2.forEach(System.out::println);

        // Punto 3
        List<Punto3> punto3 = desarrolladorDAO.punto3();
        punto3.forEach(System.out::println);

        // Punto 4
        List<Punto4> punto4 = generoDAO.punto4();
        punto4.forEach(System.out::println);

        // Punto 5 (ejemplo con fecha)
        List<Punto5> punto5 = juegoDAO.punto5();
        punto5.forEach(System.out::println);

        // Punto 6 (ejemplo con LIKE e IN)
        List<Punto6> punto6 = juegoDAO.punto6();
        punto6.forEach(System.out::println);

        // Punto prueba (ejemplo de uso de streams primera letra de cada palabra en mayuscula)
        List<PuntoPrueba> puntoPrueba = juegoDAO.puntoPrueba();
        puntoPrueba.forEach(System.out::println);


        // Generar archivo
        String datos1 = "";
        for (Punto1 punto : punto1) datos1 += punto + "\n";
        Archivo.generarArchivo("./data/punto1.txt", datos1);
    }
}
