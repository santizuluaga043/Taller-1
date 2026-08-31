import java.time.LocalDate;

public class Perecedero extends Producto implements Vendible {

    private LocalDate fechaVencimiento;

    public Perecedero(
            String codigo,
            String nombre,
            double precio,
            int cantidadDisponible,
            LocalDate fechaVencimiento
    ) throws PrecioInvalidoException {

        super(codigo, nombre, precio, cantidadDisponible);

        if (fechaVencimiento == null) {
            throw new IllegalArgumentException(
                    "La fecha de vencimiento no puede ser nula"
            );
        }

        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    private boolean estaVencido() {
        return !fechaVencimiento.isAfter(LocalDate.now());
    }

    @Override
    public void revisarEstado() {

        LocalDate hoy = LocalDate.now();
        LocalDate limite = hoy.plusDays(3);

        if (estaVencido()) {

            System.out.println(
                    getNombre() + " está VENCIDO"
            );

        } else if (!fechaVencimiento.isAfter(limite)) {

            System.out.println(
                    "AVISO: " + getNombre() +
                            " está próximo a vencerse"
            );

        } else {

            System.out.println(
                    getNombre() + " está en buen estado"
            );
        }
    }

    @Override
    public void vender(int cantidad)
            throws StockInsuficienteException,
            ProductoVencidoException,
            CantidadInvalidaException {

        if (cantidad <= 0) {
            throw new CantidadInvalidaException(
                    "La cantidad a vender debe ser mayor que cero"
            );
        }

        if (estaVencido()) {

            throw new ProductoVencidoException(
                    "No se puede vender " +
                            getNombre() +
                            " porque está vencido"
            );
        }

        descontarStock(cantidad);
    }

    @Override
    public String toString() {
        return super.toString()
                + " - Vence: "
                + fechaVencimiento;
    }
}