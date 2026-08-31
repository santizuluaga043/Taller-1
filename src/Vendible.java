public interface Vendible {

    void vender(int cantidad)
            throws StockInsuficienteException,
            ProductoVencidoException,
            CantidadInvalidaException;
}