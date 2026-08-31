public class noPerecedero extends Producto implements Vendible {

    private String categoria;

    public noPerecedero(
            String codigo,
            String nombre,
            double precio,
            int cantidadDisponible,
            String categoria
    ) throws precioInvalidoException {

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
            throws stockInsuficienteException,
            cantidadInvalidaException {

        descontarStock(cantidad);
    }

    @Override
    public String toString() {
        return super.toString()
                + " - Categoría: "
                + categoria;
    }
}
