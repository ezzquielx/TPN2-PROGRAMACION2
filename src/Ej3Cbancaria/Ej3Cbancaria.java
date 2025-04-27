public class Ej3Cbancaria {

    public static void main(String[] args) {
        System.out.println("=== CREACIÓN DE CUENTA ===");
        CuentaBancaria miCuenta = new CuentaBancaria("654321", "Geronimo Benavides", 1000);
        System.out.println("Cuenta creada exitosamente.\n");

        System.out.println("=== INFORMACIÓN INICIAL ===");
        miCuenta.mostrarInformacion();
        System.out.println();

        System.out.println("=== DEPÓSITO ===");
        miCuenta.depositar(500);
        miCuenta.mostrarInformacion();
        System.out.println();

        System.out.println("=== RETIRO ===");
        miCuenta.retirar(200);
        miCuenta.mostrarInformacion();
        System.out.println();

        System.out.println("=== CONSULTA DE SALDO ===");
        double saldoActual = miCuenta.consultarSaldo();
        System.out.println("Saldo: " + saldoActual);
        System.out.println();

        System.out.println("=== INFORMACION DE RETIRO ===");
        miCuenta.retirar(2000);
        miCuenta.mostrarInformacion();
    }
}

class CuentaBancaria {
    private String numeroCuenta;
    private String nombreTitular;
    private double saldo;


    public CuentaBancaria(String numeroCuenta, String nombreTitular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.nombreTitular = nombreTitular;
        this.saldo = saldoInicial;
    }


    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito de $" + cantidad + " realizado correctamente.");
        } else {
            System.out.println("Error: La cantidad a depositar debe ser mayor que cero.");
        }
    }



    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad a retirar debe ser mayor que cero.");
        } else if (cantidad > saldo) {
            System.out.println("Error: Saldo Insuficiente");
        } else {
            saldo -= cantidad;
            System.out.println("Retiro de $" + cantidad + " realizado correctamente.");
        }
    }


    public double consultarSaldo() {
        return saldo;
    }


    public void mostrarInformacion() {
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Titular: " + nombreTitular);
        System.out.println("Saldo actual: $" + saldo);
    }
}