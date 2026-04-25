package eci.edu.byteProgramming.ejercicio.paper.videoclub;

/**
 * STRATEGY PATTERN — Interfaz de descuento
 *
 * Define el contrato que toda membresía debe cumplir.
 * Permite agregar nuevos tipos de membresía sin modificar
 * el código existente (Principio O de SOLID).
 */
public interface MembresiaStrategy {

    /** Retorna el monto de descuento a aplicar sobre el subtotal. */
    double aplicarDescuento(double subtotal);

    /** Nombre legible de la membresía para mostrarlo en el recibo. */
    String nombre();
}