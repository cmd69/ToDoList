package vista;

import controlador.InterfaceControlador;
import modelo.Exceptions.NoOptionSelected;
import modelo.InterfaceModelo;
import modelo.Tabla;
import modelo.tareas.Tarea;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

public class Vista implements InterfaceVista {

    private InterfaceModelo modelo;
    private Tabla tabla;
    private InterfaceControlador controlador;
    private JPanel cuerpo;
    private JPanel info;
    private JFrame ventana;
    private JPanel prioridad;
    private JPanel completada;
    private JButton aplicar;
    private VistaTable vistaTabla;
    private JTextArea desc;
    private JTextField titulo;
    private JCheckBox checkBox;
    private JRadioButton gnAlta;
    private JRadioButton gnMedia;
    private JRadioButton gnBaja;
    private ButtonGroup gPrioridad;
    private JRadioButton alta;
    private JRadioButton media;
    private JRadioButton baja;
    private JRadioButton pTodas;
    private JRadioButton nCompletada;
    private JRadioButton sCompletada;
    private JRadioButton cTodas;
    private Tabla tablaTareas;
    private JScrollPane panelTabla;
    private Tarea.Prioridad p;

    public Vista(){}
    public void setModelo(InterfaceModelo modelo){
        this.modelo = modelo;
    }
    public void setControlador(InterfaceControlador controlador){
        this.controlador = controlador;
    }

    public void run(){
        tablaTareas = new Tabla(getTareas());
        vistaTabla = new VistaTable(tablaTareas);

        //BASE
        ventana = new JFrame("To Do List");
        Container container = ventana.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        //PANEL PRIORIDAD
        gPrioridad = new ButtonGroup();
        alta = new JRadioButton("Alta");
        media = new JRadioButton("Media");
        baja = new JRadioButton("Baja");
        pTodas = new JRadioButton("Todas");
        pTodas.setSelected(true);
        gPrioridad.add(alta);
        gPrioridad.add(media);
        gPrioridad.add(baja);
        gPrioridad.add(pTodas);
        prioridad = new JPanel();
        prioridad.setLayout(new GridLayout(4, 1));
        prioridad.add(alta);
        prioridad.add(media);
        prioridad.add(baja);
        prioridad.add(pTodas);
        prioridad.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Priodidad"));

        //PANEL COMPLETADA
        ButtonGroup gCompletadas = new ButtonGroup();
        sCompletada = new JRadioButton("Completada");
        nCompletada = new JRadioButton("No completada");
        cTodas = new JRadioButton("Todas");
        cTodas.setSelected(true);
        gCompletadas.add(sCompletada);
        gCompletadas.add(nCompletada);
        gCompletadas.add(cTodas);
        completada = new JPanel();
        completada.setLayout(new GridLayout(4, 1));
        completada.add(sCompletada);
        completada.add(nCompletada);
        completada.add(cTodas);
        completada.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Completada"));

        //PANEL BOTON APLICAR
        JPanel panelAplicar = new JPanel();
        aplicar = new JButton("Aplicar Filtros");
        panelAplicar.add(aplicar);

        vistaTabla.getSelectionModel().addListSelectionListener(listSelectionEvent -> {
            setValores(getSelectedTarea());
        });

        //boton aplicar
        aplicar.addActionListener(actionEvent -> {
            LinkedList<Tarea> t = aplicarFiltros();
            //limpiarCampos();
            actualizarTabla(t);
        });

        //PANEL FILTROS
        JPanel filtros = new JPanel(new GridLayout());
        filtros.add(prioridad);
        filtros.add(completada);
        filtros.add(panelAplicar);

        //PANEL CUERPO
        cuerpo = new JPanel(new BorderLayout());
        cuerpo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Lista de tareas"));

        //tabla
        vistaTabla.setAutoCreateRowSorter(true);
        vistaTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panelTabla = new JScrollPane(vistaTabla);
        cuerpo.add(panelTabla);

        //PANEL INFO
        //titulo
        JPanel pTitulo = new JPanel();
        JLabel textoTitulo = new JLabel("Título: ");
        titulo = new JTextField(20);
        pTitulo.add(textoTitulo);
        pTitulo.add(titulo);

        //descripcion
        JPanel pDesc = new JPanel();
        JLabel textoDesc = new JLabel("Descripción: ");
        desc = new JTextArea(4, 40);
        pDesc.add(textoDesc);
        pDesc.add(desc);
        //completada
        checkBox = new JCheckBox("Completada");
        pTitulo.add(checkBox);


        info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Detalles de la tarea"));
        info.add(pTitulo);
        info.add(pDesc);


        //NUEVA TAREA BOTONES
        JPanel botonesNueva = new JPanel();
        botonesNueva.setLayout(new BoxLayout(botonesNueva, BoxLayout.X_AXIS));
        JButton nuevo = new JButton("Nuevo");
        JButton actualiza = new JButton("Actualiza");
        JButton borrar = new JButton("Borrar");
        botonesNueva.add(nuevo);
        botonesNueva.add(actualiza);
        botonesNueva.add(borrar);

        //LISTENER ACTUALIZAR
        actualiza.addActionListener(actionEvent -> {
            editarTarea();
            try {
                controlador.guardarCambios();
            } catch (IOException e) {
                e.printStackTrace();
            }
            actualizarTabla(aplicarFiltros());
        });

        //LISTENER BORRAR
        borrar.addActionListener(actionEvent -> {
            controlador.borrarTarea(getSelectedTarea());
            actualizarTabla(aplicarFiltros());
            limpiarCampos();
        });

        nuevo.addActionListener(actionEvent -> {
            try {
                nuevaTarea();
            } catch (NoOptionSelected noOptionSelected) {
                noOptionSelected.printStackTrace();
            }
            LinkedList<Tarea> t = aplicarFiltros();
            actualizarTabla(t);
        });

        //NUEVA TAREA FILTROS
        ButtonGroup gnPrioridad = new ButtonGroup();
        gnAlta = new JRadioButton("Alta");
        gnMedia = new JRadioButton("Media");
        gnBaja = new JRadioButton("Baja");
        gnPrioridad.add(gnAlta);
        gnPrioridad.add(gnMedia);
        gnPrioridad.add(gnBaja);
        JPanel gnPanel = new JPanel();
        gnPanel.setLayout(new BoxLayout(gnPanel, BoxLayout.X_AXIS));
        gnPanel.add(gnAlta);
        gnPanel.add(gnMedia);
        gnPanel.add(gnBaja);
        gnPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Priodidad"));
        JPanel gridGnPanel = new JPanel();
        gridGnPanel.setLayout(new GridLayout());
        gridGnPanel.add(gnPanel);

        //AÑADIR PANELES A LA VENTANA
        container.add(filtros);
        container.add(cuerpo);
        container.add(info);
        container.add(gridGnPanel);
        container.add(botonesNueva);

        //VALORES VENTANA
        ventana.setVisible(true);
        ventana.setSize(650, 650);
        //ventana.pack();
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
    }

