package Main;

import modelo.Nodo;
import negocio.ArbolBinario;
import app.VistaArbol;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolBinario<String> arbolActual = new ArbolBinario<>();
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n=== MENu ===");
            System.out.println("1. Cargar arbol A");
            System.out.println("2. Cargar arbol B");
            System.out.println("3. Ver arbol actual (Grafico)");
            System.out.println("4. Consultar datos del arbol actual");
            System.out.println("9. ¿Es cadena? (Prueba de tu método)");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    arbolActual = construirArbolA();
                    System.out.println("\n¡Árbol A cargado con exito!");
                    VistaArbol.mostrar(arbolActual);
                    break;
                case 2:
                    arbolActual = construirArbolB();
                    System.out.println("\n¡Arbol B cargado con exito!");
                    VistaArbol.mostrar(arbolActual);
                    break;
                case 3:
                    System.out.println();
                    VistaArbol.mostrar(arbolActual);
                    VistaArbol.mostrarGrafico(arbolActual);
                    break;
                case 4:
                    if (arbolActual.esVacio()) {
                        System.out.println("\nEl árbol está vacío.");
                    } else {
                        System.out.println("\n--- Consultas ---");
                        System.out.println("Raíz: " + arbolActual.getRaiz().getDato());
                        System.out.println("Nodos: " + arbolActual.contarNodos());
                        System.out.println("Hojas: " + arbolActual.contarHojas());
                        System.out.println("Altura: " + arbolActual.altura());
                    }
                    break;
                case 9:
                    
                    System.out.println("\n--- ¿Es cadena? ---");
                    System.out.println("Resultado: " + esCadena(arbolActual));
                    System.out.println("Altura: " + arbolActual.altura() + " | Nodos: " + arbolActual.contarNodos());
                    break;
                case 0:
                    System.out.println("\nSaliendo.");
                    break;
                default:
                    System.out.println("\nOpcion no valida. Intenta de nuevo.");
            }
        }
        scanner.close();
    }

    // --- MÉTODOS AUXILIARES ---

    public static ArbolBinario<String> construirArbolA() {
        ArbolBinario<String> arbol = new ArbolBinario<>();
        Nodo<String> ltx = arbol.crearRaiz("LTX");
        
        Nodo<String> atf = arbol.agregarIzquierdo(ltx, "ATF");
        arbol.agregarIzquierdo(atf, "TUA");
        arbol.agregarDerecho(atf, "IBB");
        
        Nodo<String> mch = arbol.agregarDerecho(ltx, "MCH");
        Nodo<String> snc = arbol.agregarIzquierdo(mch, "SNC");
        arbol.agregarIzquierdo(snc, "LGQ");
        arbol.agregarDerecho(mch, "OCC");
        
        return arbol;
    }

    public static ArbolBinario<String> construirArbolB() {
        ArbolBinario<String> arbol = new ArbolBinario<>();
        Nodo<String> gps = arbol.crearRaiz("GPS");
        Nodo<String> scy = arbol.agregarDerecho(gps, "SCY");
        Nodo<String> mrr = arbol.agregarDerecho(scy, "MRR");
        Nodo<String> ptz = arbol.agregarDerecho(mrr, "PTZ");
        arbol.agregarDerecho(ptz, "TPN");
        return arbol;
    }

    public static boolean esCadena(ArbolBinario<String> arbol) {
        if (arbol.esVacio()) return false;
        return arbol.altura() == (arbol.contarNodos() - 1);
    }
}