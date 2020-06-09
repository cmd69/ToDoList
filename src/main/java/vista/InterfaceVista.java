package vista;

import controlador.InterfaceControlador;
import modelo.Exceptions.NoOptionSelected;
import modelo.InterfaceModelo;
import modelo.tareas.Tarea;

import java.util.LinkedList;

public interface InterfaceVista {
    void setModelo(InterfaceModelo modelo);
    void setControlador(InterfaceControlador controlador);
    void run();
    void setValores(Tarea tarea);
    LinkedList<Tarea> aplicarFiltros();
    LinkedList<Tarea> aplicarFiltroCompletado(LinkedList<Tarea> lista);
    void actualizarTabla(LinkedList<Tarea> lista);
    void nuevaTarea() throws NoOptionSelected;
    void comprobarDatos() throws NoOptionSelected;
    void limpiarCampos();
    LinkedList<Tarea> getTareas();
    Tarea getSelectedTarea();
    void editarTarea();
    Tarea.Prioridad getSelectedPrioridad();


}
