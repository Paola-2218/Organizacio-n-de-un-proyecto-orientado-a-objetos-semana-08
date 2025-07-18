import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase Tarea representa una actividad que puede ser registrada en el sistema.
 */
class Tarea {
    private String nombre;
    private String descripcion;
    private boolean completada;

    public Tarea(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.completada = false;
    }

    public void marcarComoCompletada() {
        this.completada = true;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean estaCompletada() {
        return completada;
    }
}

/**
 * Clase GestorTareas permite almacenar y mostrar tareas.
 */
class GestorTareas {
    private List<Tarea> tareas = new ArrayList<>();

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public List<Tarea> obtenerTareas() {
        return tareas;
    }

    public void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
        } else {
            for (int i = 0; i < tareas.size(); i++) {
                Tarea t = tareas.get(i);
                System.out.println((i + 1) + ". " + t.getNombre() + " - " + (t.estaCompletada() ? "Completada" : "Pendiente"));
            }
        }
    }
}

/**
 * Clase ConsolaVista permite interactuar con el usuario mediante consola.
 */
class ConsolaVista {
    private Scanner scanner = new Scanner(System.in);

    public String leerEntrada(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}

/**
 * Clase Dashboard: Punto de entrada del sistema de gestión de tareas.
 * Muestra un menú de opciones al usuario y permite interactuar con las tareas.
 */
public class Dashboard {
    private GestorTareas gestor = new GestorTareas();
    private ConsolaVista vista = new ConsolaVista();

    /**
     * Inicia la ejecución del menú principal.
     */
    public void iniciar() {
        vista.mostrarMensaje("=== Bienvenido al Sistema de Tareas POO ===");

        int opcion;
        do {
            vista.mostrarMensaje("\nMenú Principal:");
            vista.mostrarMensaje("1. Registrar tarea");
            vista.mostrarMensaje("2. Mostrar tareas");
            vista.mostrarMensaje("3. Salir");
            opcion = Integer.parseInt(vista.leerEntrada("Elige una opción: "));

            switch (opcion) {
                case 1 -> registrarTarea();
                case 2 -> gestor.mostrarTareas();
                case 3 -> vista.mostrarMensaje("¡Hasta pronto!");
                default -> vista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 3);
    }

    private void registrarTarea() {
        String nombre = vista.leerEntrada("Ingrese el nombre de la tarea: ");
        String descripcion = vista.leerEntrada("Ingrese una descripción: ");
        gestor.agregarTarea(new Tarea(nombre, descripcion));
        vista.mostrarMensaje("Tarea registrada con éxito.");
    }

    public static void main(String[] args) {
        new Dashboard().iniciar();
    }
}
