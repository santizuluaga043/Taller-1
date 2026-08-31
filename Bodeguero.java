public class Bodeguero extends Empleado {

    public Bodeguero(String nombre, double salarioBase) {
        super(nombre, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase();
    }

    @Override
    public String toString() {

        return "Bodeguero: "
                + nombre
                + " - Salario: $"
                + calcularSalario();
    }
}
