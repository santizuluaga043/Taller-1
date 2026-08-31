import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        try {

            // CREAR PRODUCTOS

            Perecedero leche = new Perecedero(
                    "P001",
                    "Leche",
                    5000,
                    10,
                    LocalDate.now().plusDays(2)
            );

            Perecedero manzanas = new Perecedero(
                    "P002",
                    "Manzanas",
                    3000,
                    20,
                    LocalDate.now().plusDays(7)
            );

            noPerecedero atun = new noPerecedero(
                    "P003",
                    "Atún",
                    7000,
                    15,
                    "Enlatados"
            );

            noPerecedero jabon = new noPerecedero(
                    "P004",
                    "Jabón",
                    4000,
                    30,
                    "Aseo"
            );

            // REVISAR ESTADO DE PRODUCTOS

            System.out.println("ESTADO DE PRODUCTOS");

            leche.revisarEstado();
            manzanas.revisarEstado();
            atun.revisarEstado();
            jabon.revisarEstado();

            // UPCASTING

            Producto productoGeneral = leche;

            System.out.println("\nUPCASTING");

            System.out.println(
                    "Producto: " + productoGeneral.getNombre()
            );

            // INSTANCEOF Y DOWNCASTING

            if (productoGeneral instanceof Perecedero) {

                Perecedero productoPerecedero =
                        (Perecedero) productoGeneral;

                System.out.println(
                        "Fecha de vencimiento: "
                                + productoPerecedero.getFechaVencimiento()
                );
            }

            // CREAR EMPLEADOS

            Cajero cajero = new Cajero(
                    "Carlos",
                    1800000,
                    10000
            );

            Bodeguero bodeguero = new Bodeguero(
                    "Andrés",
                    1900000
            );


            System.out.println("\nEMPLEADOS");

            System.out.println(cajero);
            System.out.println(bodeguero);

            // PRIMERA VENTA

            try {

                int cantidad = 2;

                leche.vender(cantidad);

                double total =
                        supermercadoUtil.calcularTotal(
                                leche.getPrecio(),
                                cantidad
                        );

                Venta venta1 = new Venta(
                        leche.getNombre(),
                        cantidad,
                        total,
                        metodoPago.TARJETA
                );

                cajero.registrarVenta();

                System.out.println("\nVenta realizada correctamente");
                System.out.println(venta1);

            } catch (stockInsuficienteException
                     | productoVencidoException
                     | cantidadInvalidaException e) {

                System.out.println(
                        "Error en la venta: " + e.getMessage()
                );

            } finally {

                System.out.println(
                        "Finalizó el intento de venta de leche"
                );
            }

            // SEGUNDA VENTA

            try {

                int cantidad = 3;

                atun.vender(cantidad);

                double total =
                        supermercadoUtil.calcularTotal(
                                atun.getPrecio(),
                                cantidad
                        );

                Venta venta2 = new Venta(
                        atun.getNombre(),
                        cantidad,
                        total,
                        metodoPago.EFECTIVO
                );

                cajero.registrarVenta();

                System.out.println("\nVenta realizada correctamente");
                System.out.println(venta2);

            } catch (stockInsuficienteException
                     | cantidadInvalidaException e) {

                System.out.println(
                        "Error en la venta: " + e.getMessage()
                );
            }

            // TERCERA VENTA

            try {

                int cantidad = 1;

                jabon.vender(cantidad);

                double total =
                        supermercadoUtil.calcularTotal(
                                jabon.getPrecio(),
                                cantidad
                        );

                Venta venta3 = new Venta(
                        jabon.getNombre(),
                        cantidad,
                        total,
                        metodoPago.TRANSFERENCIA
                );

                cajero.registrarVenta();

                System.out.println("\nVenta realizada correctamente");
                System.out.println(venta3);

            } catch (stockInsuficienteException
                     | cantidadInvalidaException e) {

                System.out.println(
                        "Error en la venta: " + e.getMessage()
                );
            }

            // INFORMACIÓN FINAL DEL CAJERO

            System.out.println("\nINFORMACIÓN DEL CAJERO");

            System.out.println(
                    "Ventas realizadas: "
                            + cajero.getNumeroVentas()
            );

            System.out.println(
                    "Salario final: $"
                            + cajero.calcularSalario()
            );

            // STATIC

            System.out.println(
                    "\nCantidad de productos creados: "
                            + Producto.getCantidadProductos()
            );


        } catch (precioInvalidoException e) {

            System.out.println(
                    "Error creando producto: "
                            + e.getMessage()
            );
        }
    }
}