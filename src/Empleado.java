public abstract class Empleado {

    protected String nombre;
    private double salarioBase;

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

    public void mostrarEmpleado() {
        System.out.println("Empleado: " + nombre);
    }
}