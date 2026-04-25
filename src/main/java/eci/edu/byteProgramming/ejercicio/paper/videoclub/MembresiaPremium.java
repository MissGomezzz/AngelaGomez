package eci.edu.byteProgramming.ejercicio.paper.videoclub;

/**
 * Membresía Premium — Strategy concreta
 *
 * Aplica un 20 % de descuento sobre el subtotal.
 * Principio O (Open/Closed): se agrega sin tocar ninguna clase existente.
 */
public class MembresiaPremium implements MembresiaStrategy {

    private static final double PORCENTAJE_DESCUENTO = 0.20;

    @Override
    public double aplicarDescuento(double subtotal) {
        return subtotal * PORCENTAJE_DESCUENTO;
    }

    @Override
    public String nombre() {
        return "Premium";
    }

    /** Expone el porcentaje para que el recibo pueda mostrarlo dinámicamente. */
    public double getPorcentaje() {
        return PORCENTAJE_DESCUENTO;
    }
}