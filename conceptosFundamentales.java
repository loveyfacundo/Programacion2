import java.util.ArrayList;

class Humane {
  private String nombre;
  private String apellido;
  private int dni;

  public Humane(String nombre, String apellido, int dni) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public int getDni() {
    return dni;
  }

  @Override
  public String toString() {
    return "Nombre: " + this.nombre + "\nApellido: " + this.apellido + "\nDNI: " + this.dni;
  }
}

class Empleado extends Humane {
  private double sueldo;

  public Empleado(String nombre, String apellido, int dni, double sueldo) {
    super(nombre, apellido, dni);
    this.sueldo = sueldo;
  }

  public double getSueldo() {
    return sueldo;
  }

  @Override
  public String toString() {
    return "\n" + super.toString() + "\nSueldo: " + this.sueldo;
  }
}

class Caja {
  private Empleado empleado;
  private int nroCaja;

  public Caja(Empleado empleado, int nroCaja) {
    this.empleado = empleado;
    this.nroCaja = nroCaja;
  }

  public Empleado getEmpleado() {
    return empleado;
  }

  public int getNumeroCaja() {
    return nroCaja;
  }

  @Override
  public String toString() {
    return this.empleado.toString() + "\nNro de caja: " + this.nroCaja;
  }
}

class Cliente extends Humane {
  private boolean mayorista;

  public Cliente(String nombre, String apellido, int dni, boolean mayorista) {
    super(nombre, apellido, dni);
    this.mayorista = mayorista;
  }

  public boolean esMayorista() {
    return mayorista;
  }

  @Override
  public String toString() {
    return "\n" + super.toString() + "\nMayorista: " + this.mayorista;
  }
}

// Clase Producto
class Producto {
  private String nombre;
  private double precio;
  private int cantidad;

  public Producto(String nombre, double precio, int cantidad) {
    this.nombre = nombre;
    this.precio = precio;
    this.cantidad = cantidad;
  }

  public String getNombre() {
    return nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void reducirCantidad(int cantidadComprada) {
    this.cantidad -= cantidadComprada;
  }
}

// Clase Transaccion
class Transaccion {
  private Cliente cliente;
  private Caja caja;
  private Producto[] productos;
  private double totalPagado;

  public Transaccion(Cliente cliente, Caja caja, Producto[] productos) {
    this.cliente = cliente;
    this.caja = caja;
    this.productos = productos;
    this.totalPagado = calcularTotal();
  }

  private double calcularTotal() {
    double total = 0;
    for (Producto producto : productos) {
      double precioFinal = producto.getPrecio();
      if (cliente.esMayorista()) {
        precioFinal *= 0.9; // 10% de descuento para mayoristas
      }
      total += precioFinal * producto.getCantidad();
    }
    return total;
  }

  public void mostrarDetalle() {
    System.out.println("Cliente: " + cliente.getNombre());
    System.out.println("Atendido por: " + caja.getEmpleado().getNombre() + " en la caja " + caja.getNumeroCaja());
    System.out.println("Productos comprados:");
    for (Producto producto : productos) {
      System.out.println(
          " - " + producto.getNombre() + " x" + producto.getCantidad() + " - $" + producto.getPrecio() + " c/u");
    }
    System.out.println("Total pagado: $" + totalPagado);
  }
}

public class conceptosFundamentales {
  public static void main(String[] args) {
    Cliente cliente = new Cliente("Juan", "Perez", 12345678, true);
    System.out.println(cliente);
  }
}