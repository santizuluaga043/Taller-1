public interface Vendible {

    void vender(int cantidad)
            throws stockInsuficienteException,
            productoVencidoException,
            cantidadInvalidaException;
}
