package eci.edu.byteProgramming.ejercicio.paper.videoclub;

/**
 * Membresía Básica — Strategy concreta
 *
 * No aplica ningún descuento. Precio normal en todos los alquileres.
 * Principio L (Liskov): puede usarse donde se espere un MembresiaStrategy.
 */
public class MembresiaBasica implements MembresiaStrategy {

    @Override
    public double aplicarDescuento(double subtotal) {
        return 0.0; // Sin descuento
    }

    @Override
    public String nombre() {
        return "Básica";
    }
}