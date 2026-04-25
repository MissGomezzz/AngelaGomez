package eci.edu.byteProgramming.ejercicio.paper.videoclub;

/**
 * Película en formato digital (descarga / streaming local).
 *
 * Polimorfismo: sobreescribe getTipo() para retornar "Digital".
 * Principio L (Liskov): intercambiable con cualquier Pelicula.
 */
public class PeliculaDigital extends Pelicula {

    public PeliculaDigital(String titulo, double precio, boolean disponible) {
        super(titulo, precio, disponible);
    }

    @Override
    public String getTipo() {
        return "Digital";
    }
}