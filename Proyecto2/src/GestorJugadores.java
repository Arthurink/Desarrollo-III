package Proyecto2.src;

import java.io.*;
import java.util.*;

import javax.swing.DefaultListModel;

public class GestorJugadores {
    private static final String ARCHIVO = "mejores_jugadores.txt";

    public static List<Jugador> cargarJugadores() {
        List<Jugador> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String nombre = partes[0];
                    int tiempo = Integer.parseInt(partes[1]);
                    int movimientos = Integer.parseInt(partes[2]);
                    lista.add(new Jugador(nombre, tiempo, movimientos));
                }
            }
        } catch (IOException e) {
            // Si el archivo no existe, no hacemos nada
        }
        return lista;
    }

    public static void guardarJugador(Jugador nuevo) {
        List<Jugador> jugadores = cargarJugadores();
        jugadores.add(nuevo);
        Collections.sort(jugadores); // Ordena por tiempo ascendente

        // Limita a 5 jugadores
        while (jugadores.size() > 5) {
            jugadores.remove(jugadores.size() - 1);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Jugador j : jugadores) {
                bw.write(j.getNombre() + "," + j.getTiempo() + "," + j.getMovimientos());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DefaultListModel<String> obtenerModeloJList() {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        List<Jugador> jugadores = cargarJugadores();
        for (Jugador j : jugadores) {
            modelo.addElement(j.toString());
        }
        return modelo;
    }
}
