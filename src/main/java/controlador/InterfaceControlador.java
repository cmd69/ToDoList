package controlador;

import modelo.tareas.Tarea;

import java.util.LinkedList;

public interface InterfaceControlador {
    LinkedList<Tarea> getTareas();
    LinkedList<Tarea> FiltroPrioridadAlta();
    LinkedList<Tarea> FiltroPrioridadMedia();
    LinkedList<Tarea> FiltroPrioridadBaja();
    LinkedList<Tarea> FiltroCompletado(LinkedList<Tarea> list);
    LinkedList<Tarea> FiltroNoCompletado(LinkedList<Tarea> list);
}
