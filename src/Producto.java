import java.util.Objects;

public abstract class Producto {

    private String codigo;
    private String nombre;
    private double precio;
    protected int cantidadDisponible;

    private static int cantidadProductos = 0;

    public Producto(String codigo, String nombre, double precio, int cantidadDisponible)
            throws PrecioInvalidoException {

        if (precio <= 0) {
            throw new PrecioInvalidoException("El precio debe ser mayor que 0");
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;

        cantidadProductos++;
    }

    // Constructor sobrecargado
    public Producto(String codigo, String nombre, double precio)
            throws PrecioInvalidoException {

        this(codigo, nombre, precio, 0);
    }

    // Método concreto
    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad: " + cantidadDisponible);
    }

    // Método abstracto
    public abstract void revisarEstado();

    protected void descontarStock(int cantidad)
            throws StockInsuficienteException, CantidadInvalidaException {

        if (cantidad <= 0) {
            throw new CantidadInvalidaException(
                    "La cantidad a vender debe ser mayor que cero"
            );
        }

        if (cantidad > cantidadDisponible) {
            throw new StockInsuficienteException(
                    "No hay suficiente inventario de " + nombre
            );
        }

        cantidadDisponible -= cantidad;
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