public class Cajero extends Empleado {

    private Integer numeroVentas;
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
        numeroVentas++;
    }

    public Integer getNumeroVentas() {
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