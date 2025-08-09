package Proyecto2.src;

public class Jugador implements Comparable<Jugador> {
    private String nombre;
    private int tiempo;       // En segundos
    private int movimientos;

    public Jugador(String nombre, int tiempo, int movimientos) {
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.movimientos = movimientos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTiempo() {
        return tiempo;
    }

    public int getMovimientos() {
        return movimientos;
    }

    @Override
    public String toString() {
        return nombre + " - Tiempo: " + tiempo + "s - Movs: " + movimientos;
    }

    @Override
    public int compareTo(Jugador otro) {
        return Integer.compare(this.tiempo, otro.tiempo); // Orden ascendente por tiempo
    }
}
