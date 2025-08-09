package Proyecto1;

import java.awt.event.*;

public class BotonListener implements ActionListener {
    private final JuegoLangostas juego;
    private final int numero;

    public BotonListener(JuegoLangostas juego, int numero) {
        this.juego = juego;
        this.numero = numero;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        juego.procesarIntento(numero);
    }
}