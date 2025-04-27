import java.util.Scanner;
public class Ej4Libro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;


        Libro libro1 = new Libro("Harry Potter y la Piedra Filosofal", "J.K. Rowling", "978-8478884957");
        Libro libro2 = new Libro("El Señor de los Anillos", "J.R.R. Tolkien", "978-0345339683");
        Libro libro3 = new Libro("Cien años de soledad", "Gabriel García Márquez", "978-0307474728");


        Libro[] biblioteca = {libro1, libro2, libro3};

        System.out.println("===== SISTEMA DE BIBLIOTECA =====");

        do {

            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Ver todos los libros");
            System.out.println("2. Prestar un libro");
            System.out.println("3. Devolver un libro");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        mostrarTodosLosLibros(biblioteca);
                        break;

                    case 2:
                        int libroAPrestar = seleccionarLibro(scanner, biblioteca);
                        if (libroAPrestar >= 0 && libroAPrestar < biblioteca.length) {
                            biblioteca[libroAPrestar].prestar();
                            biblioteca[libroAPrestar].mostrarInformacion();
                        }
                        break;

                    case 3:
                        int libroADevolver = seleccionarLibro(scanner, biblioteca);
                        if (libroADevolver >= 0 && libroADevolver < biblioteca.length) {
                            biblioteca[libroADevolver].devolver();
                            biblioteca[libroADevolver].mostrarInformacion();
                        }
                        break;

                    case 4:
                        System.out.println("¡Gracias por usar el sistema de biblioteca!");
                        break;

                    default:
                        System.out.println("Opción inválida. Por favor, intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                opcion = 0;
            }

        } while (opcion != 4);

        scanner.close();
    }


    public static void mostrarTodosLosLibros(Libro[] biblioteca) {
        System.out.println("\n----- LISTADO DE LIBROS -----");
        for (int i = 0; i < biblioteca.length; i++) {
            System.out.println("\nLIBRO #" + (i + 1));
            biblioteca[i].mostrarInformacion();
            System.out.println("----------------------------");
        }
    }


    public static int seleccionarLibro(Scanner scanner, Libro[] biblioteca) {
        mostrarTodosLosLibros(biblioteca);
        System.out.print("\nSeleccione el número del libro: ");
        try {
            int seleccion = Integer.parseInt(scanner.nextLine());
            if (seleccion < 1 || seleccion > biblioteca.length) {
                System.out.println("Número de libro inválido.");
                return -1;
            }
            return seleccion - 1;
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un número válido.");
            return -1;
        }
    }
}

class Libro {

    private String titulo;
    private String autor;
    private String ISBN;
    private boolean disponible;

    public Libro(String titulo, String autor, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.disponible = true;
    }

    public void prestar() {
        if (disponible) {
            disponible = false;
            System.out.println("Libro prestado exitosamente.");
        } else {
            System.out.println("No se puede prestar. El libro ya está prestado.");
        }
    }

    public void devolver() {
        if (!disponible) {
            disponible = true;
            System.out.println("Libro devuelto exitosamente.");
        } else {
            System.out.println("No se puede devolver. El libro ya está disponible.");
        }
    }

    public void mostrarInformacion() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + ISBN);

        if (disponible) {
            System.out.println("Estado: Disponible");
        } else {
            System.out.println("Estado: Prestado");
        }
    }
}