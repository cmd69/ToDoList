package modelo.serializacion;

import controlador.Controlador;
import controlador.InterfaceControlador;
import modelo.InterfaceModelo;
import modelo.Modelo;
import modelo.tareas.Tarea;
import vista.Vista;

public class PrimerModelo {
    public static void main(String[] args) {

        PrimerModelo f = new PrimerModelo();
        Modelo m = new Modelo();
        Vista v = new Vista();
        Controlador c = new Controlador();

        v.setModelo(m);
        v.setControlador(c);
        c.setModelo(m);
        c.setVista(v);

        f.primerosElementos(m);
        v.run();

    }

    public void primerosElementos(InterfaceModelo m){
        Tarea.Prioridad prioridad = Tarea.Prioridad.ALTA;
        Tarea.Prioridad prioridad2 = Tarea.Prioridad.BAJA;
        Tarea tarea = new Tarea("Comprar", "Necesito agua", false, prioridad);
        Tarea tarea2 = new Tarea("Salir", "Necesit oED", true, Tarea.Prioridad.BAJA);

        m.NuevaTarea(tarea);
        m.NuevaTarea(tarea2);

    }
}
