import java.util.ArrayList;

public class EjercicioSupermercado {
  public static void main(String[] args) {
  }

  public abstract class Persona {
    public String nombreApellido;
    public int dni;

    // Constructor
    public Persona(String nombreApellido, int dni) {
      this.nombreApellido = nombreApellido;
      this.dni = dni;
    }

  }

  public class Cliente extends Persona {
    private boolean mayorista;
    private int nroSocio;

    // Constructor
    public Cliente(String nombreApellido, int dni, boolean mayorista, int nroSocio) {
      super(nombreApellido, dni);
      this.mayorista = mayorista;
      this.nroSocio = nroSocio;
    }

    // Getters and Setters
    public boolean isMayorista() {
      return mayorista;
    }

    public void setMayorista(boolean mayorista) {
      this.mayorista = mayorista;
    }

    public int getNroSocio() {
      return nroSocio;
    }

    public void setNroSocio(int nroSocio) {
      this.nroSocio = nroSocio;
    }

  }

  public class Seguridad extends Persona {

    private String sector;

    // Constructor
    public Seguridad(String nombreApellido, int dni, String sector) {
      super(nombreApellido, dni);
      this.sector = sector;
    }

    // Getters and Setters
    public String getSector() {
      return sector;
    }

    public void setSector(String sector) {
      this.sector = sector;
    }

  }

  public abstract class Empleado extends Persona {
    public int cantHoras;
    public double sueldo;

    // Constructor
    public Empleado(String nombreApellido, int dni, int cantHoras, double sueldo) {
      super(nombreApellido, dni);
      this.cantHoras = cantHoras;
      this.sueldo = sueldo;
    }

  }

  public class Cajero extends Empleado {
    private int nroCaja;

    // Constructor
    public Cajero(String nombreApellido, int dni, int cantHoras, double sueldo, int nroCaja) {
      super(nombreApellido, dni, cantHoras, sueldo);
      this.nroCaja = nroCaja;
    }

    // Getters and Setters
    public int getNroCaja() {
      return nroCaja;
    }

    public void setNroCaja(int nroCaja) {
      this.nroCaja = nroCaja;
    }
  }

  public class Supervisor extends Empleado implements Sucursal {
    private String sector;
    private ArrayList<Empleado> personasACargo;

    // Constructor
    public Supervisor(String nombreApellido, int dni, int cantHoras, double sueldo, String sector,
        ArrayList<EjercicioSupermercado.Empleado> empleado) {
      super(nombreApellido, dni, cantHoras, sueldo);
      this.sector = sector;
      personasACargo = empleado;
    }

    // Getters and Setters
    public String getSector() {
      return sector;
    }

    public void setSector(String sector) {
      this.sector = sector;
    }

    public ArrayList<Empleado> getPersonasACargo() {
      return personasACargo;
    }

    public void setPersonasACargo(ArrayList<Empleado> personasACargo) {
      this.personasACargo = personasACargo;
    }

  }

  public interface Informesñ {
    public void verSueldo();

    public void verParticularidades();
  }

  public interface Jefe {
    public void calcularSueldo();
  }

  public interface Sucursal {
    public static final ArrayList<Empleado> cajeros = new ArrayList<Empleado>();
    public static final ArrayList<Empleado> Supervisores = new ArrayList<Empleado>();
  }
}