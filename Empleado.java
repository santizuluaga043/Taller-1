public abstract class Empleado {

    protected String nombre;
    protected double salarioBase;

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    protected double getSalarioBase() {
        return salarioBase;
    }

    public abstract double calcularSalario();

    @Override
    public String toString() {
        return "Empleado: " + nombre
                + " - Salario base: $" + salarioBase;
    }
}
