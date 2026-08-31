public class supermercadoUtil {

    private supermercadoUtil() {
    }

    public static double calcularTotal(
            double precio,
            int cantidad
    ) {

        return precio * cantidad;
    }

    // Sobrecarga de métodos
    public static double calcularTotal(
            double precio,
            int cantidad,
            double descuento
    ) {

        double subtotal = precio * cantidad;

        return subtotal - subtotal * descuento;
    }
}
