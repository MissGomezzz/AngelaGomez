package eci.edu.byteProgramming.ejercicio.paper.videoclub;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona el catálogo de películas y genera el recibo.
 *
 * Principio S: única responsabilidad — orquestar el proceso de alquiler.
 * Principio D: depende de las abstracciones Pelicula y MembresiaStrategy,
 *   no de sus implementaciones concretas.
 */
public class SistemaAlquiler {

    private final List<Pelicula> catalogo = new ArrayList<>();

    public void agregarPelicula(Pelicula pelicula) {
        catalogo.add(pelicula);
    }

    public void mostrarCatalogo() {
        System.out.println("\n📽  Películas disponibles:");
        for (int i = 0; i < catalogo.size(); i++) {
            System.out.printf("  %d. %s%n", i + 1, catalogo.get(i));
        }
    }

    /**
     * Retorna la película por índice base-1, o null si está fuera de rango.
     */
    public Pelicula obtenerPelicula(int indice) {
        if (indice < 1 || indice > catalogo.size()) return null;
        return catalogo.get(indice - 1); // Convierte índice base-1 a base-0
    }

    /**
     * Imprime el recibo aplicando la estrategia de descuento correspondiente.
     * El polimorfismo se activa aquí: membresia.aplicarDescuento() ejecuta
     * código distinto según si el objeto es Básica o Premium.
     */
    public void generarRecibo(MembresiaStrategy membresia, List<Pelicula> seleccion) {

        double subtotal = seleccion.stream()
                .mapToDouble(Pelicula::getPrecio)
                .sum();                                     // Suma de precios sin descuento

        double descuento = membresia.aplicarDescuento(subtotal); // Polimorfismo
        double total     = subtotal - descuento;

        System.out.println("\n--- RECIBO DE ALQUILER ---");
        System.out.println("Cliente: " + membresia.nombre());
        System.out.println("Películas:");
        for (Pelicula p : seleccion) {
            System.out.printf("  - %s - $%,.0f%n", p.getNombreCompleto(), p.getPrecio());
        }

        System.out.printf("Subtotal: $%,.0f%n", subtotal);

        if (descuento > 0) {
            int porcentaje = (int)(((MembresiaPremium) membresia).getPorcentaje() * 100); // Cast seguro: solo Premium tiene descuento > 0
            System.out.printf("Descuento (%d%%): $%,.0f%n", porcentaje, descuento);
        }

        System.out.printf("Total a pagar: $%,.0f%n", total);
        System.out.println("--------------------------");
        System.out.println("¡Disfrute su película!\n");
    }
}