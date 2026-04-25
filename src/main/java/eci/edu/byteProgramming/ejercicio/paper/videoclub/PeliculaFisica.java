package eci.edu.byteProgramming.ejercicio.paper.videoclub;

/**
 * Película en soporte físico (DVD, Blu-ray, etc.)
 *
 * Polimorfismo: sobreescribe getTipo() para retornar "Física".
 * Principio L (Liskov): intercambiable con cualquier Pelicula.
 */
public class PeliculaFisica extends Pelicula {

    public PeliculaFisica(String titulo, double precio, boolean disponible) {
        super(titulo, precio, disponible);
    }

    @Override
    public String getTipo() {
        return "Física";
    }
}