    public void setValores(Tarea tarea) {
        if (tarea != null){
            titulo.setText(tarea.getTitulo());
            desc.setText(tarea.getDescripcion());
            checkBox.setSelected(tarea.getCompletado());
            if (tarea.getNivelPrioridad() == 1){
                gnAlta.setSelected(true);
            }else{
                if (tarea.getNivelPrioridad() == 2){
                    gnMedia.setSelected(true);
                }else{
                    gnBaja.setSelected(true);
                }
            }
        }
    }

    public LinkedList<Tarea> aplicarFiltros(){

        if (alta.isSelected()){
            return aplicarFiltroCompletado(controlador.FiltroPrioridadAlta());
        }else{
            if (media.isSelected()){
                return aplicarFiltroCompletado(controlador.FiltroPrioridadMedia());
            }else{
                if (baja.isSelected()){
                    return aplicarFiltroCompletado(controlador.FiltroPrioridadBaja());
                }else{
                    return aplicarFiltroCompletado(controlador.getTareas());
                }
            }
        }
    }

    public LinkedList<Tarea> aplicarFiltroCompletado(LinkedList<Tarea> lista){
        if (nCompletada.isSelected()){
            return controlador.FiltroNoCompletado(lista);
        }else{
            if (sCompletada.isSelected()){
                return controlador.FiltroCompletado(lista);
            }else{
                return lista;
            }
        }
    }

    public void actualizarTabla(LinkedList<Tarea> lista){
        tablaTareas = new Tabla(lista);
        vistaTabla.setModel(tablaTareas);
    }

    public void nuevaTarea() throws NoOptionSelected {
        comprobarDatos();
        controlador.nuevaTarea(titulo.getText(), desc.getText(), checkBox.isSelected(), p);
        //actualizarTabla(controlador.getTareas());
    }

    public void comprobarDatos() throws NoOptionSelected {
        JFrame j = new JFrame();
        if (gnAlta.isSelected()){
            p = Tarea.Prioridad.ALTA;
        }else{
            if (gnMedia.isSelected()){
                p = Tarea.Prioridad.MEDIA;
            }else{
                if (gnBaja.isSelected()){
                    p = Tarea.Prioridad.BAJA;
                }else{
                    new Disclaimer("Ninguna prioridad seleccionada", j, true);
                    throw new NoOptionSelected();
                }
            }
        }

        if (titulo.getText().isEmpty() || desc.getText().isEmpty()){
            new Disclaimer("El titulo o la descripción no pueden ser nulos", j, true);
            throw new NoOptionSelected();
        }
    }

    public void limpiarCampos(){
        titulo.setText(null);
        desc.setText(null);
    }

    public LinkedList<Tarea> getTareas(){
        return controlador.getTareas();
    }

    public Tarea getSelectedTarea(){

        Tarea t = null;
        int fila = vistaTabla.getSelectedRow();
        if (fila > -1){
            t = tablaTareas.getTarea(fila);
        }
        return t;
    }

    public void editarTarea(){
        if (getSelectedTarea() != null){
            getSelectedTarea().setValores(titulo.getText(), desc.getText(), checkBox.isSelected(), getSelectedPrioridad());
        }
    }

    public Tarea.Prioridad getSelectedPrioridad(){
        if (gnAlta.isSelected()){
            return Tarea.Prioridad.ALTA;
        }else{
            if (gnMedia.isSelected()){
                return Tarea.Prioridad.MEDIA;
            }else{
                return Tarea.Prioridad.BAJA;
            }
        }
    }
}
