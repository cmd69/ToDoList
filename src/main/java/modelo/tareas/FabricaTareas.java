package modelo.tareas;

public interface FabricaTareas {

    Tarea getTarea(String titulo, String descripcion, boolean completado, Tarea.Prioridad prioridad);
}