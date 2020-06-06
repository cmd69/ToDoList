package controlador;

import modelo.InterfaceModelo;
import modelo.tareas.CrearTareas;
import modelo.tareas.FabricaTareas;
import modelo.tareas.Tarea;
import vista.InterfaceVista;

import javax.swing.*;
import java.util.LinkedList;

public class Controlador implements InterfaceControlador {

    private InterfaceModelo modelo;
    private InterfaceVista vista;
    private FabricaTareas fabricaTareas;

    public Controlador(){
        this.fabricaTareas = new CrearTareas();
    }

    public void setModelo(InterfaceModelo modelo){this.modelo = modelo; }
    public void setVista(InterfaceVista vista){this.vista = vista; }

    public LinkedList<Tarea> FiltroPrioridadAlta(){
        return modelo.filtrarPrioridadAlta(modelo.getTareas());
    }
    public LinkedList<Tarea> FiltroPrioridadMedia(){
        return modelo.filtrarPrioridadMedia(modelo.getTareas());
    }
    public LinkedList<Tarea> FiltroPrioridadBaja(){
        return modelo.filtrarPrioridadBaja(modelo.getTareas());
    }



    public LinkedList<Tarea> FiltroCompletado(LinkedList<Tarea> list){
        return modelo.filtrarCompletados(list);
    }

    public LinkedList<Tarea> FiltroNoCompletado(LinkedList<Tarea> list){
        return modelo.filtraNoCompletados(list);
    }

    @Override
    public LinkedList<Tarea> getTareas() {
        return modelo.getTareas();
    }
}
