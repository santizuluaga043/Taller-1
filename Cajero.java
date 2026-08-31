public class Cajero extends Empleado {

    private int numeroVentas;
    private double comisionPorVenta;

    public Cajero(
            String nombre,
            double salarioBase,
            double comisionPorVenta
    ) {

        super(nombre, salarioBase);

        this.numeroVentas = 0;
        this.comisionPorVenta = comisionPorVenta;
    }

    public void registrarVenta() {
        numeroVentas = numeroVentas + 1;
    }

    public int getNumeroVentas() {
        return numeroVentas;
    }

    @Override
    public double calcularSalario() {

        return getSalarioBase()
                + numeroVentas * comisionPorVenta;
    }

    @Override
    public String toString() {

        return "Cajero: " + nombre
                + " - Ventas: " + numeroVentas
                + " - Salario: $" + calcularSalario();
    }
}
