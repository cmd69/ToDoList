package controlador;

import modelo.tareas.Tarea;

import java.io.IOException;
import java.util.LinkedList;

public interface InterfaceControlador {
    LinkedList<Tarea> getTareas();
    LinkedList<Tarea> FiltroPrioridadAlta();
    LinkedList<Tarea> FiltroPrioridadMedia();
    LinkedList<Tarea> FiltroPrioridadBaja();
    LinkedList<Tarea> FiltroCompletado(LinkedList<Tarea> list);
    LinkedList<Tarea> FiltroNoCompletado(LinkedList<Tarea> list);
    void nuevaTarea(String titulo, String desc, boolean c, Tarea.Prioridad prioridad);
    void borrarTarea(Tarea tarea);
    void guardarCambios() throws IOException;
}
