import java.util.Objects;

public abstract class Producto {

    protected String codigo;
    protected String nombre;
    protected double precio;
    protected int cantidadDisponible;

    private static int cantidadProductos = 0;

    public Producto(String codigo, String nombre, double precio, int cantidadDisponible)
            throws precioInvalidoException {

        if (precio <= 0) {
            throw new precioInvalidoException("El precio debe ser mayor que 0");
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;

        cantidadProductos = cantidadProductos + 1;
    }

    // Método abstracto
    public abstract void revisarEstado();

    public void aumentarStock(int cantidad)
        throws cantidadInvalidaException {
        if (cantidad <= 0) {
            throw new cantidadInvalidaException(
                    "La cantidad a ingresar debe ser mayor que cero"
            );
        }
        cantidadDisponible = cantidadDisponible + cantidad;
    }

    public void descontarStock(int cantidad)
            throws stockInsuficienteException, cantidadInvalidaException {

        if (cantidad <= 0) {
            throw new cantidadInvalidaException(
                    "La cantidad a vender debe ser mayor que cero"
            );
        }

        if (cantidad > cantidadDisponible) {
            throw new stockInsuficienteException(
                    "No hay suficiente inventario de " + nombre
            );
        }

        cantidadDisponible = cantidadDisponible - cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public static int getCantidadProductos() {
        return cantidadProductos;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre +
                " - $" + precio +
                " - Stock: " + cantidadDisponible;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Producto)) {
            return false;
        }

        Producto otro = (Producto) obj;

        return codigo.equals(otro.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
