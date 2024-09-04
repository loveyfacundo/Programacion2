import java.util.ArrayList;
import java.util.Scanner;

public class crudTienda {

  public static void main(String[] args) {
    // Creación de la instancia de Tienda
    Tienda tienda = new Tienda();

    // Agregando clientes de ejemplo
    tienda.agregarCliente(new Cliente(1, "John Doe", "john.doe@example.com", "555-1234"));
    tienda.agregarCliente(new Cliente(2, "Jane Smith", "jane.smith@example.com", "555-5678"));
    tienda.agregarCliente(new Cliente(3, "Mike Brown", "mike.brown@example.com", "555-9101"));
    tienda.agregarCliente(new Cliente(4, "Lisa White", "lisa.white@example.com", "555-1123"));
    tienda.agregarCliente(new Cliente(5, "Tom Black", "tom.black@example.com", "555-1415"));

    // Listar todos los clientes
    System.out.println("Lista de clientes:");
    tienda.listarClientes();

    // Buscar un cliente por ID
    System.out.println("\nBuscando cliente con ID 3:");
    tienda.buscarCliente(3);

    // Modificar un cliente
    System.out.println("\nModificando cliente con ID 2:");
    tienda.modificarCliente(2);
    System.out.println("Lista de clientes después de modificar:");
    tienda.listarClientes();

    // Eliminar un cliente
    System.out.println("\nEliminando cliente con ID 4:");
    tienda.eliminarCliente(4);
    System.out.println("Lista de clientes después de eliminar:");
    tienda.listarClientes();
  }

  // Clase Cliente
  public static class Cliente {
    private int id;
    private String nombre;
    private String correo;
    private String telefono;

    // Constructor
    public Cliente(int id, String nombre, String correo, String telefono) {
      this.id = id;
      this.nombre = nombre;
      this.correo = correo;
      this.telefono = telefono;
    }

    // Getters y Setters
    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getNombre() {
      return nombre;
    }

    public void setNombre(String nombre) {
      this.nombre = nombre;
    }

    public String getCorreo() {
      return correo;
    }

    public void setCorreo(String correo) {
      this.correo = correo;
    }

    public String getTelefono() {
      return telefono;
    }

    public void setTelefono(String telefono) {
      this.telefono = telefono;
    }
  }

  // Clase Tienda
  public static class Tienda {
    private ArrayList<Cliente> clientes;

    // Constructor de Tienda
    public Tienda() {
      this.clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
      clientes.add(cliente);
    }

    public void buscarCliente(int id) {
      boolean encontrado = false;
      for (Cliente cliente : clientes) {
        if (cliente.getId() == id) {
          System.out.println("Cliente Encontrado");
          System.out.println("ID: " + cliente.getId());
          System.out.println("Nombre: " + cliente.getNombre());
          System.out.println("Correo: " + cliente.getCorreo());
          System.out.println("Teléfono: " + cliente.getTelefono());
          encontrado = true;
          break;
        }
      }
      if (!encontrado) {
        System.out.println("No se ha encontrado un cliente con ese ID");
      }
    }

    public void modificarCliente(int id) {
      Scanner leer = new Scanner(System.in);
      System.out.println("Ingrese el nuevo nombre:");
      String nuevoNombre = leer.nextLine();
      System.out.println("Ingrese el nuevo correo:");
      String nuevoCorreo = leer.nextLine();
      System.out.println("Ingrese el nuevo número de teléfono:");
      String nuevoTelefono = leer.nextLine();

      boolean encontrado = false;
      for (Cliente cliente : clientes) {
        if (cliente.getId() == id) {
          cliente.setNombre(nuevoNombre);
          cliente.setCorreo(nuevoCorreo);
          cliente.setTelefono(nuevoTelefono);
          encontrado = true;
          break;
        }
      }
      if (!encontrado) {
        System.out.println("No se ha encontrado un cliente con ese ID");
      }
      // leer.close(); // No cerrar el Scanner para evitar cerrar System.in
    }

    public void eliminarCliente(int id) {
      boolean eliminado = clientes.removeIf(cliente -> cliente.getId() == id);
      if (eliminado) {
        System.out.println("Cliente eliminado con éxito.");
      } else {
        System.out.println("No se ha encontrado un cliente con ese ID");
      }
    }

    public void listarClientes() {
      for (Cliente cliente : clientes) {
        System.out.println(
            cliente.getId() + "\t" + cliente.getNombre() + "\t" + cliente.getCorreo() + "\t" + cliente.getTelefono());
      }
    }
  }
}