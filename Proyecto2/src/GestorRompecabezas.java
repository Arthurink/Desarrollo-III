package Proyecto2.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

public class GestorRompecabezas {
    private Vector<BotonPieza> botones;
    private JPanel panel;
    private int espacioVacio; // posición del espacio vacío (0-15)
    private boolean animando = false;

    public GestorRompecabezas(Vector<BotonPieza> botones, JPanel panel) {
        this.botones = botones;
        this.panel = panel;
        this.espacioVacio = 15;
    }

    private boolean esSolvable(List<Integer> posiciones) {
        int[] array = new int[16];
        for (int i = 0; i < 15; i++) {
            array[posiciones.get(i)] = i + 1;
        }
        array[15] = 0;

        int inversiones = 0;
        for (int i = 0; i < 15; i++) {
            for (int j = i + 1; j < 16; j++) {
                if (array[i] > 0 && array[j] > 0 && array[i] > array[j]) {
                    inversiones++;
                }
            }
        }

        int filaVacia = 4;
        return (inversiones + filaVacia) % 2 == 0;
    }

    public void mezclar() {
        List<Integer> posiciones;
        do {
            posiciones = new ArrayList<>();
            for (int i = 0; i < 15; i++)
                posiciones.add(i);
            Collections.shuffle(posiciones);
        } while (!esSolvable(posiciones));

        for (int i = 0; i < 15; i++) {
            BotonPieza b = botones.get(i);
            b.setPosicionActual(posiciones.get(i));
            actualizarPosicionVisual(b);
        }

        espacioVacio = 15;
    }

    public void moverBoton(BotonPieza boton, Runnable alFinalizar) {
        if (animando)
            return;

        int from = boton.getPosicionActual();
        int to = espacioVacio;

        if (!esAdyacente(from, to))
            return;

        animando = true;

        int fromX = (from % 4) * 80;
        int fromY = (from / 4) * 80;
        int toX = (to % 4) * 80;
        int toY = (to / 4) * 80;

        int steps = 30;
        int delay = 10;
        int deltaX = (toX - fromX) / steps;
        int deltaY = (toY - fromY) / steps;

        Timer animacion = new Timer(delay, null);
        final int[] contador = { 0 };

        animacion.addActionListener(new ActionListener() {
            int x = fromX;
            int y = fromY;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (contador[0] < steps) {
                    x += deltaX;
                    y += deltaY;
                    boton.setLocation(x, y);
                    panel.repaint();
                    contador[0]++;
                } else {
                    animacion.stop();
                    boton.setLocation(toX, toY);
                    boton.setPosicionActual(to);
                    espacioVacio = from;
                    animando = false;
                    if (alFinalizar != null)
                        alFinalizar.run();
                    panel.repaint();
                }
            }
        });

        animacion.start();
    }

    private boolean esAdyacente(int pos1, int pos2) {
        int fila1 = pos1 / 4, col1 = pos1 % 4;
        int fila2 = pos2 / 4, col2 = pos2 % 4;
        return (Math.abs(fila1 - fila2) == 1 && col1 == col2) ||
                (Math.abs(col1 - col2) == 1 && fila1 == fila2);
    }

    private void actualizarPosicionVisual(BotonPieza boton) {
        int pos = boton.getPosicionActual();
        boton.setBounds((pos % 4) * 80, (pos / 4) * 80, 80, 80);
        panel.repaint();
    }

    public boolean estaOrdenado() {
        for (BotonPieza b : botones) {
            if (b.getPosicionActual() != b.getPosicionOriginal() - 1) {
                return false;
            }
        }
        return espacioVacio == 15;
    }

    public void moverUltimo(Runnable alFinalizar) {
        if (animando || espacioVacio != 15)
            return;

        for (BotonPieza b : botones) {
            if (b.getPosicionActual() == 14) {
                moverBoton(b, alFinalizar);
                break;
            }
        }
    }

}
