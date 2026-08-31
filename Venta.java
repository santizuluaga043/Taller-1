public final class Venta {

    private final String producto;
    private final int cantidad;
    private final double total;
    private final metodoPago metodoPago;

    public Venta(
            String producto,
            int cantidad,
            double total,
            metodoPago metodoPago
    ) {

        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
        this.metodoPago = metodoPago;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getTotal() {
        return total;
    }

    public metodoPago getMetodoPago() {
        return metodoPago;
    }

    @Override
    public String toString() {

        return producto
                + "Cantidad: " + cantidad
                + "Total: $" + total
                + "Pago: " + metodoPago;
    }
}
