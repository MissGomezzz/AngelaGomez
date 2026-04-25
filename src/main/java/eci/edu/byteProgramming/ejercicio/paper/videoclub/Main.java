package eci.edu.byteProgramming.ejercicio.paper.videoclub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Punto de entrada — Videoclub Don Mario
 *
 * Coordina la interacción con el usuario: muestra catálogo,
 * recoge membresía y selección de películas, y delega a
 * SistemaAlquiler la generación del recibo.
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. Cargar catálogo
        SistemaAlquiler sistema = new SistemaAlquiler();
        sistema.agregarPelicula(new PeliculaFisica ("Interestellar", 8000, true));
        sistema.agregarPelicula(new PeliculaFisica ("El Padrino",    7000, false));
        sistema.agregarPelicula(new PeliculaDigital("Inception",     5000, true));
        sistema.agregarPelicula(new PeliculaDigital("Matrix",        6000, true));

        sistema.mostrarCatalogo();

        // 2. Selección de membresía
        System.out.println("\nTipos de membresía: 1) Básica  2) Premium");
        System.out.print("Seleccione su membresía (1 o 2): ");
        String opcionMembresia = sc.nextLine().trim();

        // Polimorfismo en asignación: la variable es de tipo interfaz
        MembresiaStrategy membresia = opcionMembresia.equals("2")
                ? new MembresiaPremium()
                : new MembresiaBasica(); // Básica por defecto si entrada inválida

        // 3. Selección de películas
        System.out.print("Seleccione películas (números separados por coma): ");
        String[] partes = sc.nextLine().split(","); // Divide la entrada por comas

        List<Pelicula> seleccion = new ArrayList<>();
        for (String parte : partes) {
            String limpio = parte.trim();
            if (!limpio.matches("\\d+")) continue; // Ignora entradas no numéricas

            int idx = Integer.parseInt(limpio);
            Pelicula pelicula = sistema.obtenerPelicula(idx);

            if (pelicula == null) {
                System.out.printf("  ⚠ Índice %d no existe en el catálogo. Se omite.%n", idx);
            } else if (!pelicula.isDisponible()) {
                System.out.printf("  ⚠ '%s' no está disponible. Se omite.%n", pelicula.getTitulo());
            } else {
                seleccion.add(pelicula);
            }
        }

        if (seleccion.isEmpty()) {
            System.out.println("\nNo se seleccionó ninguna película válida. Fin del proceso.");
            sc.close();
            return;
        }

        // 4. Generar recibo
        sistema.generarRecibo(membresia, seleccion);

        sc.close();
    }
}