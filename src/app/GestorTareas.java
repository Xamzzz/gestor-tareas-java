package app;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
/**
 * Clase que gestiona todas las operaciones sobre las tareas.
 */
public class GestorTareas {
    // Lista donde guardamos todas las tareas
    private ArrayList<Tarea> tareas;
    /**
     * Constructor: inicializa la lista vacía.
     */
    public GestorTareas() {
        this.tareas = new ArrayList<>();
    }
// ============================================
// MÉTODO PARA MIEMBRO 1: Agregar tarea
// ============================================
    /**
     * Agrega una nueva tarea a la lista.
     */
    public void agregarTarea(Tarea tarea) {
// TODO: Implementar por Miembro 1
        System.out.println("⚠️ Método agregarTarea() pendiente de implementación");
    }
// ============================================
// MÉTODO PARA MIEMBRO 2: Listar tareas
// ============================================
    /**
     * Muestra todas las tareas en pantalla.
     */
    public void listarTareas() {
// TODO: Implementar por Miembro 2
        System.out.println("⚠️ Método listarTareas() pendiente de implementación");
    }
// ============================================
// MÉTODO PARA MIEMBRO 3: Marcar completada
// ============================================
    /**
     * Marca una tarea como completada usando su índice.
     */
    public void marcarCompletada(int indice) {
// TODO: Implementar por Miembro 3
        System.out.println("⚠️ Método marcarCompletada() pendiente de implementación");
    }
// ============================================
// MÉTODOS PARA MIEMBRO 4: Eliminar y persistencia
// ============================================
    /**
     * Elimina una tarea de la lista usando su índice.
     */
    public void eliminarTarea(int indice) {
// Validar índice
        if (indice < 0 || indice >= tareas.size()) {
            System.out.println("❌ Índice inválido. Debe estar entre 0 y " + (tareas.size() - 1));
            return;
        }
// Eliminar y guardar referencia
        Tarea tareaEliminada = tareas.remove(indice);
        System.out.println("🗑️ Tarea eliminada: " + tareaEliminada.getDescripcion());
    }
    /**
     * Carga las tareas desde el archivo tareas.txt.
     */
    public void cargarDesdeArchivo() {
        File archivo = new File("tareas.txt");
// Verificar si el archivo existe
        if (!archivo.exists()) {
            System.out.println("ℹ️ No hay archivo previo. Iniciando con lista vacía.");
            return;
        }
        try {
// Abrir archivo para lectura
            Scanner fileScanner = new Scanner(archivo);
            int tareasCargadas = 0;
// Leer línea por línea
            while (fileScanner.hasNextLine()) {
                String linea = fileScanner.nextLine().trim();
// Ignorar líneas vacías
                if (linea.isEmpty()) {
                    continue;
                }
// Separar por comas
                String[] partes = linea.split(",");
// Verificar que tenga los 3 campos
                if (partes.length == 3) {
                    try {
// Extraer datos
                        String descripcion = partes[0];
                        LocalDate fecha = LocalDate.parse(partes[1]);
                        boolean completada = Boolean.parseBoolean(partes[2]);
// Crear y agregar tarea
                        Tarea tarea = new Tarea(descripcion, fecha);
                        tarea.setCompletada(completada);
                        tareas.add(tarea);
                        tareasCargadas++;
                    } catch (Exception e) {
                        System.out.println("⚠️ Error al procesar línea: " + linea);
                    }
                }
            }
// Cerrar archivo
            fileScanner.close();
            System.out.println("📂 Se cargaron " + tareasCargadas + " tarea(s) desde el archivo");
        } catch (IOException e) {
            System.out.println("❌ Error al cargar archivo: " + e.getMessage());
        }
    }

    public void guardarEnArchivo() {
// TODO: Implementar por Miembro 4
        System.out.println("💾 Intentando guardar tareas en archivo...");
    }
            // Método auxiliar para obtener la lista (útil para validaciones)
            public ArrayList<Tarea> getTareas () {
                return tareas;
            }

        }