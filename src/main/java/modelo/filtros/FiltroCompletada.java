package modelo.filtros;

import modelo.tareas.Tarea;
import java.util.LinkedList;

public class FiltroCompletada implements Filtro {

    boolean completado;

    public FiltroCompletada(boolean completado){
        this.completado = completado;
    }

    @Override
    public LinkedList<Tarea> Filtrar(LinkedList<Tarea> tareas) {
        LinkedList<Tarea> filtradas = new LinkedList<>();
        for (Tarea elem :tareas) {
            if (elem.getCompletado() == completado){
                filtradas.add(elem);
            }
        }
        return filtradas;
    }
}
