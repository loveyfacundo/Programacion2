import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EjercicioRepaso {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        biblioteca library = new biblioteca();
        library.menu();
    }
}

class libro implements Comparable<libro> {
    // Atributos
    private String nombre;
    private String autor;
    private int isbn;

    // Constructor
    public libro(String nombre, String autor, int isbn) {
        this.nombre = nombre;
        this.autor = autor;
        this.isbn = isbn;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public int getIsbn() {
        return isbn;
    }

    // Setters
    public void setNombre(String newName) {
        this.nombre = newName;
    }

    public void setAutor(String newAutor) {
        this.autor = newAutor;
    }

    public void setIsbn(int newIsbn) {
        this.isbn = newIsbn;
    }

    public void verAtributos() {
        System.out.println("Nombre:" + getNombre());
        System.out.println("Autor:" + getAutor());
        System.out.println("ISBN:" + getIsbn());
    }

    @Override
    public String toString() {
        return "libro{" +
                "nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn=" + isbn +
                '}';
    }

    @Override
    public int compareTo(libro otroLibro) {
        return this.nombre.compareTo(otroLibro.getNombre());
    }
}

class biblioteca {
    private ArrayList<libro> libros;

    // Constructor
    public biblioteca() {
        this.libros = new ArrayList<>();
    }

    // Getters y Setters
    public ArrayList<libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<libro> libros) {
        this.libros = libros;
    }

    public void menu() {
        Scanner leer = new Scanner(System.in);
        int option;
        do {
            System.out.println("=====================================================");
            System.out.println("MENU PRINCIPAL");
            System.out.println("=====================================================");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro");
            System.out.println("3. Eliminar libro");
            System.out.println("4. Listar libros");
            System.out.println("5. Ordenar libros alfabéticamente");
            System.out.println("6. Editar libro mediante el índice");
            System.out.println("7. Salir");
            System.out.println("=====================================================");
            System.out.println("Ingrese el número de la operación que desea realizar:");
            option = leer.nextInt();
            leer.nextLine(); // Limpiar buffer

            switch (option) {
                case 1:
                    System.out.println("Agregando libro...");
                    System.out.println("Ingrese el nombre del libro:");
                    String nombre = leer.nextLine();
                    System.out.println("Ingrese el Autor del libro:");
                    String autor = leer.nextLine();
                    System.out.println("Ingrese el ISBN del libro:");
                    int isbn = leer.nextInt();

                    libro newBook = new libro(nombre, autor, isbn);
                    libros.add(newBook);
                    System.out.println("Libro añadido");
                    break;

                case 2:
                    System.out.println("Buscando libro...");
                    System.out.println("Ingrese el nombre del libro:");
                    String nombreDeseado = leer.nextLine();
                    int posicion = 1;
                    boolean encontrado = false;
                    for (libro libro : libros) {
                        if (libro.getNombre().equals(nombreDeseado)) {
                            System.out.println(
                                    "El libro " + nombreDeseado + " fue encontrado en la posición " + posicion);
                            encontrado = true;
                            break;
                        }
                        posicion++;
                    }
                    if (!encontrado) {
                        System.out.println("El libro no fue encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Eliminando libro...");
                    System.out.println("Ingrese el nombre del libro que desea eliminar:");
                    nombreDeseado = leer.nextLine();
                    if (libros.removeIf(libro -> libro.getNombre().equals(nombreDeseado))) {
                        System.out.println("Libro eliminado.");
                    } else {
                        System.out.println("El libro no fue encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Listando libros...");
                    for (libro libro : libros) {
                        System.out.println("Nombre: " + libro.getNombre() + "\tAutor: " + libro.getAutor() + "\tISBN: "
                                + libro.getIsbn());
                    }
                    break;

                case 5:
                    System.out.println("Ordenando libros alfabéticamente...");
                    Collections.sort(libros);
                    System.out.println("Libros ordenados.");
                    break;

                case 6:
                    System.out.println("Editando libro...");
                    System.out.println("Ingrese el índice del libro que desea editar (1 a " + libros.size() + "):");
                    int indiceDeseado = leer.nextInt();
                    leer.nextLine(); // Limpiar buffer

                    if (indiceDeseado > 0 && indiceDeseado <= libros.size()) {
                        libro libroAEditar = libros.get(indiceDeseado - 1);
                        System.out.println(
                                "Ingrese el nuevo nombre del libro (actual: " + libroAEditar.getNombre() + "): ");
                        String newName = leer.nextLine();
                        System.out.println(
                                "Ingrese el nuevo autor del libro (actual: " + libroAEditar.getAutor() + "): ");
                        String newAutor = leer.nextLine();
                        System.out
                                .println("Ingrese el nuevo ISBN del libro (actual: " + libroAEditar.getIsbn() + "): ");
                        int newIsbn = leer.nextInt();

                        libroAEditar.setNombre(newName);
                        libroAEditar.setAutor(newAutor);
                        libroAEditar.setIsbn(newIsbn);
                        System.out.println("Libro editado.");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 7:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("El número ingresado no corresponde a ninguna de las opciones ofrecidas.");
                    break;
            }
        } while (option != 7);
    }
}
