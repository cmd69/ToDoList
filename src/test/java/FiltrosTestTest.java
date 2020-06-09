import controlador.Controlador;
import modelo.Modelo;
import modelo.tareas.Tarea;
import org.junit.jupiter.api.Test;
import vista.Vista;

import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class FiltrosTestTest {

    private Modelo m;
    private Vista v;
    private Controlador c;
    LinkedList<Tarea> listaCompletados;
    LinkedList<Tarea> listaNoCompletados;
    LinkedList<Tarea> listaAltaPrioridad;
    LinkedList<Tarea> listaAltaCompletado;
    LinkedList<Tarea> listaBajaNoCompletado;

    public void crearDatos(){
        m = new Modelo();
        v = new Vista();
        c = new Controlador();

        v.setModelo(m);
        v.setControlador(c);
        c.setModelo(m);
        c.setVista(v);

        listaCompletados = new LinkedList<>();
        listaNoCompletados = new LinkedList<>();
        listaAltaPrioridad = new LinkedList<>();
        listaAltaCompletado = new LinkedList<>();
        listaBajaNoCompletado = new LinkedList<>();

        Tarea tarea = new Tarea("Comprar", "Necesito agua", true, Tarea.Prioridad.BAJA);
        Tarea tarea2 = new Tarea("Salir", "Necesit dar un paseo", true, Tarea.Prioridad.BAJA);
        Tarea tarea3 = new Tarea("Beber", "Hay que consumir mucha agua", true, Tarea.Prioridad.ALTA);
        Tarea tarea4 = new Tarea("Consumir", "Frutas y verduras", false, Tarea.Prioridad.ALTA);
        Tarea tarea5 = new Tarea("Robar", "en el cine", true, Tarea.Prioridad.MEDIA);
        Tarea tarea6 = new Tarea("Poner", "a todos a bailar", false, Tarea.Prioridad.MEDIA);
        Tarea tarea7 = new Tarea("Saber", "Quien hizo la sopa de murciélago", false, Tarea.Prioridad.MEDIA);

        listaCompletados.add(tarea);
        listaCompletados.add(tarea2);
        listaCompletados.add(tarea3);
        listaCompletados.add(tarea5);

        listaNoCompletados.add(tarea4);
        listaNoCompletados.add(tarea6);
        listaNoCompletados.add(tarea7);

        listaAltaPrioridad.add(tarea3);
        listaAltaPrioridad.add(tarea4);

        listaAltaCompletado.add(tarea3);

        m.NuevaTarea(tarea);
        m.NuevaTarea(tarea2);
        m.NuevaTarea(tarea3);
        m.NuevaTarea(tarea4);
        m.NuevaTarea(tarea5);
        m.NuevaTarea(tarea6);
        m.NuevaTarea(tarea7);
    }

    @Test
    public void testCompletados(){

        crearDatos();
        assertEquals(listaCompletados, m.filtrarCompletados(m.getTareas()));
    }

    @Test
    public void testNoCompletados(){
        crearDatos();
        assertEquals(listaNoCompletados, m.filtrarNoCompletados(m.getTareas()));
    }

    @Test
    public void testPrioridadAlta(){
        crearDatos();
        assertEquals(listaAltaPrioridad, m.filtrarPrioridadAlta(m.getTareas()));
    }

    @Test
    public void testAltaCompletado(){
        crearDatos();
        assertEquals(listaAltaCompletado, m.filtrarCompletados(m.filtrarPrioridadAlta(m.getTareas())));
    }

    @Test
    public void testBajaNoCompletado(){
        crearDatos();
        assertEquals(listaBajaNoCompletado, m.filtrarNoCompletados(m.filtrarPrioridadBaja(m.getTareas())));
    }
}
