package Proyecto1;

public class UtilidadesJuego {

    public static boolean esAdyacente(int a, int b, int columnas) {
        int filaA = a / columnas;
        int colA = a % columnas;
        int filaB = b / columnas;
        int colB = b % columnas;
        return Math.abs(filaA - filaB) <= 1 && Math.abs(colA - colB) <= 1;
    }

    public static String calcularDireccion(int desde, int hacia, int columnas) {
        int filaA = desde / columnas;
        int colA = desde % columnas;
        int filaB = hacia / columnas;
        int colB = hacia % columnas;

        String vertical = filaB < filaA ? "Sur" : filaB > filaA ? "Norte" : "";
        String horizontal = colB > colA ? "Este" : colB < colA ? "Oeste" : "";

        return vertical + (vertical.isEmpty() || horizontal.isEmpty() ? "" : "-") + horizontal;
    }
}

