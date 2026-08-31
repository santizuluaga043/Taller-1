import java.time.LocalDate;

public class Perecedero extends Producto implements Vendible {

    private LocalDate fechaVencimiento;

    public Perecedero(
            String codigo,
            String nombre,
            double precio,
            int cantidadDisponible,
            LocalDate fechaVencimiento
    ) throws precioInvalidoException {

        super(codigo, nombre, precio, cantidadDisponible);

        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    @Override
    public void revisarEstado() {

        LocalDate hoy = LocalDate.now();
        LocalDate limite = hoy.plusDays(3);

        if (fechaVencimiento.isBefore(hoy)) {

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
            throws stockInsuficienteException,
            productoVencidoException,
            cantidadInvalidaException{

        if (fechaVencimiento.isBefore(LocalDate.now())) {

            throw new productoVencidoException(
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
