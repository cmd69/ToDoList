package main;

import controlador.Controlador;
import modelo.Modelo;
import vista.Vista;

import java.io.IOException;

import static modelo.serializacion.Serializacion.cargarAgenda;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Modelo m = new Modelo();
        m.setTarea(cargarAgenda("Tareas.bin"));
        Vista v = new Vista();
        Controlador c = new Controlador();


        v.setModelo(m);
        v.setControlador(c);
        c.setModelo(m);
        c.setVista(v);

        v.run();
    }
}
