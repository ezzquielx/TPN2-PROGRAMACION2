public class Ej5Empleados {
    public static void main(String[] args) {
        Empleado emp1 = new Empleado(1, "Martin Perez Disalvo", 2500.0);
        Empleado emp2 = new Empleado(2, "Geronimo Benavides", 3200.0);
        Empleado emp3 = new Empleado(3, "Luciano Forgione", 2800.0);


        System.out.println("------------------------------------");
        System.out.println("Lista de empleados antes del aumento");
        System.out.println("------------------------------------");



        System.out.println("Legajo: 001, Nombre: " + emp1.getNombre() + ", Salario: " + emp1.getSalario());
        System.out.println("Legajo: 002, Nombre: " + emp2.getNombre() + ", Salario: " + emp2.getSalario());
        System.out.println("Legajo: 003, Nombre: " + emp3.getNombre() + ", Salario: " + emp3.getSalario());

        System.out.println("\n------------------------");
        System.out.println("Después de los aumentos:");
        System.out.println("------------------------");

        emp1.aumentarSalarioPorcentaje(14, "Desempeño");  // 2500 + 14% = 2850
        emp2.aumentarSalarioPorcentaje(10, "Mérito");     // 3200 + 10% = 3520
        emp3.aumentarSalarioPorcentaje(13.36, "Ajuste");  // 2800 + 13.36% ≈ 3174

        System.out.println("Legajo: 001, Nombre: " + emp1.getNombre() + ", Salario: " + emp1.getSalario());
        System.out.println("Legajo: 002, Nombre: " + emp2.getNombre() + ", Salario: " + emp2.getSalario());
        System.out.println("Legajo: 003, Nombre: " + emp3.getNombre() + ", Salario: " + emp3.getSalario());

        System.out.println("\nCantidad total de empleados: " + Empleado.getCantidadEmpleados());
    }
}

class Empleado {
    private int legajo;
    private String nombre;
    private double salario;
    private static int cantidadEmpleados = 0;
    private static int[] legajosUsados = new int[100];

    public Empleado(int legajo, String nombre, double salario) {
        for (int i = 0; i < cantidadEmpleados; i++) {
            if (legajosUsados[i] == legajo) {
                throw new IllegalArgumentException("El legajo ya existe");
            }
        }

        this.legajo = legajo;
        this.nombre = nombre;
        this.salario = salario;

        legajosUsados[cantidadEmpleados] = legajo;
        cantidadEmpleados++;
    }

    public void aumentarSalarioPorcentaje(double porcentaje, String motivo) {
        double aumento = salario * porcentaje / 100;
        salario += aumento;
    }

    public void aumentarSalarioMontoFijo(double monto, String motivo) {
        salario += monto;
    }

    public static int getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }
}