package app;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
/**
 * Clase principal que contiene el menú de la aplicación.
 */
public class Main {
    // Scanner global para leer datos del usuario
    private static Scanner scanner = new Scanner(System.in);
    // Gestor que maneja todas las tareas
    private static GestorTareas gestor = new GestorTareas();
    public static void main(String[] args) {
// Mensaje de bienvenida
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║ GESTOR DE TAREAS SIMPLE v1.0 ║");
        System.out.println("╚══════════════════════════════════════╝\n");
// Cargar tareas guardadas previamente
        gestor.cargarDesdeArchivo();
        boolean salir = false;
// Ciclo principal del programa
        while (!salir) {
            mostrarMenu();
            int opcion = leerOpcion();
            switch (opcion) {
                case 1:
// TODO: Implementar por Miembro 1
                    System.out.println("\n➕AGREGAR NUEVA TAREA");
                    System.out.println("------------------------------");

                    //Pedir descripcion
                    System.out.println("Descripcion: ");
                    String descripcion = scanner.nextLine();

                    //Validar que no este vacia
                    if (descripcion.isEmpty()){
                        System.out.println("✖️ La descripcion no puede estar vacia");
                        break;
                    }

                    //Pedir fecha
                    System.out.println("Fecha limite (YYYY-MM-DD): ");
                    String fechaStr = scanner.nextLine().trim();

                    //Intentar crear la tarea
                    try {
                        LocalDate fecha = LocalDate.parse(fechaStr);
                        Tarea nuevatarea = new Tarea(descripcion,fecha);
                        gestor.agregarTarea(nuevatarea);
                    }catch (DateTimeParseException e){
                        System.out.println("❌ Formato de fecha inválido. Usa YYYY-MM-DD (ejemplo: 2025-12-31)");
                    }
                    break;

                case 2:
// TODO: Implementar por Miembro 2
                    System.out.println("\n🔨 Funcionalidad 'Listar tareas' en desarrollo...");
                    break;
                case 3:
// TODO: Implementar por Miembro 3
                    System.out.println("\n🔨 Funcionalidad 'Marcar completada' en desarrollo...");
                    break;
                case 4:
// TODO: Implementar por Miembro 4
                    System.out.println("\n🔨 Funcionalidad 'Eliminar tarea' en desarrollo...");
                    break;
                case 5:
                    System.out.println("\n💾 Guardando tareas...");
                    gestor.guardarEnArchivo();
                    System.out.println("👋 ¡Hasta luego!");
                    salir = true;
                    break;
                default:
                    System.out.println("❌ Opción inválida. Intenta de nuevo.");
            }
        }
        scanner.close();
    }
    /**
     * Muestra el menú principal en pantalla.
     */
    private static void mostrarMenu() {
        System.out.println("\n════════════ MENÚ ════════════");
        System.out.println("1. ➕ Agregar tarea");
        System.out.println("2. 📄 Listar tareas");
        System.out.println("3. ✔️ Marcar como completada");
        System.out.println("4. 🗑️ Eliminar tarea");
        System.out.println("5. 🚪 Salir");
        System.out.println("══════════════════════════════");
        System.out.print("Selecciona una opción: ");
    }
    /**
     * Lee y valida la opción del menú ingresada por el usuario.
     */
    private static int leerOpcion() {
        try {
            int opcion = Integer.parseInt(scanner.nextLine());
            return opcion;
        } catch (NumberFormatException e) {
            return -1; // Opción inválida
        }
    }
}