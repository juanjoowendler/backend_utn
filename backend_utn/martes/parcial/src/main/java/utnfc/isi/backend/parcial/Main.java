package utnfc.isi.backend.parcial;

import utnfc.isi.backend.parcial.daos.*;
import utnfc.isi.backend.parcial.dtos.Punto2;
import utnfc.isi.backend.parcial.dtos.Punto3;
import utnfc.isi.backend.parcial.dtos.Punto4;
import utnfc.isi.backend.parcial.dtos.Punto5;
import utnfc.isi.backend.parcial.utils.Archivo;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        ClasificacionESRBDAO clasificacionESRBDAO = new ClasificacionESRBDAO();
        DesarrolladorDAO desarrolladorDAO = new DesarrolladorDAO();
        GeneroDAO generoDAO = new GeneroDAO();
        JuegoDAO juegoDAO = new JuegoDAO();
        PlataformaDAO plataformaDAO = new PlataformaDAO();
        JuegoPlataformaDAO juegoPlataformaDAO = new JuegoPlataformaDAO();
        JuegoDesarrolladorDAO juegoDesarrolladorDAO = new JuegoDesarrolladorDAO();
        JuegoGeneroDAO juegoGeneroDAO = new JuegoGeneroDAO();

        // Punto BD

        Archivo.guardarDatosEnBD("C:/Users/juanj/OneDrive/Desktop/parcial/games_data_recortado.csv", clasificacionESRBDAO, desarrolladorDAO, generoDAO, juegoDAO, plataformaDAO);

        // Punto 2
        List<Punto2> punto2 = juegoPlataformaDAO.punto2();
        punto2.forEach(System.out::println);

        // Punto 3
        List<Punto3> punto3 = juegoDesarrolladorDAO.punto3();
        punto3.forEach(System.out::println);

        // Punto 4
        List<Punto4> punto4 = juegoDesarrolladorDAO.punto4();
        punto4.forEach(System.out::println);

        // Punto 5
        List<Punto5> punto5 = juegoGeneroDAO.punto5();
        punto5.forEach(System.out::println);

        // Generar archivo
        String datos2 = "";
        for (Punto2 punto : punto2) datos2 += punto + "\n";
        Archivo.generarArchivo("punto2.txt", datos2);
    }
}
