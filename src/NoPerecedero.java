public class NoPerecedero extends Producto implements Vendible {

    private String categoria;

    public NoPerecedero(
            String codigo,
            String nombre,
            double precio,
            int cantidadDisponible,
            String categoria
    ) throws PrecioInvalidoException {

        super(codigo, nombre, precio, cantidadDisponible);

        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public void revisarEstado() {
        System.out.println(
                getNombre() + " es un producto de larga duración"
        );
    }

    @Override
    public void vender(int cantidad)
            throws StockInsuficienteException,
            CantidadInvalidaException {

        descontarStock(cantidad);
    }

    @Override
    public String toString() {
        return super.toString()
                + " - Categoría: "
                + categoria;
    }
}