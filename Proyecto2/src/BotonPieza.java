package Proyecto2.src;

import javax.swing.JButton;

public class BotonPieza extends JButton {
    private int posicionOriginal;  // Posición correcta (1-15)
    private int posicionActual;    // Posición actual (0-15)

    public BotonPieza(int numero, int posicionActual) {
        super(String.valueOf(numero));
        this.posicionOriginal = numero;
        this.posicionActual = posicionActual;
    }

    public int getPosicionOriginal() {
        return posicionOriginal;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public boolean estaEnPosicionCorrecta() {
        return posicionOriginal == posicionActual;
    }
}
