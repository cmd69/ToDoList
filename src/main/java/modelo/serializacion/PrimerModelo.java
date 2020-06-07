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
        Tarea tarea = new Tarea("Comprar", "Necesito agua", false, Tarea.Prioridad.BAJA);
        Tarea tarea2 = new Tarea("Salir", "Necesit oED", true, Tarea.Prioridad.BAJA);
        Tarea tarea3 = new Tarea("Beber", "Agua", true, Tarea.Prioridad.ALTA);
        Tarea tarea4 = new Tarea("Consumir", "LA Droga", false, Tarea.Prioridad.ALTA);
        Tarea tarea5 = new Tarea("Robar", "en el cine", true, Tarea.Prioridad.MEDIA);
        Tarea tarea6 = new Tarea("Poner", "a todos a bailar", false, Tarea.Prioridad.MEDIA);
        Tarea tarea7 = new Tarea("Saber", "Quien hizo la sopa de murciélago", false, Tarea.Prioridad.MEDIA);

        m.NuevaTarea(tarea);
        m.NuevaTarea(tarea2);
        m.NuevaTarea(tarea3);
        m.NuevaTarea(tarea4);
        m.NuevaTarea(tarea5);
        m.NuevaTarea(tarea6);
        m.NuevaTarea(tarea7);

    }
}
