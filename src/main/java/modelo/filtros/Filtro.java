package modelo.filtros;

import modelo.tareas.Tarea;
import java.util.LinkedList;

public interface Filtro {
    LinkedList<Tarea> Filtrar(LinkedList<Tarea> tareas);
}
