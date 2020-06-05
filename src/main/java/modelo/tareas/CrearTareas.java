package modelo.tareas;

public class CrearTareas implements FabricaTareas{
    @Override
    public Tarea getTarea(String titulo, String descripcion, boolean completado, Tarea.Prioridad prioridad) {
        return new Tarea(titulo, descripcion, completado, prioridad);
    }
}
