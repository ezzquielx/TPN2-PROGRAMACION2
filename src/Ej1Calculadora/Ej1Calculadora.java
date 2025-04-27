import java.util.Scanner;

public class Ej1Calculadora {


    public double sumar(double a, double b) {
        return a + b;
    }


    public double restar(double a, double b) {
        return a - b;
    }


    public double multiplicar(double a, double b) {
        return a * b;
    }


    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return a / b;
    }


    public static void main(String[] args) {
        Ej1Calculadora calculadora = new Ej1Calculadora();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("-----------------------------");
            System.out.println("* Seleccione la operación:  *");
            System.out.println("-----------------------------");
            System.out.println("---------------------");
            System.out.println("*  1. Sumar         *");
            System.out.println("*  2. Restar        *");
            System.out.println("*  3. Multiplicar   *");
            System.out.println("*  4. Dividir       *");
            System.out.println("---------------------");

            int opcion = scanner.nextInt();

            System.out.print("Ingrese el primer número: ");
            double num1 = scanner.nextDouble();
            System.out.print("Ingrese el segundo número: ");
            double num2 = scanner.nextDouble();

            double resultado = 0;

            switch (opcion) {
                case 1:
                    resultado = calculadora.sumar(num1, num2);
                    System.out.println("Resultado de la suma: " + resultado);
                    break;
                case 2:
                    resultado = calculadora.restar(num1, num2);
                    System.out.println("Resultado de la resta: " + resultado);
                    break;
                case 3:
                    resultado = calculadora.multiplicar(num1, num2);
                    System.out.println("Resultado de la multiplicación: " + resultado);
                    break;
                case 4:
                    try {
                        resultado = calculadora.dividir(num1, num2);
                        System.out.println("Resultado de la división: " + resultado);
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
            }
            System.out.print("¿Desea realizar otra operación? (s/n): ");
            char respuesta = scanner.next().charAt(0);
            continuar = (respuesta == 's' || respuesta == 'S');
        }
        System.out.println("Gracias por usar la calculadora.");
    }
}