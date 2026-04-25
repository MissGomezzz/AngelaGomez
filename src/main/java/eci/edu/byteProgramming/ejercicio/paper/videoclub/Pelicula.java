package eci.edu.byteProgramming.ejercicio.paper.videoclub;

/**
 * TEMPLATE METHOD (base) — Película
 *
 * Encapsula los atributos comunes a toda película y obliga a las
 * subclases a definir únicamente su tipo de soporte.
 *
 * Principio S (Single Responsibility): solo gestiona datos de película.
 * Principio D (Dependency Inversion): SistemaAlquiler depende de esta
 *   abstracción, no de PeliculaFisica ni PeliculaDigital.
 */
public abstract class Pelicula {

    // Encapsulamiento: atributos privados, acceso solo mediante getters
    private final String titulo;
    private final double precio;
    private final boolean disponible;

    public Pelicula(String titulo, double precio, boolean disponible) {
        this.titulo     = titulo;
        this.precio     = precio;
        this.disponible = disponible;
    }

    // ── Getters ──────────────────────────────────────────────────────────

    public String getTitulo()      { return titulo; }
    public double getPrecio()      { return precio; }
    public boolean isDisponible()  { return disponible; }

    // ── Método abstracto: cada subclase define su tipo ────────────────────

    /** Retorna la etiqueta del tipo de soporte (ej. "Física", "Digital"). */
    public abstract String getTipo();

    // ── Métodos concretos comunes ─────────────────────────────────────────

    /** Formato para línea de recibo: "Título (Tipo)". */
    public String getNombreCompleto() {
        return titulo + " (" + getTipo() + ")";
    }

    /** Formato para mostrar en el catálogo. */
    @Override
    public String toString() {
        String estado = disponible ? "Disponible" : "No disponible";
        return String.format("[%s] %s - $%,.0f - %s", getTipo(), titulo, precio, estado);
    }
}