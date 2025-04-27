import java.util.Scanner;

public class Ej2Reloj {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Reloj miReloj = new Reloj();

        System.out.println("=== CONFIGURACIÓN DEL RELOJ ===");

        int hora = -1;
        while (hora < 0 || hora > 23) {
            System.out.print("Ingrese la hora (0-23): ");
            try {
                hora = Integer.parseInt(scanner.nextLine());
                if (hora < 0 || hora > 23) {
                    System.out.println("Error: La hora debe estar entre 0 y 23.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }

        int minutos = -1;
        while (minutos < 0 || minutos > 59) {
            System.out.print("Ingrese los minutos (0-59): ");
            try {
                minutos = Integer.parseInt(scanner.nextLine());
                if (minutos < 0 || minutos > 59) {
                    System.out.println("Error: Los minutos deben estar entre 0 y 59.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }

        int segundos = -1;
        while (segundos < 0 || segundos > 59) {
            System.out.print("Ingrese los segundos (0-59): ");
            try {
                segundos = Integer.parseInt(scanner.nextLine());
                if (segundos < 0 || segundos > 59) {
                    System.out.println("Error: Los segundos deben estar entre 0 y 59.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }

        miReloj.establecerHora(hora, minutos, segundos);
        System.out.println("\nHora establecida correctamente.");

        int opcion = 0;
        do {
            System.out.println("\n=== MENÚ DEL RELOJ ===");
            System.out.println("1. Mostrar hora actual");
            System.out.println("2. Avanzar un segundo");
            System.out.println("3. Establecer nueva hora");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                System.out.println();

                switch (opcion) {
                    case 1:
                        System.out.println("-----------");
                        System.out.println("Hora actual");
                        System.out.println("-----------");
                        miReloj.mostrarHora();
                        break;

                    case 2:
                        miReloj.avanzarSegundo();
                        System.out.println("----------------");
                        System.out.println("Hora actualizada");
                        System.out.println("----------------");
                        miReloj.mostrarHora();
                        break;

                    case 3:
                        System.out.print("Ingrese la hora (0-23): ");
                        hora = Integer.parseInt(scanner.nextLine());
                        System.out.print("Ingrese los minutos (0-59): ");
                        minutos = Integer.parseInt(scanner.nextLine());
                        System.out.print("Ingrese los segundos (0-59): ");
                        segundos = Integer.parseInt(scanner.nextLine());

                        miReloj.establecerHora(hora, minutos, segundos);
                        System.out.println("Hora establecida correctamente.");
                        break;

                    case 4:
                        System.out.println("Saliendo del programa. ¡Hasta luego!");
                        break;

                    default:
                        System.out.println("Opción inválida. Por favor intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
                opcion = 0;
            }

        } while (opcion != 4);

        scanner.close();
    }
}

class Reloj {
    private int hora;
    private int minuto;
    private int segundo;

    public void establecerHora(int h, int m, int s) {
        hora = (h >= 0 && h < 24) ? h : 0;
        minuto = (m >= 0 && m < 60) ? m : 0;
        segundo = (s >= 0 && s < 60) ? s : 0;
    }

    public void mostrarHora() {
        System.out.printf("%02d:%02d:%02d\n", hora, minuto, segundo);
    }

    public void avanzarSegundo() {
        segundo++;
        if (segundo == 60) {
            segundo = 0;
            minuto++;
            if (minuto == 60) {
                minuto = 0;
                hora++;
                if (hora == 24) {
                    hora = 0;
                }
            }
        }
    }
}